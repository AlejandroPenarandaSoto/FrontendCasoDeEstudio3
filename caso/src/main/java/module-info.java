module com.example.caso {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.net.http;
    //requires Caso3Back;
    requires BackendCasoDeEstudio3;
    requires com.google.gson;
    //requires Backend;


    opens com.example.caso to javafx.fxml;
    exports com.example.caso;
}