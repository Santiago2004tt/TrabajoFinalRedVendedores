package redVendedores.model;

import java.util.Objects;

public class Cuenta {
    private String usuario;
    private String contrasenia;

    /**
     * constructor method for usuario
     * @param usuario
     * @param contrasenia
     */
    public Cuenta(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }
    /**
     * empty constructor method for usuario
     */
    public Cuenta() {
    }

    /**
     * Usuario getter method
     * @return
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Usuario setter method
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * contrasenia getter method
     * @return
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * contrasenia setter method
     * @param contrasenia
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    /**
     * Equals method for Usuario class
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cuenta cuenta = (Cuenta) o;

        if (!Objects.equals(usuario, cuenta.usuario)) return false;
        return Objects.equals(contrasenia, cuenta.contrasenia);
    }

    @Override
    public int hashCode() {
        int result = usuario != null ? usuario.hashCode() : 0;
        result = 31 * result + (contrasenia != null ? contrasenia.hashCode() : 0);
        return result;
    }

    /**
     * toString method for Usuario class
     * @return
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

}
