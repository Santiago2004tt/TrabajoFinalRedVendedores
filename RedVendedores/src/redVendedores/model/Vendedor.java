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
     * metodo get de nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * metodo set de nombre
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *metodo get de apellido
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * metodo set de apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * metodo get de cedula
     * @return
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * metodo set de cedula
     * @param cedula
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * metodo get de direccion
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * metodo set de direccion
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * metodo get de vendedor
     * @return
     */
    public Vendedor getTheVendedor() {
        return theVendedor;
    }

    /**
     *
     * metodo set de vendedor
     * @param theVendedor
     */
    public void setTheVendedor(Vendedor theVendedor) {
        this.theVendedor = theVendedor;
    }

    /**
     * metodo get de la lista de vendedores aliados
     * @return
     */
    public ArrayList<Vendedor> getListaVendedoresAliados() {
        return listaVendedoresAliados;
    }

    /**
     * metodo set de la lista de vendedores aliados
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
