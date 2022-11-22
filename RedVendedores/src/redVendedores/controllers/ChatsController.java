package redVendedores.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import redVendedores.application.Main;
import redVendedores.model.Vendedor;

public class ChatsController {




    private Vendedor vendedorLogeado;
    private Vendedor vendedorAliado;
    Main main;



    @FXML
    private Button btnEnviarMensaje;

    @FXML
    private Button btnRegresar;


    @FXML
    private TextField txtMensaje;

    @FXML
    void enviarMensaje(ActionEvent event) {
        String mensaje = "";
        mensaje = txtMensaje.getText();
        if(verificarCampos(mensaje)){
            boolean enviarMensaje = main.enviarMensaje(mensaje, vendedorLogeado, vendedorAliado);
            if (enviarMensaje){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Listo!!");
                alert.setContentText("Mensaje enviado");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/Stylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
                txtMensaje.clear();
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Error!!");
                alert.setContentText("No se pudo enviar el mensaje, intenta de nuevo");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/Stylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
            }
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Al parecer vas a enviar un mensaje vacio");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/Stylesheets.css").toExternalForm());
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
    void regresar(ActionEvent event) {
        main.mostrarMuroVendedorAliado(vendedorLogeado,vendedorAliado);

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



}
