package redVendedores.model;

public class Gaseosa extends Producto {

    //Atributs
    private String litros;
    private String sabor;

    public Gaseosa(String nombre, String codigo, String categoria, double precio, Estado estado, String litros, String sabor) {
        super(nombre, codigo, categoria, precio, estado);
        this.litros = litros;
        this.sabor = sabor;
    }

    /**
     * constructor de gaseosaa
     */


    public Gaseosa() {

    }

    //get y set

    /**
     * get de litros
     *
     * @return
     */
    public String getLitros() {
        return litros;
    }

    /**
     * set de litros
     *
     * @param litros
     */
    public void setLitros(String litros) {
        this.litros = litros;
    }

    /**
     * get de sabor
     *
     * @return
     */
    public String getSabor() {
        return sabor;
    }

    /**
     * set de sabor
     *
     * @param sabor
     */
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
