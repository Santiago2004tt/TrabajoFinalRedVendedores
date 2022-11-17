package redVendedores.controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import redVendedores.application.Main;
import redVendedores.exception.VendedorException;
import redVendedores.model.Estado;
import redVendedores.model.Usuario;
import redVendedores.model.Vendedor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class SignUpController {

    Main main = new Main();
    ObservableList<Vendedor> listaVendedorData= FXCollections.observableArrayList();
    Vendedor vendedorSeleccionado = null;
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnCrear;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<Vendedor, String> columnApellido;

    @FXML
    private TableColumn<Vendedor, String> columnCedula;

    @FXML
    private TableColumn<Vendedor, String> columnDireccion;

    @FXML
    private TableColumn<Vendedor, String> columnNombre;

    @FXML
    private TableView<Vendedor> tableListaVendedores;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtClave;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtNombre;

    @FXML
    private Label txtNombreBienvenida;

    @FXML
    private TextField txtUsuario;

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    void actualizarVendedor(ActionEvent event) {
        actualizarVendedorAction();
    }

    private void actualizarVendedorAction() {
        String nombre = txtNombre.getText();
        String apellido = txtApellidos.getText();
        String direccion = txtDireccion.getText();
        String cedula = txtCedula.getText();
        String usuario = txtUsuario.getText();
        String contrasenia = txtClave.getText();


        if(vendedorSeleccionado == null){
            mostrarMensaje("Notificacion vendedor", "Selecciona vendedor", "Debe seleccionar vendedor", Alert.AlertType.ERROR);
        }else{
            //2. Validar la informaci�n
            if(verificarCampos(nombre, apellido, direccion, cedula,contrasenia,usuario) == true){
                Usuario usuarioNuevo = new Usuario(usuario, contrasenia);
                main.actualizarVendedor(vendedorSeleccionado.getCedula(),nombre, apellido, direccion, cedula,usuarioNuevo);
                tableListaVendedores.refresh();
            }else{
                mostrarMensaje("Notificaci�n Estudiante", "Estudiante no actualizado", "Datos invalidos", Alert.AlertType.ERROR);

            }

        }
    }

    @FXML
    void cerrarSesion(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void crearVendedor(ActionEvent event) throws VendedorException {
        crearVendedorAction();
    }

    private void crearVendedorAction() throws VendedorException {
        String name = txtNombre.getText();
        String apellidos = txtApellidos.getText();
        String cedula = txtCedula.getText();
        String direccion = txtDireccion.getText();
        String password = txtClave.getText();
        String user =txtUsuario.getText();
        Usuario usuario = new Usuario(user, password);
        if(verificarCampos(name, apellidos, direccion, cedula, password, user) == true){

            Vendedor vendedor = null;
            try {
                vendedor = main.crearVendedor(name, apellidos, cedula, direccion, usuario);
                listaVendedorData.add(vendedor);
                mostrarMensaje("Notificacion vendedor", "Vendedor registrado", "El Vendedor se ha registrado con exito", Alert.AlertType.INFORMATION);
                limpiarDatos();
            } catch (VendedorException e){
                mostrarMensaje("Notificacion vendedor", "El vendedor no registrado", "El vendedor con cedula "+cedula+" ya se encuentra registrado", Alert.AlertType.ERROR);
            }
        }
    }

    @FXML
    void eliminarVendedor(ActionEvent event) {
        eliminarVendedorAction();
    }

    private void eliminarVendedorAction() {
        if(vendedorSeleccionado == null){
            mostrarMensaje("Notificacion Estudiante", "Selecciona vendedor", "Debe seleccionar vendedor", Alert.AlertType.ERROR);
        }else{
            boolean eliminado = main.eliminarVendedor(vendedorSeleccionado.getCedula());
            if(eliminado){
                listaVendedorData.remove(vendedorSeleccionado);
                vendedorSeleccionado = null;
                limpiarDatos();
                tableListaVendedores.refresh();
                tableListaVendedores.getSelectionModel().clearSelection();
                mostrarMensaje("Notificacion vendedor", "Vendedor eliminado", "El vendedor ha sido eliminado", Alert.AlertType.ERROR);
            }else{
                mostrarMensaje("Notificacion vendedor", "Vendedor no eliminado", "El vendedor No ha sido eliminado", Alert.AlertType.ERROR);

            }
        }

    }

    private void limpiarDatos() {
        txtNombre.setText("");
        txtApellidos.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtUsuario.setText("");
        txtClave.setText("");
    }



    @FXML
    void initialize(){
        this.columnNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        this.columnCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        this.columnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableListaVendedores.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarDatosVendedor(vendedorSeleccionado);
        });
    }

    private void mostrarDatosVendedor(Vendedor vendedorSeleccionado) {
        txtNombre.setText(vendedorSeleccionado.getNombre());
        txtApellidos.setText(vendedorSeleccionado.getApellido());
        txtCedula.setText(vendedorSeleccionado.getCedula());
        txtDireccion.setText(vendedorSeleccionado.getDireccion());
    }

    public void setMain(Main main){
        this.main = main;
        tableListaVendedores.getItems().clear();
        tableListaVendedores.setItems(obtenerListaVendedores());
    }

    private ObservableList<Vendedor> obtenerListaVendedores() {
        listaVendedorData.addAll(main.obtenerVendedores());
        return listaVendedorData;
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
    public void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {

        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(header);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
