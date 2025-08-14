module com.example.jfxholamundo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.jfxholamundo1 to javafx.fxml;
    exports com.example.jfxholamundo1;
}