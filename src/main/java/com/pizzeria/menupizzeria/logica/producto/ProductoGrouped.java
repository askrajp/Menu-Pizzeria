package com.pizzeria.menupizzeria.logica.producto;

public class ProductoGrouped {
    private String categoria;
    private Producto producto;

    public ProductoGrouped(String categoria, Producto producto) {
        this.categoria = categoria;
        this.producto = producto;
    }

    public String getCategoria() {
        return categoria;
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getId() {
        return producto != null ? producto.getId() : null;
    }

    public String getNombre() {
        return producto != null ? producto.getNombre() : null;
    }

    public Double getPrecio() {
        return producto != null ? producto.getPrecio() : null;
    }

    public Integer getCantidad() {
        return producto != null ? producto.getCantidad() : null;
    }

    public String getCategoriaProducto() {
        return producto != null ? producto.getCategoria() : null;
    }
}
