package redVendedores.model;

import redVendedores.exceptions.MuroException;
import redVendedores.exceptions.UserException;

import java.util.ArrayList;

public class Vendedor extends Usuario {
    //Atributs

    private Vendedor theVendedor;
    private ArrayList<Vendedor> listaVendedoresAliados;

    private ArrayList<Producto> listaProductos;

    private Muro muro;

    private Cuenta cuenta;

<<<<<<< HEAD
    /**
     * Constructor method for Vendedor class
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param theVendedor
     * @param usuario
     */
    public Vendedor(String nombre, String apellido, String cedula, String direccion, Vendedor theVendedor, Usuario usuario, Muro muro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.theVendedor = theVendedor;
        this.muro = muro;
        this.user = usuario;
        listaProductos = new ArrayList<Producto>();
=======
    public Vendedor(String nombre, String apellido, String cedula, String direccion, Usuario usuario) {
        super(nombre, apellido, cedula, direccion, usuario);
>>>>>>> master
        listaVendedoresAliados = new ArrayList<Vendedor>();
    }

    public Vendedor() {
        super();
    }

    public Vendedor getTheVendedor() {
        return theVendedor;
    }

    public void setTheVendedor(Vendedor theVendedor) {
        this.theVendedor = theVendedor;
    }

    public ArrayList<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    public void setListaVendedoresAliados(ArrayList<Vendedor> listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
    }

<<<<<<< HEAD
    /**
     * Usuario getter method
     * @return
     */
    public Usuario getUsuario() {
        return user;
    }

    /**
     * Usuario setter method
     * @param usuario
     */
    public void setUsuario(Usuario usuario) {
        this.user = usuario;
    }

    /**
     * lista productos getter method
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }


    /**
     * listaProductos setter method
     * @param listaProductos
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Muro getter method
     * @return
     */
=======
>>>>>>> master
    public Muro getMuro() {
        return muro;
    }

    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    //--------------------------------------crud de cuenta
    
    
    
    /**
     * This method verifies if a user already exists
     * @param usuario
     * @param contrasenia
     * @return
     */
    public boolean verifcarCuenta(String usuario, String contrasenia) {
        if(cuenta.getContrasenia().equals(contrasenia)&& cuenta.getUsuario().equals(usuario)){
            return true;
        }

        return false;
    }

    /**
     * This method updates the user username and password
     * @param usuario
     * @param contrasenia
     * @return
     * @throws UserException
     */
    public boolean actualizarCuenta (String usuario, String contrasenia) throws UserException {
        if(cuenta != null){
            cuenta.setUsuario(usuario);
            cuenta.setContrasenia(contrasenia);
            return true;
        }else{
            throw new UserException("Este vendedor no posee un usuario establecido");
        }
    }

    /**
     * This method deletes a user
     */
    public void eliminarCuenta(){
        cuenta = null;
    }



    //-----------------------------crud----------------------
    /**
     * Muro create method
     * @param mensaje
     * @param comentarios
     * @param me_gusta
     * @return
     * @throws MuroException
     */
    public Muro crearMuro(String mensaje, String comentarios, int me_gusta) throws MuroException {
        Muro nuevoMuro = null;
        if(muro == null){
            nuevoMuro = new Muro();
            nuevoMuro.setComentarios(comentarios);
            nuevoMuro.setMensaje(mensaje);
            nuevoMuro.setMe_gusta(me_gusta);
        }else{
            throw new MuroException("el muro ya existe");
        }


        return nuevoMuro;
    }

    /**
     * Muro delete method
     */
    public void deleteMuro (){
        muro = null;
    }

    /**
     * Muro update method
     * @param mensaje
     * @param comentarios
     * @param me_gusta
     * @return
     * @throws MuroException
     */
    public boolean actualizarMuro(String mensaje, String comentarios, int me_gusta) throws MuroException {

        if(muro != null){
            muro.setComentarios(comentarios);
            muro.setMensaje(mensaje);
            muro.setMe_gusta(me_gusta);
            return true;
        }else{
            throw new MuroException("El muro no existe");
        }

    }

<<<<<<< HEAD

    public boolean verificarUsuario(String usuario, String password) {

        if(user.getUsuario().equals(usuario)&&user.getContrasenia().equals(password)){
            return true;
        }
        return false;
    }
=======
>>>>>>> master
}
