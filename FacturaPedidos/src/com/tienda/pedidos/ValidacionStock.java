
package com.tienda.pedidos;

public class ValidacionStock {
    public boolean validarCantidad(Producto producto, int cantidad) {
        return producto.getStock() >= cantidad && cantidad > 0;
    }

}
