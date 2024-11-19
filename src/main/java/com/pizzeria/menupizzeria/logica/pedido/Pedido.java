package com.pizzeria.menupizzeria.logica.pedido;

import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
    private int id;
    private String cliente;
    private List<DetallePedido> detalles;
    private double total;
    private LocalDateTime fecha;

    public Pedido(int id, String cliente, List<DetallePedido> detalles, double total, LocalDateTime fecha) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
        this.total = total;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public List<DetallePedido> getDetalles() { return detalles; }
    public void setDetalles(List<DetallePedido> detalles) { this.detalles = detalles; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
