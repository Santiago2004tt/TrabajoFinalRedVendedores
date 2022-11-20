package redVendedores.exceptions;

import redVendedores.model.Mensaje;

public class MensajeExceptions extends Exception {

    public MensajeExceptions(String mensaje){
        super(mensaje);
    }
}
