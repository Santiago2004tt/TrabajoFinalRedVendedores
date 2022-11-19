package redVendedores.model;

import javafx.scene.image.Image;

import java.time.format.DateTimeFormatter;

public class Producto {

    /**
     * Attributes
     */
    private String nombre;
    private String codigo;
    private String categoria;
    private double precio;
    private Estado estado;

    private Image image;

    private String date;

    /**
     * Constructor
     */
    public Producto(String nombre, String codigo, String categoria, double precio, Estado estado, Image image ,String  date) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.image = image;
        this.date = date;
    }

    public Producto() {

    }




    /**
     * get and set nombre
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get and set de codigo
     */
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * get and set categoria
     */
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * get and set de precio
     */
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * get and set the status
     * @return
     */
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * has code
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;

        return getCodigo() != null ? getCodigo().equals(producto.getCodigo()) : producto.getCodigo() == null;
    }

    @Override
    public int hashCode() {
        return getCodigo() != null ? getCodigo().hashCode() : 0;
    }
    /**
     * to string
     */

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }
}
