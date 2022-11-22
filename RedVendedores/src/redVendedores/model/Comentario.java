package redVendedores.model;

import java.util.Objects;

public class Comentario {
    private String mensaje;
    private Vendedor vendedor;

    public Comentario(String mensaje, Vendedor vendedor) {
        this.mensaje = mensaje;
        this.vendedor = vendedor;
    }

    public Comentario() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(mensaje, that.mensaje) && Objects.equals(vendedor, that.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mensaje, vendedor);
    }
}
