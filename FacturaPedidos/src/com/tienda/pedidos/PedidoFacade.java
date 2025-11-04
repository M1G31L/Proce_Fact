
package com.tienda.pedidos;
/*
 * @author ASUS
 */
public class PedidoFacade {
    private final ValidacionStock validacionStock;
    private final CalculoImpuestos calculoImpuestos;
    private final RegistroPedido registroPedido;
    private final FacturaService facturaService;

    public PedidoFacade(FacturaService facturaService) {
        this.validacionStock = new ValidacionStock();
        this.calculoImpuestos = new CalculoImpuestos();
        this.registroPedido = new RegistroPedido();
        this.facturaService = facturaService;
    }

    public void registrarPedido(String cliente, Producto producto, int cantidad) {
        if (cantidad <= 0) {
            System.out.println("❌ Cantidad inválida. Debe ser mayor que 0.");
            return;
        }

        if (validacionStock.validarCantidad(producto, cantidad)) {
            double subtotal = calculoImpuestos.calcularSubtotal(producto, cantidad);
            double igv = calculoImpuestos.calcularImpuesto(subtotal);
            double total = subtotal + igv;

            Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
            registroPedido.registrar(pedido);
            producto.reducirStock(cantidad);

            Factura factura = facturaService.generarFactura(pedido);
            factura.mostrarFactura();
        } else {
            System.out.println("❌ No hay suficiente stock disponible.");
        }
    }
}

