package redVendedores.test;

import redVendedores.exceptions.MensajeExceptions;
import redVendedores.model.*;

import java.util.ArrayList;

public class Test {

    RedVendedores redVendedores;



    public static void main(String[] args) throws MensajeExceptions {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombre("pepe");
        vendedor.setApellido("Martinez");
        vendedor.setCedula("123");
        vendedor.setDireccion("en una casa");
        Cuenta cuenta = new Cuenta("pepito","pepe123");
        vendedor.setCuenta(cuenta);
        //-----------------------------------

        Cuenta cuenta1 = new Cuenta("Pachito","elpacho123");
        Vendedor vendedor1 = new Vendedor("miguel","garcia","7","Waza",null,cuenta1, null);

        ArrayList<Vendedor> listaVendedoresAliados2 = new ArrayList<Vendedor>();
        listaVendedoresAliados2.add(vendedor1);
        vendedor.setListaVendedoresAliados(listaVendedoresAliados2);
        ArrayList<Vendedor> listaVendedoresAliados = new ArrayList<Vendedor>();
        listaVendedoresAliados.add(vendedor);
        vendedor1.setListaVendedoresAliados(listaVendedoresAliados);
        Mensaje mensaje = new Mensaje(vendedor1);
        Mensaje mensaje1 = new Mensaje(vendedor);

        ArrayList<Mensaje> listaMensajes = new ArrayList<Mensaje>();
        listaMensajes.add(mensaje);
        vendedor.setListaMensajes(listaMensajes);
        vendedor.enviarMensaje("hola", vendedor1);

        System.out.println(vendedor.getListaMensajes().get(0).getMensajesVendedorLocal().get(0));
    }
}
