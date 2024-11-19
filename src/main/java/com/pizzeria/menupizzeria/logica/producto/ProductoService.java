package com.pizzeria.menupizzeria.logica.producto;

import com.pizzeria.menupizzeria.util.JsonUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.List;

public class ProductoService {

    private static final String FILE_PATH = "productos.json";
    private ObservableList<Producto> productoList = FXCollections.observableArrayList();

    public ProductoService() {
        cargarProductos();
    }

    public void agregarProducto(Producto producto) {
        productoList.add(producto);
        guardarProductos();
    }

    public ObservableList<Producto> getProductoList() {
        return productoList;
    }

    private void guardarProductos() {
        try {
            JsonUtil.writeListToFile(productoList, FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarProductos() {
        try {
            Type listType = new TypeToken<List<Producto>>() {}.getType();
            List<Producto> productos = JsonUtil.readListFromFile(FILE_PATH, listType);
            productoList.addAll(productos);
        } catch (IOException e) {
            // Archivo no existe o está vacío
            e.printStackTrace();
        }
    }
}
