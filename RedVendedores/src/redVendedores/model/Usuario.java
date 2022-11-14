package redVendedores.model;

import java.util.Objects;

public class Usuario {
    private String usuario;
    private String contrasenia;

    /**
     * constructor method for usuario
     * @param usuario
     * @param contrasenia
     */
    public Usuario(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    /**
     * empty constructor method for usuario
     */
    public Usuario() {
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
        Usuario usuario1 = (Usuario) o;
        return Objects.equals(usuario, usuario1.usuario) && Objects.equals(contrasenia, usuario1.contrasenia);
    }

    /**
     * hashCode method for usuario class
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(usuario, contrasenia);
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


