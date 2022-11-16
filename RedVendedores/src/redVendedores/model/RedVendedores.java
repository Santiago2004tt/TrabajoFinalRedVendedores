package redVendedores.model;

import redVendedores.exception.ProductoException;
import redVendedores.exceptions.*;
import redVendedores.exception.VendedorException;
import java.util.ArrayList;

public class RedVendedores {
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
        inicializarDatos();
    }

    private void inicializarDatos() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("pepe");
        vendedor.setApellido("Martinez");
        vendedor.setCedula("123");
        vendedor.setDireccion("en una casa");
        listaVendedores.add(vendedor);

        Vendedor vendedor1 = new Vendedor();
        vendedor1.setNombre("miguel");
        vendedor1.setApellido("garcia");
        vendedor1.setCedula("7");
        vendedor1.setDireccion("Waza");
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
            if (vendedor.verifcarUsuario(usuario, contrasenia)) {
                return true;
            }
        }
        return false;
    }

    //--------------------------------------------------------------

    /**
     * metodo para crear un cafe
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param libras
     * @param estado
     * @return
     * @throws CafeException
     */
    public Cafe crearCafe(String nombre2, String codigo , String categoria, double precio, String libras, Estado estado) throws ProductoException {
        Cafe cafe = new Cafe();
        cafe.setNombre(nombre);
        cafe.setCodigo(codigo);
        cafe.setCategoria(categoria);
        cafe.setPrecio(precio);
        cafe.setLibras(libras);
        cafe.setEstado(estado);

        if(existeCafe(codigo) == true){
            throw new ProductoException("El cafe ya existe");
        }
        listaProductos.add(cafe);
        return cafe;
    }

    /**
     * metodo para verificar si el cafe existe o no
     *
     * @param codigo
     * @return
     */
    private boolean existeCafe(String codigo) throws ProductoException {
        for (Producto producto : listaProductos) {
            if (producto instanceof Cafe) {
                if (producto.getCodigo().equals(codigo)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Metodo para actualizar un producto de cafe
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param libras
     * @param estado
     */
    public void actualizarCafe(String nombre2, String codigo , String categoria, double precio, String libras, Estado estado) {
        for (Producto producto : listaProductos) {
            if (producto instanceof Cafe){
                if(producto.getCodigo().equals(codigo)){
                    producto.setNombre(nombre2);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    ((Cafe) producto).setLibras(libras);
                    producto.setEstado(estado);
                }
            }
        }
    }

    /**
     * metodo para eliminar un cafe
     * @param codigo
     * @return
     */
    public boolean eliminarCafe(String codigo) throws ProductoException {

        if(existeCafe(codigo)){
            for (Producto producto : listaProductos) {
                if(producto instanceof Cafe){
                    if(producto.getCodigo().equals(codigo)){
                        listaProductos.remove(producto);
                        return true;
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }

    /**
     * metodo para buscar un cafe
     * @param codigo
     * @return
     * @throws CafeException
     */
    public Cafe buscarCafe(String codigo) throws ProductoException {
        Cafe cafe = null;
        if(existeCafe(codigo)){
            for (Producto producto : listaProductos) {
                if(producto instanceof Cafe){
                    if(producto.getCodigo().equals(codigo)){
                        cafe = (Cafe) producto;
                        return cafe;
                    }
                }
            }
        }
        if(cafe == null){
            throw new ProductoException("El cafe no se encuentra");
        }
        return cafe;
    }

    //--------------------------------Crud empanada------------------------

    /**
     * metodo para crear una empanada
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param relleno
     * @return
     * @throws EmpanadaException
     */
    public Empanada crearEmpanada (String nombre2, String codigo, String categoria, double precio, Estado estado, String relleno) throws ProductoException {

        Empanada empanada = new Empanada();
        empanada.setNombre(nombre);
        empanada.setCodigo(codigo);
        empanada.setCategoria(categoria);
        empanada.setPrecio(precio);
        empanada.setEstado(estado);
        empanada.setRelleno(relleno);
        if (existeEmpanada(codigo) == true) {
            throw new ProductoException("La empanada ya existe");
        }
        listaProductos.add(empanada);
        return empanada;
    }

    /**
     * metodo para verificar si una empanada existe
     * @param codigo
     * @return
     */
    private boolean existeEmpanada (String codigo){
        for (Producto producto : listaProductos) {
            if (producto instanceof Empanada) {
                if (producto.getCodigo().equals(codigo)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo para actualizar una empanada
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param relleno
     */
    public void actualizarEmpanada (String nombre2, String codigo, String categoria, double precio, Estado estado, String relleno){

        for (Producto producto : listaProductos) {
            if (producto instanceof Empanada) {
                if (producto.getCodigo().equals(codigo)) {
                    producto.setNombre(nombre2);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setEstado(estado);
                    ((Empanada) producto).setRelleno(relleno);
                }
            }
        }
    }

    /**
     * metodo para eliminar una empanada
     * @param codigo
     * @return
     */
    public boolean eliminarEmpanada (String codigo){

        if (existeEmpanada(codigo)) {
            for (Producto producto : listaProductos) {
                if (producto instanceof Empanada) {
                    if (producto.getCodigo().equals(codigo)) {
                        listaProductos.remove(producto);
                        return true;
                    }
                }
            }
        } else {
            return false;
        }
        return false;
    }

    /**
     * metodo para buscar una empanada por el codigo
     * @param codigo
     * @return
     * @throws EmpanadaException
     */
    public Empanada buscarEmpanada (String codigo) throws ProductoException {
        Empanada empanada = null;
        if (existeEmpanada(codigo)) {
            for (Producto producto : listaProductos) {
                if (producto instanceof Empanada) {
                    if (producto.getCodigo().equals(codigo)) {
                        empanada = (Empanada) producto;
                        return empanada;
                    }
                }
            }
        }
        if (empanada == null) {
            throw new ProductoException("La empanada no se encuentra");
        }
        return empanada;
    }

    //----------------------------Crud helado--------------------

    /**
     * metodo para crear un helado
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param tamanio
     * @param sabor
     * @return
     * @throws HeladoException
     */
    public Helado crearHelado(String nombre2, String codigo , String categoria, double precio, Estado estado, String tamanio, String sabor) throws ProductoException{

        Helado helado = new Helado();
        helado.setNombre(nombre);
        helado.setCodigo(codigo);
        helado.setCategoria(categoria);
        helado.setPrecio(precio);
        helado.setEstado(estado);
        helado.setTamanio(tamanio);
        helado.setSabor(sabor);

        if(existeHelado(codigo) == true){
            throw new ProductoException("El helado ya existe");
        }
        listaProductos.add(helado);
        return helado;
    }

    /**
     * metodo para verificar si existe un helado
     * @param codigo
     * @return
     */
    private boolean existeHelado(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto instanceof Helado){
                if(producto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo para actualizar un helado
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param sabor
     * @param tamanio
     */
    public void actualizarHelado(String nombre2, String codigo , String categoria, double precio, Estado estado, String sabor, String tamanio) {

        for (Producto producto : listaProductos) {
            if (producto instanceof Helado) {
                if (producto.getCodigo().equals(codigo)) {
                    producto.setNombre(nombre2);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setEstado(estado);
                    ((Helado) producto).setTamanio(tamanio);
                    ((Helado) producto).setSabor(sabor);
                }
            }
        }
    }

    /**

     * metodo para eliminar un helado
     * @param codigo
     * @return
     */
    public boolean eliminarHelado(String codigo) {

        if(existeHelado(codigo)){
            for (Producto producto : listaProductos) {
                if(producto instanceof Helado){
                    if(producto.getCodigo().equals(codigo)){
                        listaProductos.remove(producto);
                        return true;
                    }
                }
            }
        }else{
            return false;
        }
        return false;
    }

    /**
     * metodo para buscar un helado
     * @param codigo
     * @return
     * @throws HeladoException
     */
    public Helado buscarHelado(String codigo) throws HeladoException{
        Helado helado = null;
        if(existeHelado(codigo)){
            for (Producto producto : listaProductos) {
                if(producto instanceof Helado){
                    if(producto.getCodigo().equals(codigo)){
                        helado = (Helado) producto;
                        return helado;
                    }
                }
            }
        }
        if(helado == null){
            throw new HeladoException("El helado no se encuentra");
        }
        return helado;
    }

    //----------------------------------------Crud gaseosa--------------------------------

    /**
     * metodo para crear una gaseosa
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param litros
     * @param sabor
     * @return
     * @throws GaseosaException
     */
    public Gaseosa crearGaseosa(String nombre2, String codigo , String categoria, double precio, Estado estado, String litros, String sabor) throws GaseosaException {

        Gaseosa gaseosa = new Gaseosa();
        gaseosa.setNombre(nombre);
        gaseosa.setCodigo(codigo);
        gaseosa.setCategoria(categoria);
        gaseosa.setPrecio(precio);
        gaseosa.setEstado(estado);
        gaseosa.setLitros(litros);
        gaseosa.setSabor(sabor);

        if(existeGaseosa(codigo) == true){
            throw new GaseosaException("El helado ya existe");
        }
        listaProductos.add(gaseosa);
        return gaseosa;
    }

    /**
     * metodo para verificar si la gaseosa existe
     * @param codigo
     * @return
     */
    private boolean existeGaseosa(String codigo) {
        for (Producto producto : listaProductos) {
            if (producto instanceof Gaseosa){
                if(producto.getCodigo().equals(codigo)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo para actualizar una gaseosa
     * @param nombre2
     * @param codigo
     * @param categoria
     * @param precio
     * @param estado
     * @param sabor
     * @param litros
     */
    public void actualizarGaseosa(String nombre2, String codigo , String categoria, double precio, Estado estado, String sabor, String litros) {

        for (Producto producto : listaProductos) {
            if (producto instanceof Gaseosa){
                if(producto.getCodigo().equals(codigo)){
                    producto.setNombre(nombre2);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setEstado(estado);
                    ((Gaseosa) producto).setSabor(sabor);
                    ((Gaseosa) producto).setLitros(litros);
                }
            }
        }
    }

    /**
     * metodo para eliminar una gaseosa
     * @param codigo
     * @return
     */
    public boolean eliminarGaseosa(String codigo){

        if (existeGaseosa(codigo)) {
            for (Producto producto : listaProductos) {
                if (producto instanceof Gaseosa) {
                    if (producto.getCodigo().equals(codigo)) {
                        listaProductos.remove(producto);
                        return true;
                    }
                }
            }
        }
        return false;
    }



    /**
     * metodo para buscar una gaseosa
     * @param codigo
     * @return
     * @throws GaseosaException
     */
    public Gaseosa buscarGaseosa (String codigo) throws GaseosaException {
        Gaseosa gaseosa = null;
        if (existeGaseosa(codigo)) {
            for (Producto producto : listaProductos) {
                if (producto instanceof Gaseosa) {
                    if (producto.getCodigo().equals(codigo)) {
                        gaseosa = (Gaseosa) producto;
                        return gaseosa;
                    }
                }
            }
        }
        if (gaseosa == null) {
            throw new GaseosaException("La gaseosa no se encuentra");
        }
        return gaseosa;
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
    public Vendedor nuevoVendedor(String nombre, String apellido, String cedula, String direccion, Vendedor theVendedor) throws VendedorException {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre(nombre);
        vendedor.setApellido(apellido);
        vendedor.setCedula(cedula);
        vendedor.setDireccion(direccion);
        vendedor.setTheVendedor(theVendedor);

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
    private boolean existeVendedor(String cedula) {

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
                                   String direccion, Vendedor theVendedor) {

        for (Vendedor vendedor : listaVendedores) {
            if(vendedor.getCedula().equals(cedula)){
                vendedor.setNombre(nombre2);
                vendedor.setApellido(apellido);
                vendedor.setDireccion(direccion);
                vendedor.setTheVendedor(theVendedor);

            }
        }
    }

    /**
     * metodo para eliminar un vendedor
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor (String cedula){

        if (existeVendedor(cedula)) {
            for (Vendedor vendedor : listaVendedores) {
                if (vendedor instanceof Vendedor) {
                    if (vendedor.getCedula().equals(cedula)) {
                        listaVendedores.remove(vendedor);
                        return true;
                    }
                }
            }
        } else {
            return false;
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


    //--------------------------------------Usuario crud-------------------------------
    public boolean eliminarUsuario(String cedula) {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedor.eliminarUsuario();
                return true;
            }
        }
        return false;
    }

    public boolean actualizarUsuario(String nuevoUsuario, String contrasenia, String cedula) throws UserException {
        for (Vendedor vendedor : listaVendedores) {
            if (vendedor.getCedula().equals(cedula)) {
                vendedor.actualizarUsuario(nuevoUsuario, contrasenia);
                return true;
            }
        }
        return false;
    }

    //-----------------------------------------------------------------------------------


}




