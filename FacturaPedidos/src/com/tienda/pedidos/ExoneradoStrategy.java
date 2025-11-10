
package com.tienda.pedidos;

public class ExoneradoStrategy implements ImpuestoStrategy {
    @Override
    public double calcular(double subtotal) {
        return 0.0; 
    }
}
