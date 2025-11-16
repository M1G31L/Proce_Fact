
package com.tienda.pedidos;

public class ClienteObservador implements Observador {
    private String nombre;
            
    public ClienteObservador(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void actualizar(String mensaje) {
        System.out.println("Cliente " + nombre + ": " + mensaje);
    }  
}
