package redVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import redVendedores.model.Vendedor;

public class ChatsController {

    private Vendedor vendedorLogeado;
    private Vendedor vendedorAliado;

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

}
