/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.pedidos;

/**
 *
 * @author ASUS
 */
public class ValidacionStock {
    public boolean validarCantidad(Producto producto, int cantidad) {
        return cantidad > 0 && producto.getStock() >= cantidad;
    }
}
