package com.pluralsight.soobwaycapstone;

import atlantafx.base.theme.PrimerLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Scene createScene(String fxmlPath, double w, double h) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxmlPath));
        Scene scene = new Scene(fxmlLoader.load(), w , h);
        var css = HelloApplication.class.getResource("style.css");
        if (css != null) scene.getStylesheets().add(css.toExternalForm());
        return scene;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 520);
        scene.getStylesheets().add(
                HelloApplication.class.getResource("style.css").toExternalForm()
        );

        stage.setTitle("SOOBWAY Welcomes You!");
        stage.setScene(scene);
        stage.show();
    }

}
