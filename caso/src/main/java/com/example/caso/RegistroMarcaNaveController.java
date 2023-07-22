package com.example.caso;

import casoestudio.Gestores.Gestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RegistroMarcaNaveController {
    @FXML
    private TextField marcaField;
    private Gestor appGestor =new Gestor();

    @FXML
    protected void registrarMarca(ActionEvent event) throws IOException {
        String marca = marcaField.getText();
        appGestor.registrarMarcas(marca);
        marcaField.clear();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroAnioNave-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }
    @FXML
    protected void backMenu(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuCliente-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }
}
