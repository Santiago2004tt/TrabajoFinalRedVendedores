package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import redVendedores.application.Main;
import redVendedores.exceptions.VendedorException;
import redVendedores.model.Vendedor;

public class SolicitudesController {

    Main main = new Main();
    ObservableList<Vendedor> listaVendedorData= FXCollections.observableArrayList();
    Vendedor vendedorSeleccionado = null;

    private Vendedor vendedorLogeado;

    @FXML
    private Button btnAceptarSolicitud;

    @FXML
    private Button btnRechazarSolicitud;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<Vendedor, String> columnApellido;

    @FXML
    private TableColumn<Vendedor, String> columnNombre;

    @FXML
    private TableView<Vendedor> tableListaSolicitudes;

    @FXML
    void aceptarSolicitud(ActionEvent event) {
        aceptarSolicitudAction();
    }

    private void aceptarSolicitudAction() {
        if(vendedorSeleccionado == null){
            mostrarMensaje("Notificacion Vendedor", "Selecciona vendedor", "Debe seleccionar vendedor", Alert.AlertType.ERROR);
        }else{
            main.aceptarSolicitud(vendedorLogeado, vendedorSeleccionado);
            mostrarMensaje("Notificacion Vendedor", "El vendedor", "Se acepto la solicitud", Alert.AlertType.INFORMATION);
            listaVendedorData.remove(vendedorSeleccionado);
            tableListaSolicitudes.refresh();
        }
    }

    @FXML
    void rechazarSolicitud(ActionEvent event) {
        if(vendedorSeleccionado == null){
            mostrarMensaje("Notificacion Vendedor", "Selecciona vendedor", "Debe seleccionar vendedor", Alert.AlertType.ERROR);
        }else{
            main.rechazarSolicitud(vendedorLogeado, vendedorSeleccionado);
            mostrarMensaje("Notificacion Vendedor", "El vendedor", "Se acepto la solicitud", Alert.AlertType.INFORMATION);
            listaVendedorData.remove(vendedorSeleccionado);
            tableListaSolicitudes.refresh();
        }
    }

    @FXML
    void regresar(ActionEvent event) {
        main.mostrarRecomendaciones(vendedorLogeado);
    }

    @FXML
    void initialize(){
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tableListaSolicitudes.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
        });
    }

    public void setMain(Main main) throws VendedorException {
        this.main = main;
        tableListaSolicitudes.getItems().clear();
        tableListaSolicitudes.setItems(obtenerListaSolicitudes());
    }

    private ObservableList<Vendedor> obtenerListaSolicitudes() throws VendedorException {
        listaVendedorData.addAll(main.obtenerListaSolicitudes(vendedorLogeado));
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
        dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/Stylesheets.css").toExternalForm());
        dialogPane.getStyleClass().add("dialog");
        alert.showAndWait();
    }



}
