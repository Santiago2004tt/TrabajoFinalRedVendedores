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

public class SignUpController {

    Parent root;
    Scene scene;
    Stage stage;
    @FXML
    private Button goBackButton;

    @FXML
    private Button signUpButton;

    @FXML
    private TextField upAddressField;

    @FXML
    private TextField upIDField;

    @FXML
    private TextField upNameField;

    @FXML
    private PasswordField upPasswordField;

    @FXML
    private TextField upSurnameField;

    @FXML
    private TextField upUserField;

    Main main = new Main();
    public void goBack(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }


    public void regiserSeller(ActionEvent event) throws IOException {
        //registerSellerAction(event);


    }


    private void registerSellerAction(ActionEvent event) throws IOException {
        String name = "";
        String apellidos = "";
        String cedula = "";
        String direccion = "";
        String password = "";
        String user = "";
        name = upNameField.getText();
        apellidos = upSurnameField.getText();
        cedula = upIDField.getText();
        direccion = upAddressField.getText();
        password = upPasswordField.getText();
        user =upUserField.getText();
        if(verificarCampos(name, apellidos, direccion, cedula, password, user)){
            if(main.vendedorExiste(cedula)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Atencion");
                alert.setContentText("El vendedor que intentas crear ya existe");
                alert.showAndWait();
                goBack(event);
            }else{
                Vendedor nuevoVendedor = main.crearVendedor(name, apellidos, direccion, cedula, password, user);
                if(nuevoVendedor != null){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Listo");
                    alert.setContentText("Vendedor creado exitosamente");
                    alert.showAndWait();
                    goBack(event);
                }
            }


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Completa todos los campos para poder continuar");
            alert.showAndWait();
        }


    }


    private boolean verificarCampos(String name, String apellidos, String direccion, String cedula, String password, String user) {
        if(name.equals("")){
            return false;
        }
        if(apellidos.equals("")){
            return false;
        }
        if(direccion.equals("")){
            return false;
        }
        if(cedula.equals("")){
            return false;
        }
        if(password.equals("")){
            return false;
        }
        if(user.equals("")){
            return false;
        }
        return true;
    }
}
