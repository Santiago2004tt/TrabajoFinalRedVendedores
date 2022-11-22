package redVendedores.model;

public class Administrador extends Usuario{

    private Cuenta cuenta;

    public Administrador(String nombre, String apellido, String cedula, String direccion, Usuario usuario, Cuenta cuenta) {
        super(nombre, apellido, cedula, direccion, usuario);
        this.cuenta = cuenta;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Administrador() {

    }

    public boolean verificarCuentaAdministrador(String usuario, String contrasenia) {
        if(cuenta.getUsuario().equals(usuario)&&cuenta.getContrasenia().equals(contrasenia)){
            return true;
        }
        return false;
    }
}
