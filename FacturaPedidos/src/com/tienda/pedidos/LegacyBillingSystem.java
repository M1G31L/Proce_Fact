package com.tienda.pedidos;
/*
 * @author ASUS
 */
public class LegacyBillingSystem {
    public void createInvoice(String nombreCliente, String producto, int cantidad, double monto) {
        System.out.println("Factura creada en sistema antiguo:");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Monto Total: " + monto);
    }
}
