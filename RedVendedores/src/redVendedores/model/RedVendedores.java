package redVendedores.model;

import javafx.scene.image.Image;
import redVendedores.exceptions.*;
import redVendedores.exceptions.VendedorException;
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
        inicializarAdministradores();
    }
    private void inicializarDatos() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("pepe");
        vendedor.setApellido("Martinez");
        vendedor.setCedula("123");
        vendedor.setDireccion("en una casa");
        ArrayList<Producto> listaProductos = new ArrayList<Producto>();
        ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
        ArrayList<Vendedor> listaVendedoresAliados2 = new ArrayList<Vendedor>();
        Comentario comentario = new Comentario();
        comentario.setMensaje("Ofrece buenos productos");
        ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
        listaComentarios.add(comentario);
        vendedor.setListaComentarios(listaComentarios);
        vendedor.setListaVendedoresAliados(listaVendedoresAliados2);
        vendedor.setListaProductos(listaProductos);
        vendedor.setListaMensajes(listaMensajes);
        Cuenta cuenta = new Cuenta("pepito","pepe123");
        vendedor.setCuenta(cuenta);
        listaCuentas.add(cuenta);
        listaVendedores.add(vendedor);
        //-----------------------------------

        Vendedor vendedor1 = new Vendedor();
        ArrayList<Vendedor> listaVendedoresRecomendados = new ArrayList<Vendedor>();
        vendedor1.setNombre("miguel");
        vendedor1.setApellido("garcia");
        vendedor1.setCedula("7");
        vendedor1.setDireccion("Waza");
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
        ArrayList<Producto> listaProductos2 = new ArrayList<Producto>();
        ArrayList<Mensaje> listaMensajes1 = new ArrayList<Mensaje>();
        listaVendedoresAliados.add(vendedor);
        vendedor1.setListaVendedoresAliados(listaVendedoresAliados);
        vendedor1.setListaProductos(listaProductos2);
        vendedor1.setListaRecomendados(listaVendedoresRecomendados);
        vendedor1.setListaMensajes(listaMensajes1);

        Cuenta cuenta1 = new Cuenta("Pachito","elpacho123");
        vendedor1.setCuenta(cuenta1);
        listaCuentas.add(cuenta1);
        listaVendedores.add(vendedor1);
    }


    private void inicializarAdministradores(){
        Administrador administrador = new Administrador();
        administrador.setNombre("Cristian");
        administrador.setApellido("Vargas");
        administrador.setCedula("1092");
        administrador.setDireccion("Casa de cristian y su familia <3");
        Cuenta cuenta = new Cuenta("cris","curry123");
        administrador.setCuenta(cuenta);
        listaCuentas.add(cuenta);
        listaAdministradores.add(administrador);

        //------------------------------------------------------------

        Administrador administrador1 = new Administrador();
        administrador1.setNombre("Santiago");
        administrador1.setApellido("Sepulveda");
        administrador1.setCedula("1090");
        administrador1.setDireccion("Casa con puertas y ventanas");
        Cuenta cuenta1 = new Cuenta("eljere","1234");
        administrador1.setCuenta(cuenta1);
        listaCuentas.add(cuenta1);
        listaAdministradores.add(administrador1);
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
    public boolean crearProducto(String nombre, String codigo , String categoria, double precio, Image image, Vendedor vendedor, String date) throws ProductoException {
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setCodigo(codigo);
        producto.setCategoria(categoria);
        producto.setPrecio(precio);
        producto.setEstado(Estado.PUBLICADO);
        producto.setImage(image);
        producto.setDate(date);
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
        ArrayList<Comentario> listaComentarios = new ArrayList<Comentario>();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setListaComentarios(listaComentarios);
        vendedor.setListaProductos(listaProductos);
        vendedor.setListaVendedoresAliados(listaVendedoresAliados);
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

    public Vendedor obtenerVendedor(String user, String password) {
        Vendedor vendedorEncontrado = null;
        for (Vendedor vendedor:listaVendedores) {
            if (vendedor.verificarCuenta(user, password)){
                vendedorEncontrado = vendedor;
                break;
            }
        }
        return vendedorEncontrado;
    }

    public ArrayList<Vendedor> obtenerlistaVendedoresAliados(Vendedor vendedor) {
        return vendedor.getListaVendedoresAliados();
    }

    public ArrayList<Mensaje> obtenerListaMensajesVendedor(Vendedor vendedorLogeado) {
        return vendedorLogeado.getListaMensajes();
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

    //-----------------------------------------Administrador------------------------------------------

    /**
     * method for create vendedor
     * @param nombre
     * @param apellido
     * @param cedula
     * @param direccion
     * @return
     * @throws VendedorException
     */
    public Administrador nuevoAdministrador(String nombre, String apellido, String cedula, String direccion, Cuenta cuenta) throws AdministradorException {
        Administrador administrador = new Administrador();
        administrador.setNombre(nombre);
        administrador.setApellido(apellido);
        administrador.setCedula(cedula);
        administrador.setDireccion(direccion);
        administrador.setCuenta(cuenta);

        if(existeAdministrador(cedula) == true){
            throw new AdministradorException("El administrador ya existe");
        }
        listaAdministradores.add(administrador);
        return administrador;
    }

    /**
     * method for verificar existencia vendedor
     * @param cedula
     * @return
     */
    public boolean existeAdministrador(String cedula) {

        for (Administrador administrador : listaAdministradores) {
                if(administrador.getCedula().equals(cedula)){
                    return true;
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
    public void actualizarAdministrador(String nombre2, String apellido, String cedula, String direccion) {

        for (Administrador administrador : listaAdministradores) {
            if(administrador.getCedula().equals(cedula)){
                administrador.setNombre(nombre2);
                administrador.setApellido(apellido);
                administrador.setDireccion(direccion);
            }
        }
    }

    /**
     * metodo para eliminar un vendedor
     * @param cedula
     * @return
     */
    public boolean eliminarAdministrador (String cedula) {

        if (existeAdministrador(cedula)) {
            for (Administrador administrador : listaAdministradores) {
                    if (administrador.getCedula().equals(cedula)) {
                        listaAdministradores.remove(administrador);
                        return true;
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
    public Administrador buscarAdministrador(String cedula) throws AdministradorException{
        Administrador administrador = null;
        if(existeAdministrador(cedula)){
            if(administrador.getCedula().equals(cedula)){
                return administrador;
            }
        }
        if(administrador == null){
            throw new AdministradorException("El administrador no se encuentra");
        }
        return administrador;
    }

    public Administrador obtenerAdministrador(String user, String password) {
        Administrador administradorEncontrado = null;
        for (Administrador administrador:listaAdministradores) {
            if (administrador.verificarCuentaAdministrador(user, password)){
                administradorEncontrado = administrador;
                break;
            }
        }
        return administradorEncontrado;
    }

    public boolean verificarUsuarioVendedor(String usuario, String contrasenia) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.verificarCuenta(usuario, contrasenia)) {
                return true;
            }
        }
        return false;
    }

    public boolean verificarUsuarioAdministrador(String usuario, String contrasenia) {
        for (Administrador administrador: listaAdministradores) {
            if(administrador.verificarCuentaAdministrador(usuario, contrasenia)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Comentario> obtenerListaComentarios(Vendedor vendedorAliado) {
        return vendedorAliado.getListaComentarios();
    }

    public boolean agregarComentario(Vendedor vendedorLogeado, Vendedor vendedorAliado, String mensaje) {

        Comentario comentario = new Comentario();
        comentario.setVendedor(vendedorLogeado);
        comentario.setMensaje(mensaje);
        vendedorAliado.getListaComentarios().add(comentario);
        return true;
    }

    public boolean enviarMensaje(String mensaje, Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        Mensaje mensaje1 = new Mensaje();
        mensaje1.setAutor(vendedorLogeado);
        mensaje1.setContenido(mensaje);
        vendedorAliado.getListaMensajes().add(mensaje1);
        return true;

    }

    public boolean responderMensaje(String mensaje, Vendedor autor, Vendedor vendedorLogeado) {
        Mensaje mensaje1 = new Mensaje();
        mensaje1.setAutor(vendedorLogeado);
        mensaje1.setContenido(mensaje);
        autor.getListaMensajes().add(mensaje1);
        return true;
    }


    public boolean verificarExisteMeGusta(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        return vendedorAliado.verificarExisteMeGusta(vendedorLogeado);
    }

    public boolean agregarMeGusta(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        MeGusta meGusta = new MeGusta();
        meGusta.setVendedor(vendedorLogeado);
        vendedorAliado.getListaMeGusta().add(meGusta);
        return true;
    }

    public void quitarMeGusta(Vendedor vendedorLogeado, Vendedor vendedorAliado) {
        vendedorAliado.quitarMeGusta(vendedorLogeado);
    }

    public int contarMeGustas(Vendedor vendedorAliado) {
        return vendedorAliado.contarMeGustas();
    }

    public ArrayList<Vendedor> obtenerListaVendedoresSolicitud(Vendedor vendedorLogeado) {
        return vendedorLogeado.obtenerListaVendedorSolicitud();
    }

    public void actualizarTablaRecomendados(String cedula) throws VendedorException {
        Vendedor vendedorAux = buscarVendedor(cedula);
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();

        for (Vendedor vendedor: listaVendedores) {
            if(verificarVendedorRepetido(vendedor, vendedorAux) != false){
                if(verificarVendedorRepetidoAliados(vendedor, vendedorAux) != false){
                    vendedorAux.agregarVendedorRecomendado(vendedor);
                }
            }
        }
    }

    private boolean verificarVendedorRepetidoAliados(Vendedor vendedor, Vendedor vendedorAux) {
        ArrayList<Vendedor> listaVendedoresAliados = vendedorAux.getListaVendedoresAliados();
        for (Vendedor vendedor1 : listaVendedoresAliados) {
            if(vendedor1.getNombre().equals(vendedor.getNombre())){
                return false;
            }
        }
        return true;
    }

    private boolean verificarVendedorRepetido(Vendedor vendedor, Vendedor vendedorAux) {
        if(vendedor.getCedula().equals(vendedorAux.getCedula())){
            return false;
        }
        return true;
    }

    public boolean enviarSolicitud(Vendedor vendedorLogeado, Vendedor vendedorSeleccionado) {
        return vendedorSeleccionado.aniadirSolicitud(vendedorLogeado);
    }

    public ArrayList<Vendedor> obtenerListaVendedoresRecomendados(Vendedor vendedorLogeado) {
        return vendedorLogeado.getListaRecomendados();
    }



}




