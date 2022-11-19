package redVendedores.application;

//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import redVendedores.controllers.LoginController;
import redVendedores.controllers.SignUpController;
import redVendedores.exception.VendedorException;
import redVendedores.exceptions.UserException;
import redVendedores.model.Cuenta;
import redVendedores.model.RedVendedores;
import redVendedores.model.Usuario;
import redVendedores.model.Vendedor;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    //create variable
    private Stage stage;

    RedVendedores red = new RedVendedores("Red Vendedores");
    @Override
    public void start(Stage stage) throws Exception {
        //inicializa el fxml
        this.stage=stage;
        this.stage.setTitle("hola");
        mostrarPanelAdministrador();

    }

    private void mostrarPanelAdministrador() {
        try{
            //carga el fxml
            FXMLLoader loader = new FXMLLoader();
            //localiza el fxml
            loader.setLocation(Main.class.getResource("../views/signUp.fxml"));
            AnchorPane rootLayout = loader.load();
            //invoca los controladores
            SignUpController controller = loader.getController();
            controller.setMain(this);
            //inicializa la escena
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

    //metodo para verificar un usuario
    public boolean verificarUsuario(String usuario, String contrasenia){
        return red.verificarUsuario(usuario, contrasenia);
    }

    //metodo para eliminar a un usuario
    public boolean eliminarUsuario(String cedula){
        return red.eliminarCuenta(cedula);
    }

    //metodo para actualizar a un usuario
    public boolean actualizarCuenta(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        return red.actualizarCuenta(nuevoUsuario, contrasenia, cedula);
    }

    //Metodo para obtener la lista de vendedores
    public ArrayList<Vendedor> obtenerVendedores() {
        return red.getListaVendedores();
    }

    /**
     * metodo para verificar si el vendedor ya a sido creado
     * @param cedula
     * @return
     */
    public boolean vendedorExiste(String cedula) {
        return red.existeVendedor(cedula);
    }

    /**
     * metodo para crear un vendedor
     * @param name
     * @param apellidos
     * @param direccion
     * @param cedula
     * @param usuario
     * @return
     * @throws VendedorException
     */
    public Vendedor crearVendedor(String name, String apellidos, String direccion, String cedula, Cuenta cuenta) throws VendedorException {
        return red.nuevoVendedor(name, apellidos, direccion, cedula, cuenta);
    }

    /**
     * metodo para eliminar un vendedor
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor(String cedula)  {
        return red.eliminarVendedor(cedula);
    }

    /**
     * metodo para actualizar vendedor
     *
     * @param cedula
     * @param nombre
     * @param apellido
     * @param direccion
     * @param cedula1
     */
    public void actualizarVendedor(String cedula, String nombre, String apellido, String direccion, String cedula1) {
        red.actualizarVendedor(nombre,apellido,cedula,direccion);
    }

    public Cuenta crearUsuario(String user, String password) throws UserException {
        return red.crearCuenta(user, password);
    }
}
