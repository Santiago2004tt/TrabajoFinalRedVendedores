package redVendedores.model;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Mensaje {
    Vendedor vendedor;
    ArrayList<String>mensajesVendedorLocal;

    public Mensaje(Vendedor vendedor) {
        this.vendedor = vendedor;
        mensajesVendedorLocal = new ArrayList<String>();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public ArrayList<String> getMensajesVendedorLocal() {
        return mensajesVendedorLocal;
    }

    public void setMensajesVendedorLocal(ArrayList<String> mensajesVendedorLocal) {
        this.mensajesVendedorLocal = mensajesVendedorLocal;
    }

    public void añadirMensaje(String s) {
        mensajesVendedorLocal.add(s);
    }
}
