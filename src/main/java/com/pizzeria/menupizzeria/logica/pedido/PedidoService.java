package com.pizzeria.menupizzeria.logica.pedido;

import com.pizzeria.menupizzeria.util.JsonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private static final String FILE_PATH = "pedidos.json";
    private ObservableList<Pedido> pedidosList = FXCollections.observableArrayList();

    public PedidoService() {
        cargarPedidos();
    }

    public void agregarPedido(Pedido pedido) {
        pedidosList.add(pedido);
        guardarPedidos();
    }

    public ObservableList<Pedido> getPedidosList() {
        return pedidosList;
    }

    private void guardarPedidos() {
        try {
            JsonUtil.writeListToFile(pedidosList, FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarPedidos() {
        try {
            Type listType = new TypeToken<List<Pedido>>() {}.getType();
            List<Pedido> pedidos = JsonUtil.readListFromFile(FILE_PATH, listType);
            pedidosList.addAll(pedidos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Pedido crearPedido(String cliente, ArrayList<DetallePedido> detalles) {
        int id = pedidosList.size()+ 1;
        double total = detalles.stream().mapToDouble(detalle -> detalle.getPrecio() * detalle.getCantidad()).sum();
        LocalDateTime fecha = LocalDateTime.now();
        return new Pedido(id, cliente, detalles, total, fecha);
    }
}
