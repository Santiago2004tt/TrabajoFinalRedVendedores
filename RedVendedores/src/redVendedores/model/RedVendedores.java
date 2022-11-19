package redVendedores.model;

<<<<<<< HEAD
import javafx.scene.image.Image;
import redVendedores.exception.ProductoException;
=======
>>>>>>> master
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
<<<<<<< HEAD
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        ArrayList<Vendedor> listaVendedoresAliados2 = new ArrayList<Vendedor>();
        vendedor.setListaVendedoresAliados(listaVendedoresAliados2);
        Usuario usuario = new Usuario("pepito","pepe123");
        vendedor.setUsuario(usuario);
        vendedor.setListaProductos(listaProductos);
=======
        Cuenta cuenta = new Cuenta("pepito","pepe123");
        vendedor.setCuenta(cuenta);
        listaCuentas.add(cuenta);
>>>>>>> master
        listaVendedores.add(vendedor);

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNombre("miguel");
        vendedor1.setApellido("garcia");
        vendedor1.setCedula("7");
        vendedor1.setDireccion("Waza");
<<<<<<< HEAD
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
        ArrayList<Producto> listaProductos2 = new ArrayList<Producto>();
        listaVendedoresAliados.add(vendedor);
        vendedor1.setListaVendedoresAliados(listaVendedoresAliados);
        Usuario usuario1 = new Usuario("Pachito","elpacho123");
        vendedor1.setUsuario(usuario1);
        vendedor1.setListaProductos(listaProductos2);
=======
        Cuenta cuenta1 = new Cuenta("Pachito","elpacho123");
        vendedor1.setCuenta(cuenta1);
        listaCuentas.add(cuenta1);
>>>>>>> master
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
    public ArrayList<Producto> getListaProductos(Vendedor vendedor) {
        return vendedor.getListaProductos();
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

<<<<<<< HEAD
    //--------------------------------------------------------------

    /**
     * metodo para crear un producto
     * @param nombre
     * @param codigo
     * @param categoria
     * @param precio

     * @return
     * @throws ProductoException
     */
    public boolean crearProducto(String nombre, String codigo , String categoria, double precio, Image image, Vendedor vendedor) throws ProductoException {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setEstado(Estado.PUBLICADO);
        producto.setImage(image);


        if(existeProducto(codigo, vendedor) == true){
            throw new ProductoException("El producto ya existe");
        }
        vendedor.getListaProductos().add(producto);
        return true;
    }

    /**
     * metodo para verificar si el cafe existe o no
     *
     * @param codigo
     * @return
     */
    private boolean existeProducto(String codigo, Vendedor vendedor) throws ProductoException {
        for (Producto producto : vendedor.getListaProductos()) {
            if (producto.getCodigo().equals(codigo)) {
                return true;
            }

        }
        return false;
    }

    /**
     * Metodo para actualizar un producto
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param libras
     * @param estado
     */
    public boolean actualizarProducto(String nombre, String codigo , String categoria, double precio, Estado estado, Vendedor vendedor, Image image) {
        for (Producto producto : vendedor.getListaProductos()){
            if(producto.getCodigo().equals(codigo)){
                producto.setNombre(nombre);
                producto.setCategoria(categoria);
                producto.setPrecio(precio);
                producto.setEstado(estado);
                producto.setImage(image);
                return true;
            }

        }
        return false;
    }

    /**
     * metodo para eliminar un producto
     * @param codigo
     * @return
     */
    public boolean eliminarProducto(String codigo, Vendedor vendedor) throws ProductoException {

        if(existeProducto(codigo, vendedor)){
            for (Producto producto : vendedor.getListaProductos()) {
                if(producto.getCodigo().equals(codigo)){
                    vendedor.getListaProductos().remove(producto);
                    return true;
                }

            }
        }else{
            return false;
        }
        return false;
    }

    /**
     * metodo para buscar un producto
     * @param codigo
     * @return
     * @throws ProductoException
     */
    public Producto buscarProducto(String codigo, Vendedor vendedor) throws ProductoException {
        Producto productoEncontrado = null;
        if(existeProducto(codigo, vendedor)){
            for (Producto producto : vendedor.getListaProductos()) {
                if(producto.getCodigo().equals(codigo)){
                    productoEncontrado = producto;
                    return productoEncontrado;
                }
            }
        }
        if(productoEncontrado == null){
            throw new ProductoException("El cafe no se encuentra");
        }
        return productoEncontrado;
    }


=======
>>>>>>> master

    // CRUD---------VENDEDOR---------------------------------

    /**
     * method for create vendedor
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @return
     * @throws VendedorException
     */
    public Vendedor nuevoVendedor(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws VendedorException {
        Vendedor vendedor = new Vendedor();
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
<<<<<<< HEAD
        vendedor.setUsuario(usuario);
        vendedor.setListaProductos(listaProductos);
        vendedor.setListaVendedoresAliados(listaVendedoresAliados);
=======
        vendedor.setCuenta(cuenta);
>>>>>>> master

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

<<<<<<< HEAD
    public Vendedor obtenerVendedor(String user, String password) {
        Vendedor vendedorEncontrado = null;
        for (Vendedor vendedor:listaVendedores) {
            if (vendedor.verificarUsuario(user, password)){
                vendedorEncontrado = vendedor;
                break;
            }
        }
        return vendedorEncontrado;
    }

    public ArrayList<Vendedor> obtenerlistaVendedoresAliados(Vendedor vendedor) {
        return vendedor.getListaVendedoresAliados();
    }

=======
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


>>>>>>> master
    //-----------------------------------------------------------------------------------


}




