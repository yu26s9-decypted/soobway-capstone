module com.pluralsight.soobwaycapstone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires atlantafx.base;
    requires com.fasterxml.jackson.databind;
    requires java.sql;

    opens com.pluralsight.soobwaycapstone to javafx.fxml;
    exports com.pluralsight.soobwaycapstone;
    exports com.pluralsight.soobwaycapstone.ui;
    opens com.pluralsight.soobwaycapstone.ui to javafx.fxml;
    exports com.pluralsight.soobwaycapstone.models;
    exports com.pluralsight.soobwaycapstone.models.enums;
    exports com.pluralsight.soobwaycapstone.Database;
    opens com.pluralsight.soobwaycapstone.Database to javafx.fxml;
}