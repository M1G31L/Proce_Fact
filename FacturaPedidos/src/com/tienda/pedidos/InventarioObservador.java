
package com.tienda.pedidos;

public class InventarioObservador implements Observador {
        @Override
    public void actualizar(String mensaje) {
        System.out.println("Inventario actualizado: " + mensaje);
    }
    
}
