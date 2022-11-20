package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import redVendedores.application.Main;
import redVendedores.exceptions.ProductoException;
import redVendedores.model.Producto;
import redVendedores.model.Vendedor;

public class VendedorController {

    ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();

    ObservableList<Vendedor> listaVendedoresData = FXCollections.observableArrayList();

    Producto productoSeleccionado = null;

    Vendedor vendedorSeleccionado = null;

    private Main main;

    Vendedor vendedorLogeado = null;
    @FXML
    private Button actualizarProductoButton;

    @FXML
    private Button cerrarSesionButton;

    @FXML
    private TableView<Vendedor> amigosTable;

    @FXML
    private TableColumn<Vendedor, String> apellidosAmigoColum;

    @FXML
    private Label bienvenidaLabel;

    @FXML
    private TableColumn<Producto, String> categoriaProductoColum;

    @FXML
    private Label categoriaProductoLabel;

    @FXML
    private TableColumn<Producto, String> codigoProductoColum;

    @FXML
    private Label codigoProductoLabel;

    @FXML
    private Label fechaLabel;


    @FXML
    private Button crearPublicacionButton;

    @FXML
    private Button eliminarProductoButton;

    @FXML
    private Label estadoProductoLabel;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Button irMuroButton;

    @FXML
    private TableColumn<Vendedor, String> nombreAmigoColum;

    @FXML
    private TableColumn<Vendedor, String> nombreProductoColum;

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private TableColumn<Producto, String> precioProductoColum;

    @FXML
    private Label precioProductoLabel;

    @FXML
    private Button solicitudesButton;

    @FXML
    private TableView<Producto> tableProductos;

    @FXML
    void actualizarProducto(ActionEvent event) {
        main.mostrarActualizarProducto(productoSeleccionado, vendedorLogeado);
    }

    @FXML
    void crearPublucacion(ActionEvent event) {
        main.mostrarCrearPublicacion(vendedorLogeado);

    }

    @FXML
    void eliminarProducto(ActionEvent event) throws ProductoException {
        eliminarProductoAction();


    }

    private void eliminarProductoAction() throws ProductoException {
        String codigo = "";
        codigo = productoSeleccionado.getCodigo();
        if(main.eliminarProducto(codigo, vendedorLogeado)){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Listo!!");
            alert.setContentText("Producto eliminado");
            alert.showAndWait();
            listaProductosData.remove(productoSeleccionado);
            limpiarCamposProducto();

        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Error :(");
            alert.setContentText("Imposible eliminar el producto");
            alert.showAndWait();
        }
    }

    private void limpiarCamposProducto() {
        nombreProductoLabel.setText("");
        estadoProductoLabel.setText("");
        categoriaProductoLabel.setText("");
        precioProductoLabel.setText("");
        codigoProductoLabel.setText("");
        imagenProducto.setImage(null);
    }

    @FXML
    void irMuroVendedor(ActionEvent event) {
        main.mostrarMuroVendedorAliado(vendedorLogeado, vendedorSeleccionado);


    }

    @FXML
    void obtenerSolicitudesAmistad(ActionEvent event) {

    }

    @FXML
    void initialize(){
        this.nombreProductoColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.categoriaProductoColum.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        this.precioProductoColum.setCellValueFactory(new PropertyValueFactory<>("precio"));
        this.codigoProductoColum.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        this.nombreAmigoColum.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.apellidosAmigoColum.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarDatosProducto(productoSeleccionado);
        });

        amigosTable.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
        });
    }



    private void mostrarDatosProducto(Producto productoSeleccionado) {
        nombreProductoLabel.setText(productoSeleccionado.getNombre());
        codigoProductoLabel.setText("Codigo: " + productoSeleccionado.getCodigo());
        precioProductoLabel.setText("Precio: " + productoSeleccionado.getPrecio());
        categoriaProductoLabel.setText("Categoria: " + productoSeleccionado.getCategoria());
        estadoProductoLabel.setText("Estado: "+ productoSeleccionado.getEstado());
        imagenProducto.setImage(productoSeleccionado.getImage());
        fechaLabel.setText("Fecha: " + productoSeleccionado.getDate());

    }


    public void setMain(Main main){
        this.main = main;
        tableProductos.getItems().clear();
        tableProductos.setItems(obtenerListaProductos());
        amigosTable.getItems().clear();
        amigosTable.setItems(obtenerListaVendedoresAliados());

    }

    private ObservableList<Vendedor> obtenerListaVendedoresAliados() {
        listaVendedoresData.addAll(main.obtenerListaVendedoresAliados(vendedorLogeado));
        return listaVendedoresData;
    }

    private ObservableList<Producto> obtenerListaProductos() {

        listaProductosData.addAll(main.obtenerListaProductos(vendedorLogeado));
        return listaProductosData;
    }

    public void mostrarBienvenida(Vendedor vendedor) {
        this.vendedorLogeado = vendedor;
        String nombre ="";
        nombre = vendedor.getNombre();
        bienvenidaLabel.setText("Que bueno verte de nuevo, " + nombre + "!!");
    }
    @FXML
    void cerrarSesion(ActionEvent event) {
        main.mostrarLogin();
    }
}
