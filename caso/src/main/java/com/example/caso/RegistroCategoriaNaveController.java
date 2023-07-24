package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.CategoriaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class RegistroCategoriaNaveController {
    @FXML
    private TextField categoriaField;
    private Gestor appGestor =new Gestor();

    @FXML
    protected void registrarCategoria(ActionEvent event) throws IOException {
        String nombre = categoriaField.getText();
        appGestor.registrarCategorias(nombre);
        categoriaField.clear();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroModeloNave-view.fxml"));
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
