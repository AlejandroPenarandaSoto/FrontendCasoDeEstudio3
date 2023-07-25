package com.example.caso;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    protected void onBtnIniciarSesion(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("InicioSesion-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

    @FXML
    protected void onBtnRegistrar(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
