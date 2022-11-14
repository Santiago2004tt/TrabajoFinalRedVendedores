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

import java.io.IOException;


public class LoginController {
    Parent root;
    Scene scene;
    Stage stage;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField userField;

    Main main = new Main();


    @FXML
    void logInUser(ActionEvent event) throws IOException {
        logInEvet(event);

    }

    private void logInEvet(ActionEvent event) throws IOException {
        String user = "";
        String password = "";
        user = userField.getText();
        password = passwordField.getText();
        if(verificarCampos(user, password)){
            if(main.verificarUsuario(user, password)){
                mostrarPantallaprincipal(event);
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Datos incorrectos");
                alert.setContentText("Por favor verifica tus datos y vuelvelo a intentar");
                alert.showAndWait();
            }


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Completa todos los campos para poder continuar");
            alert.showAndWait();
        }


    }

    private void mostrarPantallaprincipal(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../views/VendedorView.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Bienvenido de vuelta!!");
        stage.setScene(scene);
        stage.show();
    }

    private boolean verificarCampos(String user, String password) {
        if(user.equals("")||password.equals("")){
            return false;
        }
        return true;
    }

    public void switchToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../views/signUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }
}
