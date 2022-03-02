module com.example.fg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.fg to javafx.fxml;
    exports com.example.fg;
}