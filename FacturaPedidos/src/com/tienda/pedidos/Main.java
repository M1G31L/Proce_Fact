package com.tienda.pedidos;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Producto Laptop = new Producto("Laptop", 1500.00, 10);
        Producto Camara = new Producto("camara", 900.00, 10);
        Producto Teclado = new Producto("teclado", 150.00, 10);
        
        LegacyBillingSystem legacy = new LegacyBillingSystem();
        FacturaService facturaService = new FacturaAdapter(legacy);
        PedidoFacade pedidoFacade = new PedidoFacade(facturaService);

        try (Scanner sc = new Scanner(System.in)) {
    System.out.print("Cliente: ");
    String cliente = sc.nextLine().trim();

    System.out.print("Producto (Laptop / Camara / Teclado): ");
    String productoNombre = sc.nextLine().trim();

    System.out.print("Cantidad: ");
    int cantidad = Integer.parseInt(sc.nextLine().trim());

    Producto productoSeleccionado;

    if (productoNombre.equalsIgnoreCase("Laptop")) {
        productoSeleccionado = Laptop;
    } else if (productoNombre.equalsIgnoreCase("Camara")) {
        productoSeleccionado = Camara;
    } else if (productoNombre.equalsIgnoreCase("Teclado")) {
        productoSeleccionado = Teclado;
    } else {
        System.out.println("Producto no encontrado.");
        return;
    }

    pedidoFacade.registrarPedido(cliente, productoSeleccionado, cantidad);
}
catch (NumberFormatException e) {
    System.out.println("Entrada inválida en número: " + e.getMessage());
        }
    }
}

