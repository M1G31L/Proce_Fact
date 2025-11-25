/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.pedidos;

import models.Pedido;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ASUS
 */
public class PedidoRepository {
    private List<Pedido> pedidos = new ArrayList<>();

    public void guardar(Pedido pedido) {
        pedidos.add(pedido);
        System.out.println("Pedido guardado en el repositorio correctamente.");
    }

    public List<Pedido> obtenerTodos() {
        return pedidos;
    }
}
    
