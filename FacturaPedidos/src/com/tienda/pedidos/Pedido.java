/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.pedidos;

/**
 *
 * @author ASUS
 */
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
    public String getClient(){
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

    String getCliente() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }
