package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.HelloApplication;
import javafx.fxml.FXML;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SignatureController {

    @FXML
    private VBox presetList;

    @FXML
    private void onBack() throws IOException {
        Stage stage = (Stage) presetList.getScene().getWindow();
        stage.setScene(HelloApplication.createScene("hello-view.fxml", 900, 620));
    }


}
