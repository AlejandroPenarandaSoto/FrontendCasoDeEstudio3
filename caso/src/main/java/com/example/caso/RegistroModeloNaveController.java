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

public class RegistroModeloNaveController {
    @FXML
    private TextField modeloField;
    private Gestor appGestor =new Gestor();

    @FXML
    protected void registrarModelo(ActionEvent event) throws IOException {
        String modelo = modeloField.getText();
        appGestor.registrarModelos(modelo);
        modeloField.clear();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroMarcaNave-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();

    }
}
