package com.tienda.pedidos;
import java.util.Scanner;
/*
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Laptop", 1500.00, 10);
        LegacyBillingSystem legacy = new LegacyBillingSystem();
        FacturaService facturaService = new FacturaAdapter();
        PedidoFacade pedidoFacade = new PedidoFacade(facturaService);

        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Cliente: ");
            String cliente = sc.nextLine().trim();

            System.out.print("Producto: ");
            String productoNombre = sc.nextLine().trim();

            System.out.print("Cantidad: ");
            int cantidad = Integer.parseInt(sc.nextLine().trim());

            // en este ejemplo simple buscamos por nombre y usamos producto1
            pedidoFacade.registrarPedido(cliente, producto1, cantidad);
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida en número: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
