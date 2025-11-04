/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda.pedidos;

/**
 *
 * @author ASUS
 */
public interface FacturaService {
    void generarFactura(String cliente, String producto, int cantidad, double subtotal, double igv, double total);
}
    
