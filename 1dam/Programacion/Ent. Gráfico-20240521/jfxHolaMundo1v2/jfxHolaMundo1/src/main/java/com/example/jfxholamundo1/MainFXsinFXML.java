package com.example.jfxholamundo1;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

import java.util.ResourceBundle;
public class MainFXsinFXML extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Hola 1DAM Luis Vives");
        Button b1= new Button();
        b1.setText("Boton1");
        b1.setOnAction(actionEvent -> {
            System.out.println("pulsado botón1");
            Alert a= new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Ventana con msg");
            a.showAndWait();
        });
        StackPane root = new StackPane();
        root.getChildren().add(b1);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}
