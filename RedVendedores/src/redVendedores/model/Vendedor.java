package redVendedores.model;

import java.util.ArrayList;

public class Vendedor {
    //Atributs
    private String nombre;
    private String apellido;
    private String cedula;
    private String direccion;
    private Vendedor theVendedor;
    private ArrayList<Vendedor> listaVendedoresAliados;
    //Builder

    public Vendedor(String nombre, String apellido, String cedula, String direccion, Vendedor theVendedor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.direccion = direccion;
        this.theVendedor = theVendedor;
        listaVendedoresAliados = new ArrayList<Vendedor>();
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

    //Hash e equals
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
}
