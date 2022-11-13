package redVendedores.model;

public class Cafe extends Producto {

    /**
     * Attributes
     */
    private String litros;
    private String sabor;

    /**
     * constructor de gaseosaa
     */
    public Cafe(String nombre, String codigo, String categoria, double precio, String litros, String sabor) {
        super(nombre, codigo, categoria, precio);
        this.litros = litros;
        this.sabor = sabor;
    }

    /**
     * get  and set de litros
     */
    public String getLitros() {
        return litros;
    }

    public void setLitros(String litros) {
        this.litros = litros;
    }

    /**
     * get and set de sabor
     *
     * @return
     */
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Gaseosa{" +
                "litros='" + litros + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}

