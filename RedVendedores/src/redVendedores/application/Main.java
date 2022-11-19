package redVendedores.application;

//imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import redVendedores.controllers.*;
import redVendedores.exception.ProductoException;
import redVendedores.exception.VendedorException;
import redVendedores.exceptions.UserException;
import redVendedores.model.*;

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
        mostrarLogin();

    }

    public Stage getPrimaryStage() {
        return stage;
    }


    public void mostrarLogin() {
        try{
            //carga el fxml
            FXMLLoader loader = new FXMLLoader();
            //localiza el fxml
            loader.setLocation(Main.class.getResource("../views/Login.fxml"));
            AnchorPane rootLayout = loader.load();
            //invoca los controladores
            LoginController controller = loader.getController();
            controller.setMain(this);
            //inicializa la escena
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Que bueno verte de vuelta!!");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPanelAdimintrador(){
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
            stage.setTitle("Que bueno verte de vuelta!!");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarPanelVendedor(Vendedor vendedor){
        try{
            //carga el fxml
            FXMLLoader loader = new FXMLLoader();
            //localiza el fxml
            loader.setLocation(Main.class.getResource("../views/VendedorView.fxml"));
            AnchorPane rootLayout = loader.load();
            //invoca los controladores
            VendedorController controller = loader.getController();
            controller.mostrarBienvenida(vendedor);
            controller.setMain(this);
            //inicializa la escena
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Que bueno verte de vuelta!!");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarCrearPublicacion(Vendedor vendedor) {
        try{
            //carga el fxml
            FXMLLoader loader = new FXMLLoader();
            //localiza el fxml
            loader.setLocation(Main.class.getResource("../views/CrearPublicacion.fxml"));
            AnchorPane rootLayout = loader.load();
            //invoca los controladores
            CrearPublicacionController controller = loader.getController();
            controller.obtenertvendedor(vendedor);
            controller.setMain(this);
            //inicializa la escena
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Que quieres vender hoy?");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarActualizarProducto(Producto productoSeleccionado, Vendedor vendedor ) {
        try{
            //carga el fxml
            FXMLLoader loader = new FXMLLoader();
            //localiza el fxml
            loader.setLocation(Main.class.getResource("../views/ActualizarProducto.fxml"));
            AnchorPane rootLayout = loader.load();
            //invoca los controladores
            ActualizarProductoController controller = loader.getController();
            controller.obtenerProducto(productoSeleccionado);
            controller.obtenerVendedor(vendedor);
            controller.setMain(this);
            //inicializa la escena
            Scene scene = new Scene(rootLayout);
            stage.setScene(scene);
            stage.setTitle("Actualiza tu publicacion a continuacion");
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
        return red.eliminarUsuario(cedula);
    }

    //metodo para actualizar a un usuario
    public boolean actualizarUsuario(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        return red.actualizarUsuario(nuevoUsuario, contrasenia, cedula);
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
    public Vendedor crearVendedor(String name, String apellidos, String direccion, String cedula, Usuario usuario) throws VendedorException {
        return red.nuevoVendedor(name, apellidos, direccion, cedula, usuario);
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
     * @param cedula
     * @param nombre
     * @param apellido
     * @param direccion
     * @param cedula1
     * @param usuario
     */
    public void actualizarVendedor(String cedula, String nombre, String apellido, String direccion, String cedula1, Usuario usuario) {
        red.actualizarVendedor(nombre,apellido,cedula,direccion, usuario);
    }

    public Vendedor obtenerVendedor(String user, String password) {
        return red.obtenerVendedor(user,password);
    }

    public ArrayList<Producto> obtenerListaProductos(Vendedor vendedor) {
        return red.getListaProductos(vendedor);
    }

    public ArrayList<Vendedor> obtenerListaVendedoresAliados(Vendedor vendedor) {
        return red.obtenerlistaVendedoresAliados(vendedor);
    }


    public boolean crearPublicacion(String nombre, String codigo, double precio, String categoria, Image image, Vendedor vendedor) throws ProductoException {
        return red.crearProducto(nombre, codigo, categoria, precio, image, vendedor);
    }

    public boolean eliminarProducto(String codigo, Vendedor vendedor) throws ProductoException {
        return red.eliminarProducto(codigo, vendedor);
    }


    public boolean actualizarProducto(String nombre, String codigo, Estado estado, String categoria, double precio, Image image, Vendedor vendedor) {
        return red.actualizarProducto(nombre, codigo, categoria, precio, estado, vendedor, image );
    }
}
