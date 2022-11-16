package redVendedores.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import redVendedores.controllers.SignUpController;
import redVendedores.exceptions.UserException;
import redVendedores.model.RedVendedores;
import redVendedores.model.Vendedor;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private Stage stage;

    RedVendedores red = new RedVendedores("Red Vendedores");
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("../views/signUp.fxml"));
        //Scene scene = new Scene(root);
        //stage.setScene(scene);
        //stage.show();
        this.stage=stage;
        this.stage.setTitle("hola");
        mostrarPanelAdministrador();

    }

    private void mostrarPanelAdministrador() {
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../views/signUp.fxml"));
            AnchorPane rootLayout = loader.load();
            SignUpController controller = loader.getController();
            controller.setMain(this);

            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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


    public ArrayList<Vendedor> obtenerVendedores() {
        return red.getListaVendedores();
    }
}
