package redVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.AccessibleAction;
import javafx.scene.control.*;
import redVendedores.application.Main;
import redVendedores.model.Administrador;
import redVendedores.model.Vendedor;

public class LoginAdministradorController {

    Main main;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegresar;

    @FXML
    private PasswordField txtClave;

    @FXML
    private TextField txtUsuario;

    @FXML
    void iniciarSesionAdministrador(ActionEvent event) {
        iniciarSesionAdministradorAction(event);
    }

    private void iniciarSesionAdministradorAction(ActionEvent event) {
        String user = "";
        String password = "";
        user = txtUsuario.getText();
        password = txtClave.getText();

        if(verificarCampos(user, password)){
            if(main.verificarUsuarioAdministrador(user, password)){
                Administrador administrador = main.obtenerAdministrador(user,password);
                main.mostrarPanelAdimintrador(administrador);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Datos incorrectos");
                alert.setContentText("Por favor verifica tus datos y vuelve a intentar");
                DialogPane dialogPane = alert.getDialogPane();
                dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
                dialogPane.getStyleClass().add("dialog");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Completa todos los campos para poder continuar");
            DialogPane dialogPane = alert.getDialogPane();
            dialogPane.getStylesheets().add(getClass().getResource("../stylesheets/AlertsStylesheets.css").toExternalForm());
            dialogPane.getStyleClass().add("dialog");
            alert.showAndWait();
        }
    }

    private boolean verificarCampos(String user, String password) {
        if(user.equals("") || password.equals("")){
            return false;
        }
        return true;
    }

    @FXML
    void regresar(ActionEvent event) {
        main.mostrarLogin();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}