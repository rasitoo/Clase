package com.example.jfxholamundo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Has pulsado el botón!");
    }
    @FXML
    protected void onHelloButtonClick2() {
        welcomeText.setText("Has pulsado el botón 2!");
    }
}