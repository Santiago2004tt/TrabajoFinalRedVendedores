package redVendedores.model;

public class MeGusta {

    private Vendedor vendedor;

    public MeGusta(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public MeGusta(){

    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
}
