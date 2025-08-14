package com.example.jfxholamundo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader =
               new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        //new FXMLLoader(HelloApplication.class.getResource("pru1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 540);
        stage.setTitle("Hola clase 1dam!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}