package redVendedores.model;

import redVendedores.exceptions.MuroException;
import redVendedores.exceptions.UserException;

import java.util.ArrayList;

public class Vendedor extends Usuario {
    //Atributs

    private Vendedor theVendedor;
    private ArrayList<Vendedor> listaVendedoresAliados;

    private ArrayList<Producto> listaProductos;

    private  ArrayList<Comentario> listaComentarios;

    private ArrayList<MeGusta> listaMeGusta;
    private ArrayList<Vendedor> listaSolicitudes;
    private ArrayList<Vendedor> listaRecomendados;


    private Cuenta cuenta;

    public Vendedor(String nombre, String apellido, String cedula, String direccion, Usuario usuario, Vendedor theVendedor, Cuenta cuenta) {
        super(nombre, apellido, cedula, direccion, usuario);
        this.theVendedor = theVendedor;
        this.cuenta = cuenta;
        listaComentarios= new ArrayList<Comentario>();
        listaVendedoresAliados = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaMeGusta = new ArrayList<MeGusta>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaComentarios = new ArrayList<Comentario>();
        listaRecomendados= new ArrayList<Vendedor>();
    }

    public ArrayList<MeGusta> getListaMeGusta() {
        return listaMeGusta;
    }

    public void setListaMeGusta(ArrayList<MeGusta> listaMeGusta) {
        this.listaMeGusta = listaMeGusta;
    }

    public Vendedor() {
        listaVendedoresAliados = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaMeGusta = new ArrayList<MeGusta>();
        listaSolicitudes = new ArrayList<Vendedor>();
        listaComentarios = new ArrayList<Comentario>();
        listaRecomendados= new ArrayList<Vendedor>();
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

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public ArrayList<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(ArrayList<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
    }


    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public ArrayList<Vendedor> getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList<Vendedor> listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public ArrayList<Vendedor> getListaRecomendados() {
        return listaRecomendados;
    }

    public void setListaRecomendados(ArrayList<Vendedor> listaRecomendados) {
        this.listaRecomendados = listaRecomendados;
    }
    //--------------------------------------crud de cuenta-------------------------------
    
    
    
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



    public boolean verificarCuenta(String usuario, String password) {

        if(cuenta.getUsuario().equals(usuario)&&cuenta.getContrasenia().equals(password)){
            return true;
        }
        return false;
    }


    public boolean verificarExisteMeGusta(Vendedor vendedorLogeado) {
        for (MeGusta meGusta: listaMeGusta) {
            if(meGusta.getVendedor().getCedula().equals(vendedorLogeado.getCedula())){
                return false;
            }
        }
        return true;
    }

    public void quitarMeGusta(Vendedor vendedorLogeado) {
        for (MeGusta meGusta: listaMeGusta) {
            if(meGusta.getVendedor().getCedula().equals(vendedorLogeado.getCedula())){
                listaMeGusta.remove(meGusta);
                break;
            }
        }
    }

    public int contarMeGustas() {
        return listaMeGusta.size();
    }

    public ArrayList<Vendedor> obtenerListaVendedorSolicitud() {
        return listaSolicitudes;
    }

    public void agregarVendedorRecomendado(Vendedor vendedor) {
        listaRecomendados.add(vendedor);
    }

    public boolean aniadirSolicitud(Vendedor vendedorLogeado) {
        if(verificarExisteSolicitud(vendedorLogeado)){
            listaSolicitudes.add(vendedorLogeado);
            return true;
        }
        return false;
    }

    private boolean verificarExisteSolicitud(Vendedor vendedorLogeado) {
        for (Vendedor vendedor: listaSolicitudes) {
            if(vendedor.getCedula().equals(vendedorLogeado.getCedula())){
                return false;
            }
        }
        return true;
    }

    public void aceptarSolicitud(Vendedor vendedorSeleccionado) {
       if( existeVendedorAliado(vendedorSeleccionado)){
           listaVendedoresAliados.add(vendedorSeleccionado);
           quitarLista(vendedorSeleccionado);
       }
    }

    private void quitarLista(Vendedor vendedorSeleccionado) {
        for (Vendedor vendedor: listaSolicitudes) {
            if(vendedor.getCedula().equals(vendedorSeleccionado.getCedula())){
                listaSolicitudes.remove(vendedor);
                break;
            }
        }
    }

    private boolean existeVendedorAliado(Vendedor vendedorSeleccionado) {
        for (Vendedor vendedor: listaVendedoresAliados) {
            if(vendedor.getCedula().equals(vendedorSeleccionado.getCedula())){
                return false;
            }
        }
        return true;
    }

    public void rechazarSolicitud(Vendedor vendedorSeleccionado) {
        if(existeVendedorAliado(vendedorSeleccionado)){
            quitarLista(vendedorSeleccionado);
        }
    }
}
