module com.example.caso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.caso to javafx.fxml;
    exports com.example.caso;
}