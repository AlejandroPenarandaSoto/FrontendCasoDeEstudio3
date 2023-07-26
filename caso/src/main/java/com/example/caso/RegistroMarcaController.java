package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.Categoria;
import casoestudio.objetos.Marca;
import casoestudio.objetos.MarcaRepuesto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class RegistroMarcaController {

    @FXML
    private TextField MarcaField;
    @FXML
    private TextField TipoField;



    private Gestor appGestor =new Gestor();


    @FXML
    protected void registrarMarca(ActionEvent event) throws IOException {
        String marca = MarcaField.getText();
        appGestor.registrarMarcaR(marca);
        MarcaField.clear();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroMarcaRepuesto-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

    @FXML
    protected void registrarTipo(ActionEvent event) throws IOException {
        String tipo = TipoField.getText();
        appGestor.registrarTipoR(tipo);
        MarcaField.clear();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroMarcaRepuesto-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

    @FXML
    protected void Regresar(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroRepuestos-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }




}
