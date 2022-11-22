package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import redVendedores.application.Main;
import redVendedores.model.Comentario;
import redVendedores.model.Producto;
import redVendedores.model.Vendedor;

public class VendedorAliadoController {

    ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
    ObservableList<Comentario> listaComentariosDate = FXCollections.observableArrayList();

    Main main;

    Comentario comentarioSeleccionado;
    Producto productoSeleccionado;

    Vendedor vendedorSeleccionado;

    Vendedor vendedorLogeado;

    Vendedor vendedorAliado;

    @FXML
    private Label ApellidoLabel;

    @FXML
    private TableColumn<Producto, String> categoriaColum;

    @FXML
    private Label categoriaProductolabel;

    @FXML
    private Button chatButton;

    @FXML
    private TextField comentarioField;

    @FXML
    private Label numeroMeGusta;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private TableColumn<Producto, String> codigoColum;

    @FXML
    private Label codigoProductoLabel;

    @FXML
    private Button comentarButton;

    @FXML
    private TableColumn<Comentario, String> comentariosColum;

    @FXML
    private Label estadoProductoLabel;

    @FXML
    private Button meGustaButton;

    @FXML
    private TableColumn<Producto, String> nombreColum;

    @FXML
    private Label nombreLabel;

    @FXML
    private Label fechaLabel;

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private TableColumn<Vendedor, String> precioColum;

    @FXML
    private Label precioProductoLabel;

    @FXML
    private TableView<Comentario> tableComentarios;

    @FXML
    private TableView<Producto> tableProductos;

    @FXML
    private Button volverButton;

    @FXML
    void irChat(ActionEvent event) {
        main.mostrarChat(this.vendedorLogeado,this.vendedorAliado);
    }

    @FXML
    void meGusta(ActionEvent event) {
        meGustaAction();
    }

    private void meGustaAction() {
        if(main.verificarExisteMeGusta(vendedorLogeado, vendedorAliado)){
            boolean meGustaAgregado = main.agregarMeGusta(vendedorLogeado, vendedorAliado);
            if(meGustaAgregado){
                int cantidadMeGusta = main.contarMeGustas(vendedorAliado);
                numeroMeGusta.setText("" + cantidadMeGusta);
            }
        }else{
            main.quitarMeGusta(vendedorLogeado, vendedorAliado);
            int cantidadMeGusta = main.contarMeGustas(vendedorAliado);
            numeroMeGusta.setText("" + cantidadMeGusta);
        }
    }

    @FXML
    void volverAtras(ActionEvent event) {
        main.mostrarPanelVendedor(vendedorLogeado);
    }

    public void setMain(Main main) {
        this.main = main;
        tableProductos.getItems().clear();
        tableProductos.setItems(obtenerListaProductos());
        tableComentarios.getItems().clear();
        tableComentarios.setItems(obtenerListaComentarios());
    }

    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;

    }

    public void obtenerVendedorAliado(Vendedor vendedorSeleccionado) {
        this.vendedorAliado = vendedorSeleccionado;
        int cantidadMeGusta = vendedorSeleccionado.getListaMeGusta().size();
        String nombre = vendedorSeleccionado.getNombre();
        String apellido = vendedorSeleccionado.getApellido();
        nombreLabel.setText("Nombre: " + nombre);
        ApellidoLabel.setText("Apellido: " + apellido);
        numeroMeGusta.setText("" + cantidadMeGusta);
    }
    @FXML
    void initialize(){
        this.nombreColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.categoriaColum.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.precioColum.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.codigoColum.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.comentariosColum.setCellValueFactory(new PropertyValueFactory<>("mensaje"));

        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarDatosProducto(productoSeleccionado);
        });

        tableComentarios.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            comentarioSeleccionado = newSelection;
        });
    }

    private void mostrarDatosProducto(Producto productoSeleccionado) {
        nombreProductoLabel.setText(productoSeleccionado.getNombre());
        codigoProductoLabel.setText("Codigo: " + productoSeleccionado.getCodigo());
        precioProductoLabel.setText("Precio: " + productoSeleccionado.getPrecio());
        estadoProductoLabel.setText("Estado: " + productoSeleccionado.getEstado());
        categoriaProductolabel.setText("Categoria: " + productoSeleccionado.getCategoria());
        fechaLabel.setText("Fecha: " + productoSeleccionado.getDate());
        imagenProducto.setImage(productoSeleccionado.getImage());
    }

    private ObservableList<Producto> obtenerListaProductos() {
        listaProductosData.addAll(main.obtenerListaProductos(vendedorAliado));
        return listaProductosData;
    }

    private ObservableList<Comentario> obtenerListaComentarios() {
        listaComentariosDate.addAll(main.obtenerListaComentarios(vendedorAliado));
        return listaComentariosDate;
    }

    @FXML
    void agregarComentario(ActionEvent event) {
        agregarComentarioAction();

    }

    private void agregarComentarioAction() {
        String mensaje ="";
        mensaje = comentarioField.getText();
        if(mensaje.equals("")){
            mostrarMensaje("Notificacion Vendedor", "El vendedor", "Rellena el comentario", Alert.AlertType.ERROR);
        }else{
            Comentario comentarioAgregado = main.agregarComenterio(vendedorLogeado, vendedorAliado, mensaje);
            listaComentariosDate.add(comentarioAgregado);
            tableComentarios.refresh();
            mostrarMensaje("Notificacion Vendedor", "El vendedor", "Se envio correctamente el mensaje", Alert.AlertType.INFORMATION);
        }
    }

    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/Stylesheets.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");
        alert.showAndWait();
    }

    private boolean verificarTexto(String mensaje) {
        if(mensaje.equals("")){
            return false;
        }
        return true;
    }

}
