package redVendedores.model;

public class Cafe extends Producto {

    /**
     * Attributes
     */
    private String libras;

    public Cafe(String nombre, String codigo, String categoria, double precio, Estado estado, String libras) {
        super(nombre, codigo, categoria, precio, estado);
        this.libras = libras;
    }

    public Cafe() {
        super();
    }

    /**
     * constructor de gaseosaa
     */


    public String getLibras() {
        return libras;
    }

    public void setLibras(String libras) {
        this.libras = libras;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "libras='" + libras + '\'' +
                '}';
    }
}

