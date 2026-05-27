package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.HelloApplication;
import com.pluralsight.soobwaycapstone.OrderManager;
import com.pluralsight.soobwaycapstone.OrderSession;
import com.pluralsight.soobwaycapstone.models.enums.PresetSandwichEnum;
import com.pluralsight.soobwaycapstone.models.enums.Size;
import javafx.fxml.FXML;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class SignatureController {

    @FXML
    private FlowPane presetList;
    private HelloController parentController;
    private VBox content;

    public void setParentController(HelloController parent, VBox content) {
        this.parentController = parent;
        this.content = content;
    }

    public void setParentController(HelloController parent) {
        this.parentController = parent;
    }
    @FXML
    private void onBack() throws IOException {
      content.getChildren().setAll(parentController.getMainGrid());
    }

    public void initialize(){
        for (PresetSandwichEnum preset : PresetSandwichEnum.values()) {

            HBox row = new HBox(12);
            row.setPrefWidth(280);
            row.setMaxWidth(280);
            row.setAlignment(Pos.CENTER_LEFT);
            row.setOnMouseClicked(e -> System.out.println("Selected: " + preset.displayName));
            row.setCursor(javafx.scene.Cursor.HAND);

            VBox info = new VBox(4);
            Label name = new Label(preset.displayName);
            Label desc = new Label(preset.description);
            row.getStyleClass().add("preset-card");
            name.getStyleClass().add("preset-name");
            desc.getStyleClass().add("preset-desc");
            info.getChildren().addAll(name, desc);

            row.getChildren().add(info);
            presetList.getChildren().add(row);

            row.setOnMouseClicked(e -> {
                OrderManager.addPresetSandwich(OrderSession.getOrder(), preset, Size.MEDIUM);
                if (parentController != null) parentController.refreshSidebar();
            });
        }
    }





}
