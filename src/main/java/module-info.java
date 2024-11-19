module com.pizzeria.menupizzeria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires com.google.gson;

    opens com.pizzeria.menupizzeria to javafx.fxml;
    exports com.pizzeria.menupizzeria;

    exports com.pizzeria.menupizzeria.logica.producto;
    opens com.pizzeria.menupizzeria.logica.producto to javafx.fxml;

    exports com.pizzeria.menupizzeria.controllers;
    opens com.pizzeria.menupizzeria.controllers to javafx.fxml;
}
