
package com.tienda.pedidos;

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