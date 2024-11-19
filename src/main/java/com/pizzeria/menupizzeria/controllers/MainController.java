package com.pizzeria.menupizzeria.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    void gestionarProductos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/pizzeria/menupizzeria/producto.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Productos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarPedidos(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/pizzeria/menupizzeria/pedido.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Gestión de Pedidos");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void gestionarClientes(ActionEvent event) {

        System.out.println("Gestionar Clientes clicked");
    }

    @FXML
    void generarReportes(ActionEvent event) {

        System.out.println("Generar Reportes clicked");
    }
}
