
package com.tienda.pedidos;

import models.Pedido;

public class RegistroPedido {
    public void registrar(Pedido pedido) {
        System.out.println("Pedido registrado correctamente para el cliente: " + pedido.getCliente());
    }
}
