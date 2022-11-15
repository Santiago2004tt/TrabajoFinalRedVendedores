package redVendedores.model;

import redVendedores.exception.VendedorException;

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
    public Vendedor nuevoVendedor(String nombre, String apellido, String cedula,
                                  String direccion, Vendedor theVendedor) throws VendedorException {
        Vendedor vendedor = new Vendedor(nombre, apellido, cedula, direccion, theVendedor);
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
     * actualizar datos vendedor
     * @param nombre2
     * @param apellido
     * @param cedula
     * @param direccion
     * @param theVendedor
     */
    public void actualizarVendedor(String nombre2, String apellido, String cedula,
                                   String direccion, Vendedor theVendedor) {

        for (Vendedor vendedor : listaVendedores) {
            if (vendedor instanceof Vendedor){
                if(vendedor.getCedula().equals(cedula)){
                    vendedor.setNombre(nombre2);
                    vendedor.setApellido(apellido);
                    vendedor.setDireccion(direccion);
                    vendedor.setTheVendedor(theVendedor);
                }
            }
        }
    }

    /**
     * delete vendedor
     * @param cedula
     * @return
     */
    public boolean eliminarVendedor(String cedula) {

        if(existeVendedor(cedula)){
            for (Vendedor vendedor : listaVendedores) {
                if(vendedor instanceof Vendedor){
                    if(vendedor.getCedula().equals(cedula)){
                        listaVendedores.remove(vendedor);
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

}
