package com.nttdata.steps;

import com.nttdata.screens.MiAppScreen;
import com.nttdata.screens.Producto1Screen;

public class Producto1Steps {

    private final Producto1Screen screen = new Producto1Screen();

    public boolean pantallaProductos () {
        System.out.println("[Producto1Steps] pantalladeproductos: validando resultado...");
        return screen.estaEnPantallaProductos();
    }
    public void clicEnPrimerProducto() {
            System.out.println("[Producto1Steps] SelecionarPrimerProducto");
            screen.abrirPrimerProducto();
        }
    public void cantidadPrimerProducto() {
        System.out.println("[Producto1Steps] clicEnCantidadPrimerProducto");
        screen.btnCantidad();
    }
    public void agregarPrimerProducto() {
        System.out.println("[Producto1Steps] clicEnCantidadPrimerProducto");
        screen.btnAgregar();}

    public void volverListaProducto() {
        System.out.println("[Producto1Steps] clicEnCantidadPrimerProducto");
        screen.volverALaLista();
    }
    public boolean irACarrito() {
        System.out.println("[Producto1Steps] clicEnCantidadPrimerProducto");
        return true;
    }

}
