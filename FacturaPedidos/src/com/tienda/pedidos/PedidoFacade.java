
package com.tienda.pedidos;

import core.FacturaService;
import core.ImpuestoStrategy;
import models.Pedido;
import models.Producto;
import models.Factura;
import models.Sujeto;
import strategy.IGV18Strategy;

public class PedidoFacade extends Sujeto{
    private ValidacionStock validacionStock;
    private final CalculoImpuestos calculoImpuestos;
    private final RegistroPedido registroPedido;
    private final FacturaService facturaService;
    private ImpuestoStrategy impuestoStrategy;
    private final PedidoRepository pedidoRepository;

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
            //calcaular
            double igv = impuestoStrategy.calcular(subtotal);
            double total = subtotal + igv;
            Pedido pedido = new Pedido(cliente, producto, cantidad, subtotal, igv, total);
            Thread hiloPedido = new Thread(() -> {
            System.out.println("Hilo Pedido__Procesando pedido...");
            try {
                Thread.sleep(1000);
                registroPedido.registrar(pedido);
                notificar("Pedido registrado correctamente para " + cliente);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            Thread hiloFactura = new Thread(() -> {
            System.out.println("Hilo Factura__Generando factura...");
            try {
                Thread.sleep(2500);
                Factura factura = facturaService.generarFactura(pedido);
                factura.mostrarFactura();
                notificar("Factura generada para " + cliente);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
            Thread hiloNotificacion = new Thread(() -> {
            System.out.println("Hilo Notificaciones__Enviando notificaciones...");
            try {
                Thread.sleep(800);
                producto.reducirStock(cantidad);
                notificar("Notificacion enviada y stock actualizado del producto " + producto.getNombre());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
             hiloPedido.start();
             hiloFactura.start();
             hiloNotificacion.start();
             try {
                hiloPedido.join();
                hiloFactura.join();
                hiloNotificacion.join();
             } catch (InterruptedException e) {
                e.printStackTrace();
        }

        System.out.println("Pedido procesado correctamente para " + cliente + "\n");
    }
}
