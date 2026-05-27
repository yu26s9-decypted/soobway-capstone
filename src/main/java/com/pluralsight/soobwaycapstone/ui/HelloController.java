package com.pluralsight.soobwaycapstone.ui;

import com.pluralsight.soobwaycapstone.HelloApplication;
import com.pluralsight.soobwaycapstone.OrderSession;
import com.pluralsight.soobwaycapstone.models.Item;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    public Label errorText;
    @FXML
    private Label welcomeText;

    @FXML private Label totallabel;
    @FXML private VBox content;
    @FXML private VBox orderItemList;
    @FXML private VBox mainGrid;
    public VBox getMainGrid() { return mainGrid; }



    public void refreshSidebar() {
        orderItemList.getChildren().clear();
        double total = 0;

        for (Item item : OrderSession.getOrder().getItem()) {
            Label label = new Label(item.getType() + "  $" + String.format("%.2f", item.calculatePrice()));
            orderItemList.getChildren().add(label);
            total += item.calculatePrice();
        }

        totallabel.setText(String.format("%.2f", total));
    }

    @FXML
    private void onSignature() throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("signatureitems-view.fxml"));
        VBox signatureView = loader.load();
        SignatureController signatureController = loader.getController();
        content.getChildren().setAll(signatureView);
        signatureController.setParentController(this, content);
    }

    @FXML
    private void onCancelOrder(){
        OrderSession.resetOrder();
        refreshSidebar();
    }

    public void onCheckOut() throws IOException {
        if (OrderSession.getOrder().getItem().isEmpty()) {
            errorText.setText("Please add items before checking out.");
            errorText.getStyleClass().add("error-text");
            return;
        }
        errorText.setText("");
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("checkout-view.fxml"));
        VBox checkoutView = loader.load();
        CheckoutController checkoutController = loader.getController();
        content.getChildren().setAll(checkoutView);
        checkoutController.setParentController(this, content);

    }
}
