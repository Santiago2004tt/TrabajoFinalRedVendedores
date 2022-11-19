package redVendedores.model;

import redVendedores.exceptions.*;
import redVendedores.exception.VendedorException;
import java.util.ArrayList;

public class RedVendedores {
    private String nombre;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Vendedor> listaVendedores;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Cuenta> listaCuentas;

    // Builder

    /**
     * constructor de red vendedores
     * @param nombre
     */

    public RedVendedores(String nombre) {
        this.nombre = nombre;
        listaVendedores = new ArrayList<Vendedor>();
        listaProductos = new ArrayList<Producto>();
        listaAdministradores = new ArrayList<Administrador>();
        listaCuentas = new ArrayList<Cuenta>();
        inicializarDatos();
    }

    private void inicializarDatos() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("pepe");
        vendedor.setApellido("Martinez");
        vendedor.setCedula("123");
        vendedor.setDireccion("en una casa");
        Cuenta cuenta = new Cuenta("pepito","pepe123");
        vendedor.setCuenta(cuenta);
        listaCuentas.add(cuenta);
        listaVendedores.add(vendedor);

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNombre("miguel");
        vendedor1.setApellido("garcia");
        vendedor1.setCedula("7");
        vendedor1.setDireccion("Waza");
        Cuenta cuenta1 = new Cuenta("Pachito","elpacho123");
        vendedor1.setCuenta(cuenta1);
        listaCuentas.add(cuenta1);
        listaVendedores.add(vendedor1);
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

    public Boolean verificarUsuario(String usuario, String contrasenia) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.verifcarCuenta(usuario, contrasenia)) {
                return true;
            }
        }
        return false;
    }


    // CRUD---------VENDEDOR---------------------------------

    /**
     * method for create vendedor
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @param theVendedor
     * @return
     * @throws VendedorException
     */
    public Vendedor nuevoVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws VendedorException {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setCuenta(cuenta);

        if(existeVendedor(cedula) == true){
            throw new VendedorException("El vendedor ya existe");
        }
        listaVendedores.add(vendedor);
        return vendedor;
    }

    /**
     * method for verificar existencia vendedor
     * @param cedula
     * @return
     */
    public boolean existeVendedor(String cedula) {

        for (Vendedor vendedor : listaVendedores) {
            if (vendedor instanceof Vendedor){
                if(vendedor.getCedula().equals(cedula)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * actualizar vendedor
     * @param nombre2
     * @param apellido
     * @param cedula
     * @param direccion
     * @param theVendedor
     */
    public void actualizarVendedor(String nombre2, String apellido, String cedula,
                                   String direccion) {

        for (Vendedor vendedor : listaVendedores) {
            if(vendedor.getCedula().equals(cedula)){
                vendedor.setNombre(nombre2);
                vendedor.setApellido(apellido);
                vendedor.setDireccion(direccion);
            }
        }
    }

    /**
     * metodo para eliminar un vendedor
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor (String cedula) {

        if (existeVendedor(cedula)) {
            for (Vendedor vendedor : listaVendedores) {
                if (vendedor instanceof Vendedor) {
                    if (vendedor.getCedula().equals(cedula)) {
                        listaVendedores.remove(vendedor);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * search vendedor
     * @param cedula
     * @return
     * @throws VendedorException
     */
    public Vendedor buscarVendedor(String cedula) throws VendedorException{
        Vendedor vendedor = null;
        if(existeVendedor(cedula)){
            if(vendedor.getCedula().equals(cedula)){
                return vendedor;
            }
        }
        if(vendedor == null){
            throw new VendedorException("El vendedor no se encuentra");
        }
        return vendedor;
    }


    //--------------------------------------Cuenta crud-------------------------------
    public boolean eliminarCuenta(String cedula) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedor.eliminarCuenta();
                return true;
            }
        }
        return false;
    }

    public boolean actualizarCuenta(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedor.actualizarCuenta(nuevoUsuario, contrasenia);
                return true;
            }
        }
        return false;
    }

    public Cuenta crearCuenta(String user, String password) throws UserException {
        Cuenta cuenta = new Cuenta();
        cuenta.setUsuario(user);
        cuenta.setContrasenia(password);

        if(existeCuenta(user)==false){
            throw new UserException("El usuario ya existe");
        }
        listaCuentas.add(cuenta);
        return cuenta;
    }

    private boolean existeCuenta(String user) {
        for (Cuenta cuenta: listaCuentas) {
            if(cuenta.getUsuario().equals(user)){
                return false;
            }
        }
        return true;
    }


    //-----------------------------------------------------------------------------------


}




