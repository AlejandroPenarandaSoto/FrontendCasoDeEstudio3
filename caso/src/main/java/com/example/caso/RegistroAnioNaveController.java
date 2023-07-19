package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.Marca;
import casoestudio.objetos.MarcaDAO;
import casoestudio.objetos.Modelo;
import casoestudio.objetos.ModeloDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroAnioNaveController implements Initializable {

    @FXML
    private TextField anioField;
    private Gestor appGestor = new Gestor();

    @FXML
    private ComboBox<String> marcaComboBox;
    private int selectedMarcaId;

    @FXML
    private ComboBox<String> modeloComboBox;
    private int selectedModeloId;

    private MarcaDAO marcaDAO;
    private ModeloDAO modeloDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        marcaDAO = new MarcaDAO();
        modeloDAO = new ModeloDAO();

        List<String> marcas = marcaDAO.getMarcas();
        marcaComboBox.getItems().addAll(marcas);
        List<String> modelos = modeloDAO.getModelos();
        modeloComboBox.getItems().addAll(modelos);


        marcaComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedMarcaId = marcaDAO.getMarcaId(newValue);
            }
        });


        modeloComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedModeloId = modeloDAO.getModeloId(newValue);
            }
        });
    }

    @FXML
    protected void registrarAnio(ActionEvent event) throws IOException {
        int anio = Integer.parseInt(anioField.getText());
        appGestor.registrarAnios(anio, selectedMarcaId, selectedModeloId);

        anioField.clear();
        marcaComboBox.getSelectionModel().clearSelection();
        modeloComboBox.getSelectionModel().clearSelection();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroNave-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
