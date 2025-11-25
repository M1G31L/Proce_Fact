
package models;

import models.Producto;


public class Pedido {
    private String cliente;
    private Producto producto;
    private int cantidad;
    private double subtotal;
    private double igv;
    private double total;
    
    public Pedido(String cliente, Producto producto, int cantidad, double subtotal, double igv, double total) {
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
       }
    public String getCliente(){
        return cliente;
    }
    public Producto getProducto(){
        return producto;
    }
    public double getSubtotal(){
        return subtotal;
    }
    public double getIgv(){
        return igv;
    }
    public double getTotal(){
        return total;
    }
    public int getCantidad() {
        return cantidad;
    }
}


    