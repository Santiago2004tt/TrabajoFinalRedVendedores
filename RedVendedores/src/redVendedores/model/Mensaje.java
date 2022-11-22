package redVendedores.model;

import java.util.Objects;

public class Mensaje {

    private Vendedor autor;
    private String contenido;

    public Mensaje(Vendedor autor, String contenido) {
        this.autor = autor;
        this.contenido = contenido;
    }

    public Mensaje() {
    }

    public Vendedor getAutor() {
        return autor;
    }

    public void setAutor(Vendedor autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensaje mensaje = (Mensaje) o;
        return Objects.equals(contenido, mensaje.contenido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contenido);
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "autor=" + autor +
                '}';
    }
}
