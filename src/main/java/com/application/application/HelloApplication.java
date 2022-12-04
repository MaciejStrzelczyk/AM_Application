package com.application.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),800, 600);
        stage.setTitle("AM_Application!");
        stage.getIcons().add(new Image("/iconjson1.jpg"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}