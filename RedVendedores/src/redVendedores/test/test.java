package redVendedores.test;

import redVendedores.exceptions.VendedorException;
import redVendedores.model.RedVendedores;
import redVendedores.model.Vendedor;

import java.util.ArrayList;

public class test {
    static RedVendedores red = new RedVendedores("hola");

    public static void main(String[] args) throws VendedorException {
        ArrayList<Vendedor> lista= red.actualizarTablaRecomendados(red.getListaVendedores().get(0));
        lista = red.actualizarTablaRecomendados(red.getListaVendedores().get(0));
        //ArrayList<Vendedor> lista1= red.obtenerListaVendedoresRecomendados(red.getListaVendedores().get(1));
        System.out.println(red.getListaVendedores().get(0).getNombre());
        System.out.println(lista.size());

    }
}
