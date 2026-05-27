package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML private Label totallabel;
    @FXML private VBox content;

    @FXML
    private void onSignature() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("signatureitems-view.fxml"));
        VBox signatureView = loader.load();
        content.getChildren().setAll(signatureView);
    }
}
