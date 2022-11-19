package redVendedores.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import redVendedores.application.Main;
import redVendedores.model.Vendedor;

import java.io.IOException;

public class LoginController {

    private Main main;

    @FXML
    private Button loginButton;

    @FXML
    private Button btnIngresarAdministrador;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField userField;

    @FXML
    void logInUser(ActionEvent event) throws IOException {
        logInEvet(event);

    }

    @FXML
    void iniciarSesionAdministrador(ActionEvent event) {
        main.mostrarLoginAdministrador();
    }

    private void logInEvet(ActionEvent event) throws IOException {
        String user = "";
        String password = "";
        user = userField.getText();
        password = passwordField.getText();
        if(verificarCampos(user, password)){
            if(main.verificarUsuario(user, password)){
                Vendedor vendedor = main.obtenerVendedor(user,password);
                main.mostrarPanelVendedor(vendedor);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Datos incorrectos");
                alert.setContentText("Por favor verifica tus datos y vuelve a intentar");
                alert.showAndWait();
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Completa todos los campos para poder continuar");
            alert.showAndWait();
        }
    }



    private boolean verificarCampos(String user, String password) {
        if(user.equals("")||password.equals("")){
            return false;
        }
        return true;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

