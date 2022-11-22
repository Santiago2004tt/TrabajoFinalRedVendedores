package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import redVendedores.application.Main;
import redVendedores.exceptions.VendedorException;
import redVendedores.model.Administrador;
import redVendedores.model.Vendedor;

import java.util.ArrayList;

public class RecomendacionVendedoresAliadosController {

    Main main = new Main();
    ObservableList<Vendedor> listaVendedorData= FXCollections.observableArrayList();
    Vendedor vendedorSeleccionado = null;
    Vendedor vendedorLogeado;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnCambiarPagina;

    @FXML
    private Button btnEnviarSolicitud;

    @FXML
    private TableColumn<Vendedor, String> columnApellidoRecomendacion;

    @FXML
    private TableColumn<Vendedor, String> columnNombreRecomendacion;

    @FXML
    private TableView<Vendedor> tableRecomendaciones;

    @FXML
    private Button txtBuscarVendedor;

    @FXML
    private TextField txtFiltroMeGusta;

    @FXML
    void cambiarSolicitudes(ActionEvent event) {

    }

    @FXML
    void enviarSolicitud(ActionEvent event) {
        enviarSolicitudAction();
    }

    private void enviarSolicitudAction() {
        if(vendedorSeleccionado == null){
            mostrarMensaje("Notificacion Vendedor", "Selecciona vendedor", "Debe seleccionar vendedor", Alert.AlertType.ERROR);
        }else{
            boolean enviarSolicitud =  main.enviarSolicitud(vendedorLogeado, vendedorSeleccionado);
            mostrarMensaje("Notificacion Vendedor", "Selecciona vendedor", "El vendedor", Alert.AlertType.INFORMATION);
            if(enviarSolicitud){
                mostrarMensaje("Notificacion Vendedor", "El vendedor ", "El vendedor ya tiene solicitud", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void initialize(){
        this.columnNombreRecomendacion.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnApellidoRecomendacion.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableRecomendaciones.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
        });
    }

    public void setMain(Main main) throws VendedorException {
        this.main = main;
        tableRecomendaciones.getItems().clear();
        tableRecomendaciones.setItems((ObservableList<Vendedor>) main.obtenerListaVendedoresRecomendados(vendedorLogeado));
    }

    private ObservableList<Vendedor> obtenerListaVendedores() throws VendedorException {
        listaVendedorData.addAll(obtenerListaVendedores());
        return listaVendedorData;
    }

    public void actualizarTablaRecomendados(String cedula) throws VendedorException {
        main.actualizarTablaRecomendados(cedula);
    }

    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado = vendedorLogeado;
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
}
