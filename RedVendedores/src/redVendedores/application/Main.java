package redVendedores.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import redVendedores.exceptions.UserException;
import redVendedores.model.RedVendedores;

public class Main extends Application {

    RedVendedores red = new RedVendedores("Red Vendedores");
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

    public boolean verificarUsuario(String usuario, String contrasenia){
        return red.verificarUsuario(usuario, contrasenia);
    }

    public boolean eliminarUsuario(String cedula){
        return red.eliminarUsuario(cedula);
    }

    public boolean actualizarUsuario(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        return red.actualizarUsuario(nuevoUsuario, contrasenia, cedula);
    }



}
