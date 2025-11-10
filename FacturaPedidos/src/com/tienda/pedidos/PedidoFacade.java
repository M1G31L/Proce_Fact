
package com.tienda.pedidos;

public class PedidoFacade {
    private ValidacionStock validacionStock;
    private CalculoImpuestos calculoImpuestos;
    private RegistroPedido registroPedido;
    private FacturaService facturaService;
    private ImpuestoStrategy impuestoStrategy;
    private PedidoRepository pedidoRepository;

    public PedidoFacade(FacturaService facturaService) {
        this.validacionStock = new ValidacionStock();
        this.calculoImpuestos = new CalculoImpuestos();
        this.registroPedido = new RegistroPedido();
        this.pedidoRepository = new PedidoRepository();
        this.facturaService = facturaService;
    }
    public void setImpuestoStrategy(ImpuestoStrategy impuestoStrategy) {
        this.impuestoStrategy = impuestoStrategy;
    }

    public void registrarPedido(String cliente, Producto producto, int cantidad) {
            if (!validacionStock.validarCantidad(producto, cantidad)) {
            System.out.println("No hay suficiente stock.");
            return;
        }
            
            double subtotal = calculoImpuestos.calcularSubtotal(producto, cantidad);
            if (impuestoStrategy == null) {
            System.out.println("No se seleccionó estrategia de impuestos. Se aplicará IGV por defecto.");
            impuestoStrategy = new IGV18Strategy();
        }
            double igv = calculoImpuestos.calcularImpuesto(subtotal);
            double total = subtotal + igv;
            

            Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
            registroPedido.registrar(pedido);

            Factura factura = facturaService.generarFactura(pedido);
            factura.mostrarFactura();
        } 
      
}
