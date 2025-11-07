
package com.tienda.pedidos;

public class RegistroPedido {
    public void registrar(Pedido pedido) {
        System.out.println("Pedido registrado correctamente para el cliente: " + pedido.getCliente());
    }
}
