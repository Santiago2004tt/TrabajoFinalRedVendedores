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
import redVendedores.model.Vendedor;

import java.io.IOException;
import java.util.ArrayList;

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
    void crearVendedor(ActionEvent event) {
        //crearVendedorAction();
    }
/**
    private void crearVendedorAction() {
        String name = "";
        String apellidos = "";
        String cedula = "";
        String direccion = "";
        String password = "";
        String user = "";
        name = txtNombre.getText();
        apellidos = txtApellidos.getText();
        cedula = txtCedula.getText();
        direccion = txtDireccion.getText();
        password = txtClave.getText();
        user =txtUsuario.getText();
        if(verificarCampos(name, apellidos, direccion, cedula, password, user)){
            if(main.vendedorExiste(cedula)){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Atencion");
                alert.setContentText("El vendedor que intentas crear ya existe");
                alert.showAndWait();
            }else{
                Vendedor nuevoVendedor = main.crearVendedor(name, apellidos, direccion, cedula, password, user);
                listaVendedorData.add(nuevoVendedor);
                if(nuevoVendedor != null){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Listo");
                    alert.setContentText("Vendedor creado exitosamente");
                    alert.showAndWait();
                }
            }


        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Atencion");
            alert.setContentText("Completa todos los campos para poder continuar");
            alert.showAndWait();
        }
    }
*/
    @FXML
    void eliminarVendedor(ActionEvent event) {

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


}
