/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.pedidos;

import core.FacturaService;
import models.Pedido;
import models.Factura;

public class FacturaAdapter implements FacturaService {

    private LegacyBillingSystem legacySystem;

    public FacturaAdapter(LegacyBillingSystem legacySystem) {
        this.legacySystem = legacySystem;
    }
@Override
    public Factura generarFactura(Pedido pedido) {
        return legacySystem.generarFacturaAntigua(pedido);
    }
}
