package com.pluralsight.soobwaycapstone.Controllers;

import com.pluralsight.soobwaycapstone.HelloApplication;
import com.pluralsight.soobwaycapstone.OrderSession;
import com.pluralsight.soobwaycapstone.RecieptManager;
import com.pluralsight.soobwaycapstone.models.Discount;
import com.pluralsight.soobwaycapstone.models.Item;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class CheckoutController {

    public ImageView paymentIcon;
    public Label paymentStatus;
    public VBox receiptContainer;
    public Label paymentsubtext;
    private HelloController parentController;
    private VBox content;

    public void setParentController(HelloController parent, VBox content) {
        this.parentController = parent;
        this.content = content;
    }


    public void simulatePayment() {
        paymentIcon.setImage(new Image(HelloApplication.class.getResourceAsStream("asset/spinner.png")));
        paymentStatus.setText("Processing payment...");
        RotateTransition spin = new RotateTransition(Duration.millis(800), paymentIcon);
        spin.setByAngle(360);
        spin.setCycleCount(RotateTransition.INDEFINITE);
        spin.play();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.setOnFinished(e -> {
            var soundUrl = HelloApplication.class.getResource("asset/PaymentSuccess.mp3");
            if (soundUrl != null) {
                AudioClip clip = new AudioClip(soundUrl.toString());
                clip.play();
            }

            spin.stop();
            paymentIcon.setRotate(0);
            paymentIcon.setImage(new Image(HelloApplication.class.getResourceAsStream("asset/checkmark.png")));
            paymentStatus.setText("Payment Accepted.");
            paymentsubtext.setText("Transaction completed.");

            double totalPrice = OrderSession.getOrder().getItem().stream()
                            .mapToDouble(Item::calculatePrice)
                            .sum();
            int orderNumber = (int) (Math.random() * 9000 + 1000);
            String r = RecieptManager.saveReciept(OrderSession.getOrder(), totalPrice, orderNumber, Discount.none(), null );
            System.out.println(r);

            Label result = new Label(r);
            receiptContainer.getChildren().add(result);

            OrderSession.resetOrder();
            parentController.refreshSidebar();
            SequentialTransition sequentialTransition = new SequentialTransition();

            for(int i = 5; i > 0; i--){
                final int count = i;
                PauseTransition p = new PauseTransition(Duration.seconds(1));
                p.setOnFinished(event ->
                        paymentsubtext.setText("Returning you to the Menu Start POS Screen in" + (count - 1)));
                sequentialTransition.getChildren().add(p);
            }

            sequentialTransition.setOnFinished(ev -> {
                content.getChildren().setAll(parentController.getMainGrid());
            });
            sequentialTransition.play();

        });
        pauseTransition.play();
    }

    @FXML
    private void onBack() {
        content.getChildren().setAll(parentController.getMainGrid());
    }

    public void simulateFailedPayment() {
        paymentIcon.setImage(new Image(HelloApplication.class.getResourceAsStream("asset/spinner.png")));
        paymentStatus.setText("Processing payment...");
        RotateTransition spin = new RotateTransition(Duration.millis(800), paymentIcon);
        spin.setByAngle(360);
        spin.setCycleCount(RotateTransition.INDEFINITE);
        spin.play();

        PauseTransition pauseTransition = new PauseTransition(Duration.seconds(2));
        pauseTransition.setOnFinished(e -> {
            var soundUrl = HelloApplication.class.getResource("asset/FailedPayment.mp3");
            if (soundUrl != null) {
                AudioClip clip = new AudioClip(soundUrl.toString());
                clip.play();
            }

            spin.stop();
            paymentIcon.setRotate(0);
            paymentIcon.setImage(new Image(HelloApplication.class.getResourceAsStream("asset/Failed.png")));
            paymentStatus.setText("Payment Failed.");
            paymentsubtext.setText("We could not complete your transaction ):");

        });
        pauseTransition.play();
    }
}