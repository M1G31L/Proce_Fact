
package com.tienda.pedidos;

public class PedidoFacade {
    private ValidacionStock validacionStock;
    private CalculoImpuestos calculoImpuestos;
    private RegistroPedido registroPedido;
    private FacturaService facturaService;

    public PedidoFacade(FacturaService facturaService) {
        this.validacionStock = new ValidacionStock();
        this.calculoImpuestos = new CalculoImpuestos();
        this.registroPedido = new RegistroPedido();
        this.facturaService = facturaService;
    }

    public void registrarPedido(String cliente, Producto producto, int cantidad) {
        if (validacionStock.validarCantidad(producto, cantidad)) {
            double subtotal = calculoImpuestos.calcularSubtotal(producto, cantidad);
            double igv = calculoImpuestos.calcularImpuesto(subtotal);
            double total = subtotal + igv;

            Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
            registroPedido.registrar(pedido);

            Factura factura = facturaService.generarFactura(pedido);
            factura.mostrarFactura();
        } else {
            System.out.println(" No hay suficiente stock.");
        }
    }
}
