package com.tienda.pedidos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producto Laptop = new Producto("Laptop", 1500.00, 10);
        Producto Camara = new Producto("Camara", 900.00, 10);
        Producto Teclado = new Producto("Teclado", 150.00, 10);
        
        LegacyBillingSystem legacy = new LegacyBillingSystem();
        FacturaService facturaService = new FacturaAdapter(legacy);
        PedidoFacade pedidoFacade = new PedidoFacade(facturaService);

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("\nCliente: ");
                String cliente = sc.nextLine().trim();
                System.out.print("Producto (Laptop / Camara / Teclado): ");
                String productoNombre = sc.nextLine().trim();
                Producto productoSeleccionado = null;

                if (productoNombre.equalsIgnoreCase("Laptop")) {
                    productoSeleccionado = Laptop;
                } else if (productoNombre.equalsIgnoreCase("Camara")) {
                    productoSeleccionado = Camara;
                } else if (productoNombre.equalsIgnoreCase("Teclado")) {
                    productoSeleccionado = Teclado;
                } else {
                    System.out.println("Producto no encontrado. Intente de nuevo.");
                    continue; 
                }
                System.out.print("Cantidad: ");
                int cantidad = Integer.parseInt(sc.nextLine().trim());

                System.out.print("El producto esta exonerado de IGV? (s/n): ");
                String exonerado = sc.nextLine().trim().toLowerCase();

                if (exonerado.equals("s")) {
                    pedidoFacade.setImpuestoStrategy(new ExoneradoStrategy());
                } else {
                    pedidoFacade.setImpuestoStrategy(new IGV18Strategy());
                }
                pedidoFacade.registrarPedido(cliente, productoSeleccionado, cantidad);
                System.out.print("\n¿Desea registrar otro pedido? (s/n): ");
                String continuar = sc.nextLine().trim().toLowerCase();
                if (!continuar.equals("s")) {
                    System.out.println("Programa finalizado.");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida en número: " + e.getMessage());
            }
        }
        sc.close();
    }
}