package com.pluralsight.soobwaycapstone.Controllers;

import com.pluralsight.soobwaycapstone.OrderSession;
import com.pluralsight.soobwaycapstone.models.Side;
import com.pluralsight.soobwaycapstone.models.enums.SideEnum;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SideController {
    @FXML
    private FlowPane presetList;
    private HelloController parentController;
    private VBox content;

    public void setParentController(HelloController parent, VBox content) {
        this.parentController = parent;
        this.content = content;
    }

    public void initialize(){
        for (SideEnum d : SideEnum.values()) {
            HBox row = new HBox(12);
            row.setPrefWidth(280);
            row.setMaxWidth(280);
            row.setAlignment(Pos.CENTER_LEFT);
            row.setOnMouseClicked(e -> System.out.println("Selected: " + d.displayName()));
            row.setCursor(javafx.scene.Cursor.HAND);

            VBox info = new VBox(4);
            Label name = new Label(d.displayName());
            Label price = new Label(String.format("$%,.2f", d.getPrice()));
            row.getStyleClass().add("preset-card");
            price.getStyleClass().add("preset-name");
            info.getChildren().addAll(name, price);
            row.getChildren().add(info);
            presetList.getChildren().add(row);

            row.setOnMouseClicked(e -> {
                HelloController.playInteractionFeedback();
                OrderSession.getOrder().addItem(new Side(d.displayName(), d.getPrice()));
                if (parentController != null) parentController.refreshSidebar();
            });
        }
    }

    @FXML
    private void onBack() {
        content.getChildren().setAll(parentController.getMainGrid());
    }

}

