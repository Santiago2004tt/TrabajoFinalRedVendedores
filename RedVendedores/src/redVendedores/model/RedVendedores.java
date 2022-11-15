package redVendedores.model;

import redVendedores.exceptions.UserException;

import java.util.ArrayList;

public class RedVendedores {
    //Atributs
    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;

    // Builder

    /**
     * constructor de red vendedores
     * @param nombre
     */

    public RedVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();


    }

    //get and set

    /**
     * el metodo get de nombre
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * el metodo set de nombre
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * metodo get de la lista de productos
     *
     * @return
     */
    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    /**
     * metodo  set de lista de productos
     *
     * @param listaProductos
     */
    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * metodo get de la lista de vendedores
     *
     * @return
     */
    public ArrayList<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    /**
     * metodo set de la lista de vendedores
     *
     * @param listaVendedores
     */
    public void setListaVendedor(ArrayList<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    // to string

    @Override
    public String toString() {
        return "RedVendedores{" +
                "nombre='" + nombre + '\'' +
                ", listaProductos=" + listaProductos +
                ", listaVendedor=" + listaVendedores +
                '}';
    }


    public boolean verificarUsuario(String usuario, String contrasenia){
        for (Vendedor vendedor :listaVendedores
             ) {
            if(vendedor.verifcarUsuario(usuario, contrasenia)){
                return true;
            }

        }
        return false;
    }


    public boolean eliminarUsuario(String cedula) {
        for (Vendedor vendedor:listaVendedores) {
            if(vendedor.getCedula().equals(cedula)){
                vendedor.eliminarUsuario();
                return true;
            }

        }
        return false;
    }

    public boolean actualizarUsuario(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        for (Vendedor vendedor:listaVendedores) {
            if(vendedor.getCedula().equals(cedula)){
                vendedor.actualizarUsuario(nuevoUsuario, contrasenia);
                return true;
            }

        }
        return false;
    }



}
