package com.pluralsight.soobwaycapstone.Controllers;

import com.pluralsight.soobwaycapstone.OrderManager;
import com.pluralsight.soobwaycapstone.OrderSession;
import com.pluralsight.soobwaycapstone.models.Drink;
import com.pluralsight.soobwaycapstone.models.enums.DrinkEnum;
import com.pluralsight.soobwaycapstone.models.enums.PresetSandwichEnum;
import com.pluralsight.soobwaycapstone.models.enums.Size;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class DrinksController {
    @FXML
    private FlowPane presetList;
    private HelloController parentController;
    private VBox content;

    public void setParentController(HelloController parent, VBox content) {
        this.parentController = parent;
        this.content = content;
    }

    public void initialize(){
        for (DrinkEnum d : DrinkEnum.values()) {
            HBox row = new HBox(12);
            row.setPrefWidth(280);
            row.setMaxWidth(280);
            row.setAlignment(Pos.CENTER_LEFT);
            row.setOnMouseClicked(e -> System.out.println("Selected: " + d.displayName));
            row.setCursor(javafx.scene.Cursor.HAND);

            VBox info = new VBox(4);
            Label name = new Label(d.displayName);
            Label price = new Label(String.format("$%,.2f", d.price));
            row.getStyleClass().add("preset-card");
            price.getStyleClass().add("preset-name");
            info.getChildren().addAll(name, price);
            row.getChildren().add(info);
            presetList.getChildren().add(row);

            row.setOnMouseClicked(e -> {
                HelloController.playInteractionFeedback();
                OrderSession.getOrder().addItem(new Drink(Size.MEDIUM, d.displayName));
                if (parentController != null) parentController.refreshSidebar();

            });
        }
    }

    @FXML
    private void onBack() {
        content.getChildren().setAll(parentController.getMainGrid());
    }

}
