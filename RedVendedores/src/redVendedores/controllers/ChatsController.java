package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import redVendedores.application.Main;
import redVendedores.model.Mensaje;
import redVendedores.model.Vendedor;

public class ChatsController {

    private Vendedor vendedorLogeado;
    private Vendedor vendedorAliado;
    Main main;
    ObservableList<Mensaje> listaMensajeData= FXCollections.observableArrayList();
    Mensaje mensajeSeleccionado = null;


    @FXML
    private Button btnEnviarMensaje;

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<?, ?> columnLocal;

    @FXML
    private TableColumn<?, ?> columnVisitante;

    @FXML
    private TableView<?> tableListaMensajesLocales;

    @FXML
    private TableView<?> tableListaMensajesVisitante;

    @FXML
    private TextField txtMensaje;

    @FXML
    void enviarMensaje(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void obtenerVendedorLogeado(Vendedor vendedorLogeado) {
        this.vendedorLogeado=vendedorLogeado;
    }

    public void obtenerVendedorAliado(Vendedor vendedorAliado) {
        this.vendedorAliado=vendedorAliado;
    }


    // -------------------------Inicializar la primera tabla ------------------------------------

    void initialize(){
        this.columnLocal.setCellValueFactory(new PropertyValueFactory<>("mensaje"));
        tableListaMensajesLocales.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = (Mensaje) newSelection;
        });
    }

    private ObservableList<Mensaje> obtenerMensajesLogeado() {
        listaMensajeData.addAll(main.obtenerMensajes(vendedorLogeado, vendedorAliado));
        return listaMensajeData;
    }

    //---------------------------Inicializar la segunda tabla-------------------------------

    void initializeSegunda(){
        this.columnVisitante.setCellValueFactory(new PropertyValueFactory<>("mensaje"));
        tableListaMensajesVisitante.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            mensajeSeleccionado = (Mensaje) newSelection;
        });
    }

    private ObservableList<Mensaje> obtenerMensajesVisitantes() {
        listaMensajeData.addAll(main.obtenerMensajes(vendedorAliado, vendedorLogeado));
        return listaMensajeData;
    }


}
