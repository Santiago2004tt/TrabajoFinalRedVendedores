package redVendedores.model;

import java.util.ArrayList;

public class Chats {
    Vendedor vendedor;
    ArrayList<Mensaje> mensajesVendedorLocal;

    public Chats(Vendedor vendedor) {
        this.vendedor = vendedor;
        mensajesVendedorLocal= new ArrayList<Mensaje>();
    }

    public Chats(){

    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ArrayList<Mensaje> getMensajesVendedorLocal() {
        return mensajesVendedorLocal;
    }

    public void setMensajesVendedorLocal(ArrayList<Mensaje> mensajesVendedorLocal) {
        this.mensajesVendedorLocal = mensajesVendedorLocal;
    }

}
