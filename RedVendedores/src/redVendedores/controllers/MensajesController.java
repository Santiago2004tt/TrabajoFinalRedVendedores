package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import redVendedores.application.Main;
import redVendedores.model.Comentario;
import redVendedores.model.Mensaje;
import redVendedores.model.Producto;
import redVendedores.model.Vendedor;

public class MensajesController {

    ObservableList<Mensaje> listaMensajesData = FXCollections.observableArrayList();

    Mensaje mensajeSeleccionado;

    Vendedor autor;

    Vendedor vendedorLogeado;

    Main main;
    @FXML
    private TableColumn<Mensaje, String> autorColum;

    @FXML
    private Button irAtras;

    @FXML
    private TableColumn<Mensaje, String> mensajeColum;

    @FXML
    private TextField mensajeField;

    @FXML
    private Button responderButton;

    @FXML
    private TableView<Mensaje> tableMensajes;

    @FXML
    private Label mensajeLabel;


    @FXML
    private Label nombreAutorLabel;


    @FXML
    void irAtras(ActionEvent event) {
        main.mostrarPanelVendedor(vendedorLogeado);

    }

    @FXML
    void responderMensaje(ActionEvent event) {
        responderMensajeAction();

    }

    private void responderMensajeAction() {
        String mensaje = "";
        mensaje = mensajeField.getText();
        if(verificarCampos(mensaje)){
            boolean enviarMensaje = main.respoderMensaje(mensaje, vendedorLogeado, autor);
            if (enviarMensaje){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Listo!!");
                alert.setContentText("Mensaje enviado");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
                mensajeField.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Error!!");
                alert.setContentText("No se pudo enviar el mensaje, intenta de nuevo");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Al parecer vas a enviar un mensaje vacio");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog");
            alert.showAndWait();
        }
    }

    private boolean verificarCampos(String mensaje) {
        if(mensaje.equals("")){
            return false;
        }
        return true;
    }

    @FXML
    void initialize(){
        this.mensajeColum.setCellValueFactory(new PropertyValueFactory<>("contenido"));
        this.autorColum.setCellValueFactory(new PropertyValueFactory<>("autor"));


        tableMensajes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = newSelection;
            mostrarDatosMensaje(mensajeSeleccionado);

        });

    }

    private void mostrarDatosMensaje(Mensaje mensajeSeleccionado) {
        String nombreAutor = mensajeSeleccionado.getAutor().getNombre();
        this.autor = mensajeSeleccionado.getAutor();
        mensajeLabel.setText(mensajeSeleccionado.getContenido());
        nombreAutorLabel.setText(nombreAutor);
    }

    private ObservableList<Mensaje> obtenerListaMensajes() {
        listaMensajesData.addAll(main.obtenerListaMensajes(vendedorLogeado));
        return listaMensajesData;
    }


    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
    }

    public void setMain(Main main) {
        this.main = main;
        tableMensajes.getItems().clear();
        tableMensajes.setItems(obtenerListaMensajes());

    }




}
