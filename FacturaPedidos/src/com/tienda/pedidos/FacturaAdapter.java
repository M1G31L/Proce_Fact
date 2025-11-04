/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.pedidos;

/**
 *
 * @author ASUS
 */
public class FacturaAdapter {
    private LegacyBillingSystem legacySystem;

    public FacturaAdapter() {
        this.legacySystem = new LegacyBillingSystem();
    }

    @Override
    
    public void generarFactura(String cliente, String producto, int cantidad, double subtotal, double igv, double total) {
        double montoFinal = total;
        legacySystem.createInvoice(cliente, producto, cantidad, montoFinal);
    }
}