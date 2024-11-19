package com.pizzeria.menupizzeria.logica.pedido;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class PedidoController {

    @FXML
    private TextField clienteField;

    @FXML
    private TableView<DetallePedido> detallesTableView;

    @FXML
    private TableColumn<DetallePedido, Integer> productoIdColumn;

    @FXML
    private TableColumn<DetallePedido, String> productoNombreColumn;

    @FXML
    private TableColumn<DetallePedido, Integer> cantidadColumn;

    @FXML
    private TableColumn<DetallePedido, Double> precioColumn;

    @FXML
    private TextField productoIdField;
    @FXML
    private TextField productoNombreField;
    @FXML
    private TextField cantidadField;
    @FXML
    private TextField precioField;


    @FXML
    private Button agregarDetalleButton;

    @FXML
    private Button crearPedidoButton;

    private PedidoService pedidoService = new PedidoService();

    @FXML
    public void initialize() {
        // Configurar las columnas del TableView
        productoIdColumn.setCellValueFactory(new PropertyValueFactory<>("productoId"));
        productoNombreColumn.setCellValueFactory(new PropertyValueFactory<>("productoNombre"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));

        detallesTableView.setItems(FXCollections.observableArrayList());
    }

    @FXML
    void agregarDetalle(ActionEvent event) {
        // Lógica para agregar un detalle al pedido
        int productoId = Integer.parseInt(productoIdField.getText());
        String productoNombre = productoNombreField.getText();
        int cantidad = Integer.parseInt(cantidadField.getText());
        double precio = Double.parseDouble(precioField.getText());

        DetallePedido detalle = new DetallePedido(productoId, productoNombre, cantidad, precio);
        detallesTableView.getItems().add(detalle);


        productoIdField.clear();
        productoNombreField.clear();
        cantidadField.clear();
        precioField.clear();
    }

    @FXML
    void crearPedido(ActionEvent event) {
        String cliente = clienteField.getText();
        ArrayList<DetallePedido> detalles = new ArrayList<>(detallesTableView.getItems());

        Pedido pedido = pedidoService.crearPedido(cliente, detalles);
        pedidoService.agregarPedido(pedido);

        // Limpiar los campos después de crear el pedido
        clienteField.clear();
        detallesTableView.getItems().clear();
    }
}
