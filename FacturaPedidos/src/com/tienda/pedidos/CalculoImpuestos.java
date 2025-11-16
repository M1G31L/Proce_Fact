package com.tienda.pedidos;

public class CalculoImpuestos {
    private static final double IGV = 0.18;

    public double calcularSubtotal(Producto producto, int cantidad) {
        return round3(producto.getPrecio() * cantidad);
    }

    public double calcularImpuesto(double subtotal) {
        return round3(subtotal * IGV);
    }

    private double round3(double value) {
        return Math.round(value * 1000.0) / 1000.0;
    }
}
