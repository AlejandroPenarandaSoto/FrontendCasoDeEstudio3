module com.example.caso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    requires Caso3Back;


    opens com.example.caso to javafx.fxml;
    exports com.example.caso;
}