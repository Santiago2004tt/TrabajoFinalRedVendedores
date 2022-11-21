package redVendedores.test;

import redVendedores.model.RedVendedores;
import redVendedores.model.Vendedor;

public class test {
    static RedVendedores red = new RedVendedores("hola");

    public static void main(String[] args) {
        Vendedor vendedor=red.getListaVendedores().get(0);
        Vendedor vendedor1=red.getListaVendedores().get(1);
        red.agregarMeGusta(vendedor, vendedor1);

        //System.out.println(red.verificarExisteMeGusta(vendedor, vendedor1));
        System.out.println(vendedor1.getListaMeGusta().get(0).getVendedor().getNombre());
        red.quitarMeGusta(vendedor, vendedor1);
        //System.out.println(vendedor1.getListaMeGusta().size());
    }
}
