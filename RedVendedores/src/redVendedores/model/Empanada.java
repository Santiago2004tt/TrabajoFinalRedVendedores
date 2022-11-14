package redVendedores.model;

public class Empanada extends Producto {

    //Atributs
    private String relleno;

    public Empanada(String nombre, String codigo, String categoria, double precio, Estado estado, String relleno) {
        super(nombre, codigo, categoria, precio, estado);
        this.relleno = relleno;
    }

    public Empanada() {

    }



    //get y set

    /**
     * get and set de relleno
     *
     * @return
     */
    public String getRelleno() {
        return relleno;
    }

    public void setRelleno(String relleno) {
        this.relleno = relleno;
    }

    /**
     * to string
     */
    @Override
    public String toString() {
        return "Empanada{" +
                "relleno='" + relleno + '\'' +
                '}';
    }
}

