package redVendedores.model;

public class Helado extends Producto {
    //Atributs
    private String tamanio;
    private String sabor;

    /**
     * metodo constructor
     */
    public Helado(String nombre, String codigo, String categoria, double precio, String tamanio, String sabor) {
        super(nombre, codigo, categoria, precio);
        this.tamanio = tamanio;
        this.sabor = sabor;
    }

    /**
     * get de tamanio
     *
     * @return
     */
    public String getTamanio() {
        return tamanio;
    }

    /**
     * set de tamanio
     *
     * @param tamanio
     */
    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
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

    @Override
    public String toString() {
        return "Helado{" +
                "tamanio='" + tamanio + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
