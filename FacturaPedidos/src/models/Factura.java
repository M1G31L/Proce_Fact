
package models;


public class Factura {
    private String cliente;
    private String producto;
    private double subtotal;
    private double igv;
    private double total;
    
    public Factura(String cliente, String producto, double subtotal, double igv, double total) {
        this.cliente = cliente;
        this.producto = producto;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
    }
    public void mostrarFactura() {
        System.out.println("Factura");
        System.out.println("Cliente: " + cliente);
        System.out.println("Producto: " + producto);
        System.out.println("Subtotal: " + subtotal);
        System.out.println("IGV: " + igv);
        System.out.println("Total: " + total);
        System.out.println("------------------------------");
    }
}
