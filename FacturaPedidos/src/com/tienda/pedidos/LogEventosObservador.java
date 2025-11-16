
package com.tienda.pedidos;

public class LogEventosObservador implements Observador{
    @Override
    public void actualizar(String mensaje){
        System.out.println("Sistema: " + mensaje);
    }  
}
