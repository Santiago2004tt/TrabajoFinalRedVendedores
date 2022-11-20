package redVendedores.model;

import redVendedores.exceptions.MensajeExceptions;
import redVendedores.exceptions.MuroException;
import redVendedores.exceptions.UserException;

import java.util.ArrayList;

public class Vendedor extends Usuario {
    //Atributs

    private Vendedor theVendedor;
    private ArrayList<Vendedor> listaVendedoresAliados;

    private ArrayList<Producto> listaProductos;

    private  ArrayList<Comentario> listaComentarios;

    private Muro muro;
    private ArrayList<Mensaje> listaMensajes;

    private Cuenta cuenta;

    /**
     * Constructor method for Vendedor class
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param theVendedor
     */
    public Vendedor(String nombre, String apellido, String cedula, String direccion, Vendedor theVendedor, Cuenta cuenta1, Muro muro) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCedula(cedula);
        this.setDireccion(direccion);
        this.theVendedor = theVendedor;
        this.muro = muro;
        this.cuenta = cuenta1;
        listaProductos = new ArrayList<Producto>();
        listaMensajes = new ArrayList<Mensaje>();
    }

<<<<<<< HEAD


    public Vendedor(Vendedor theVendedor, ArrayList<Vendedor> listaVendedoresAliados, ArrayList<Producto> listaProductos, Muro muro, ArrayList<Mensaje> listaMensajes, Cuenta cuenta) {
        this.theVendedor = theVendedor;
        this.listaVendedoresAliados = listaVendedoresAliados;
        this.listaProductos = listaProductos;
        this.muro = muro;
        this.listaMensajes = listaMensajes;
        this.cuenta = cuenta;
=======
    public Vendedor(String nombre, String apellido, String cedula, String direccion, Usuario usuario) {
        super(nombre, apellido, cedula, direccion, usuario);
        listaVendedoresAliados = new ArrayList<Vendedor>();
        listaComentarios = new ArrayList<Comentario>();
>>>>>>> master
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

    public ArrayList<Mensaje> getListaMensajes() {
        return listaMensajes;
    }

    public void setListaMensajes(ArrayList<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
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

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
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


    public boolean verificarCuenta(String usuario, String password) {

        if(cuenta.getUsuario().equals(usuario)&&cuenta.getContrasenia().equals(password)){
            return true;
        }
        return false;
    }

    public void enviarMensaje(String s, Vendedor vendedor1) throws MensajeExceptions {
        Mensaje mensaje1 = null;
        for (Mensaje mensaje: listaMensajes) {
            if(mensaje.getVendedor().getCedula().equals(vendedor1.getCedula())){
                mensaje1 = mensaje;
                mensaje1.añadirMensaje(s);
            }
        }
        if(mensaje1==null){
            throw new MensajeExceptions("Error");
        }
    }
}
