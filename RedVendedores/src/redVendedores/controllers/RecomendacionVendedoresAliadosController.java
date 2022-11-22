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
    private Vendedor vendedorLogeado;

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
        main.mostrarSolicitudes(vendedorLogeado);
    }
    @FXML
    void buscarVendedor(ActionEvent event) {
        buscarVendedorAction();
    }


    private void buscarVendedorAction() {
        main.actualizarTablaRecomendados(vendedorLogeado);
        listaVendedorData.removeAll(main.obtenerListaVendedoresRecomendados(vendedorLogeado));
        tableRecomendaciones.refresh();
        aniadirTabla();
        tableRecomendaciones.refresh();
        mostrarMensaje("Notificacion Vendedor", "Vendedores encontrados", "Los vendedores se han encontrado", Alert.AlertType.INFORMATION);
    }

    private void aniadirTabla() {
        listaVendedorData.addAll(main.obtenerListaVendedoresRecomendados(vendedorLogeado));
        tableRecomendaciones.setItems(listaVendedorData);
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
            mostrarMensaje("Notificacion Vendedor", "La invitacion fue enviada", "la solicitud fue enviada con exito", Alert.AlertType.INFORMATION);
            listaVendedorData.remove(vendedorSeleccionado);
            tableRecomendaciones.refresh();
            if(enviarSolicitud == false){
                mostrarMensaje("Notificacion Vendedor", "El vendedor ya tiene solicitud ", "El vendedor ya tiene una solicitud", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void regresar(ActionEvent event) {
        main.mostrarPanelVendedor(vendedorLogeado);

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
        tableRecomendaciones.setItems(obtenerListaVendedoresRecomendados());
    }

    private ObservableList<Vendedor> obtenerListaVendedoresRecomendados() throws VendedorException {
        listaVendedorData.addAll(main.obtenerListaVendedoresRecomendados(vendedorLogeado));
        return listaVendedorData;
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
        dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");
        alert.showAndWait();
    }
}
