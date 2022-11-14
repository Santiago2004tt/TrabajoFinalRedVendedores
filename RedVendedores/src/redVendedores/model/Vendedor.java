package redVendedores.model;

import redVendedores.exceptions.MuroException;
import redVendedores.exceptions.UserException;

import java.util.ArrayList;

public class Vendedor {
    //Atributs
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private Vendedor theVendedor;
    private ArrayList<Vendedor> listaVendedoresAliados;

    private Muro muro;

    private Usuario user;


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
        listaVendedoresAliados = new ArrayList<Vendedor>();
    }

    public Vendedor() {
    }

    //Get and Set
    /**
     * get method of name
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * set name method
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * lastname get method
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * surname set method
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * cedula get method
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * cedula set method
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * address get method
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * address set method
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * vendor get method
     * @return
     */
    public Vendedor getTheVendedor() {
        return theVendedor;
    }

    /**
     *
     * vendor set method
     * @param theVendedor
     */
    public void setTheVendedor(Vendedor theVendedor) {
        this.theVendedor = theVendedor;
    }

    /**
     * allied vendor list get method
     * @return
     */
    public ArrayList<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    /**
     * allied sellers list set method
     * @param listaVendedoresAliados
     */
    public void setListaVendedoresAliados(ArrayList<Vendedor> listaVendedoresAliados) {
        this.listaVendedoresAliados = listaVendedoresAliados;
    }

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
     * Muro getter method
     * @return
     */
    public Muro getMuro() {
        return muro;
    }

    /**
     * Muro setter method
     * @param muro
     */
    public void setMuro(Muro muro) {
        this.muro = muro;
    }

    //To String
    @Override
    public String toString() {
        return "Vendedor{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cedula='" + cedula + '\'' +
                ", direccion='" + direccion + '\'' +
                ", theVendedor=" + theVendedor +
                ", listaVendedoresAliados=" + listaVendedoresAliados +
                '}';
    }

    /**
     * Equals and hash method for Vendedor class
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vendedor vendedor = (Vendedor) o;
        return getCedula() != null ? getCedula().equals(vendedor.getCedula()) : vendedor.getCedula() == null;
    }

    @Override
    public int hashCode() {
        return getCedula() != null ? getCedula().hashCode() : 0;
    }


    /**
     * This method verifies if a user already exists
     * @param usuario
     * @param contrasenia
     * @return
     */
    public boolean verifcarUsuario(String usuario, String contrasenia) {
        if(user.getContrasenia().equals(contrasenia)&& user.getUsuario().equals(usuario)){
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
    public boolean actualizarUsuario (String usuario, String contrasenia) throws UserException {
        String msj ="";
        if(user != null){
            user.setUsuario(usuario);
            user.setContrasenia(contrasenia);
            return true;
        }else{
            throw new UserException("Este vendedor no posee un usuario establecido");
        }


    }

    /**
     * This method deletes a user
     */
    public void eliminarUsuario(){
        user = null;
    }





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



}
