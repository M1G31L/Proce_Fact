package com.tienda.pedidos;

public class LegacyBillingSystem {
    public void createInvoice(String nombreCliente, String producto, int cantidad, double monto) {
        System.out.println("Factura creada en sistema antiguo:");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Producto: " + producto);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Monto Total: " + monto);
    }
 public Factura generarFacturaAntigua(Pedido pedido) {
    
    createInvoice(
        pedido.getCliente(),
        pedido.getProducto().getNombre(),
        pedido.getCantidad(),
        pedido.getTotal()
    );
    return new Factura(
            pedido.getCliente(),
            pedido.getProducto().getNombre(),
            pedido.getSubtotal(),
            pedido.getIgv(),
            pedido.getTotal()
        );
    }
}   