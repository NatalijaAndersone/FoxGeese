module com.example.fg {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.fg to javafx.fxml;
    exports com.example.fg;
}