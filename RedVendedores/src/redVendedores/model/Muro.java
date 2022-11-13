package redVendedores.model;

import java.util.Objects;

public class Muro {
    private String mensaje;
    private String comentarios;
    private int me_gusta;

    /**
     * class Muro constructor method
     * @param mensaje
     * @param comentarios
     * @param me_gusta
     */
    public Muro(String mensaje, String comentarios, int me_gusta) {
        super();
        this.setMensaje(mensaje);
        this.setComentarios(comentarios);
        this.setMe_gusta(me_gusta);
    }

    public Muro() {
    }

    /**
     * mensaje getter method
     * @return
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * mensaje setter method
     * @param mensaje
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * comentarios getter method
     * @return
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * comentarios setter method
     * @param comentarios
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * me_gusta getter method
     * @return
     */
    public int getMe_gusta() {
        return me_gusta;
    }

    /**
     * me_gusta setter method
     * @param me_gusta
     */
    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }

    /**
     * Muro class hash code method
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(comentarios, me_gusta, mensaje);
    }

    /**
     * Muro class equals method
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Muro other = (Muro) obj;
        return Objects.equals(comentarios, other.comentarios) && me_gusta == other.me_gusta
                && Objects.equals(mensaje, other.mensaje);
    }

    /**
     * Muro class to string method
     * @return
     */
    @Override
    public String toString() {
        return "Muro [mensaje=" + mensaje + ", comentarios=" + comentarios + ", me_gusta=" + me_gusta + "]";
    }
}
