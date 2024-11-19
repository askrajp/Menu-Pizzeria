package com.pizzeria.menupizzeria.logica.producto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.TableRow;

import java.io.IOException;

public class ProductoController {

    @FXML
    private TextField nombreField;

    @FXML
    private TextField precioField;

    @FXML
    private TextField cantidadField;

    @FXML
    private ComboBox<String> categoriaComboBox;

    @FXML
    private ListView<Producto> productoListView;

    @FXML
    private TableView<ProductoGrouped> productoTableView;

    @FXML
    private TableColumn<ProductoGrouped, String> categoriaColumn;

    @FXML
    private TableColumn<ProductoGrouped, Integer> idColumn;

    @FXML
    private TableColumn<ProductoGrouped, String> nombreColumn;

    @FXML
    private TableColumn<ProductoGrouped, Double> precioColumn;

    @FXML
    private TableColumn<ProductoGrouped, Integer> cantidadColumn;

    private ProductoService productoService = new ProductoService();

    @FXML
    public void initialize() {
        // Configurar las columnas del TableView
        categoriaColumn.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precioColumn.setCellValueFactory(new PropertyValueFactory<>("precio"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        // Configurar TableView y ListView
        productoTableView.setItems(getGroupedProducts());
        productoTableView.setRowFactory(new Callback<TableView<ProductoGrouped>, TableRow<ProductoGrouped>>() {
            @Override
            public TableRow<ProductoGrouped> call(TableView<ProductoGrouped> tableView) {
                return new TableRow<ProductoGrouped>() {
                    @Override
                    protected void updateItem(ProductoGrouped item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && item.getProducto() == null) {
                            setText(item.getCategoria());
                            setStyle("-fx-font-weight: bold; -fx-background-color: lightgrey;");
                        } else {
                            setText(null);
                            setStyle("");
                        }
                    }
                };
            }
        });

        productoListView.setItems(productoService.getProductoList());
        categoriaComboBox.setItems(FXCollections.observableArrayList("Bebidas", "Empanadas", "Pizzas", "Pizzas Especiales", "Postres"));
    }

    private ObservableList<ProductoGrouped> getGroupedProducts() {
        ObservableList<ProductoGrouped> groupedProducts = FXCollections.observableArrayList();
        String currentCategory = "";

        for (Producto producto : productoService.getProductoList()) {
            if (!producto.getCategoria().equals(currentCategory)) {
                currentCategory = producto.getCategoria();
                groupedProducts.add(new ProductoGrouped(currentCategory, null));
            }
            groupedProducts.add(new ProductoGrouped(currentCategory, producto));
        }
        return groupedProducts;
    }

    @FXML
    void agregarProducto(ActionEvent event) {
        String nombre = nombreField.getText();
        double precio = Double.parseDouble(precioField.getText());
        int cantidad = Integer.parseInt(cantidadField.getText());
        String categoria = categoriaComboBox.getValue();

        Producto producto = new Producto(productoService.getProductoList().size() + 1, nombre, precio, cantidad, categoria);
        productoService.agregarProducto(producto);

        productoTableView.setItems(getGroupedProducts());

        nombreField.clear();
        precioField.clear();
        cantidadField.clear();
        categoriaComboBox.getSelectionModel().clearSelection();
    }

    @FXML
    void volverAlMenu(ActionEvent event) {
        try {
            // Cargar la vista del menú principal
            Parent root = FXMLLoader.load(getClass().getResource("/com/pizzeria/menupizzeria/menu.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Sistema Administrativo de Pizzería");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
