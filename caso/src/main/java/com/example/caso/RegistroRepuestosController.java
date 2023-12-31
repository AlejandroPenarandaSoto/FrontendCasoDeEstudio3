package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroRepuestosController {
//
    @FXML
    private ChoiceBox<String> tiporId;
    private int tipoSelecionadoID;
    @FXML
    private TextField nomId;
    @FXML
    private TextField descId;
    @FXML
    private TextField anioId;

    @FXML
    private TextField categId;

    @FXML
    private ChoiceBox<String> MarcaId;
    private int idMarcaRe;
    @FXML
    private TextField preciId;
    @FXML
    private TextField cantId;

    Gestor appGestor = new Gestor();

    public void initialize() {

        MarcaRepuestoDAO marcaRepuestoDAO = new MarcaRepuestoDAO();
        TipoRepuestoDAO tipoRepuestoDAO = new TipoRepuestoDAO();

        List<String> marcaR = appGestor.listarMarcaRepuesto();
        MarcaId.getItems().addAll(marcaR);
        List<String>tipoR = appGestor.listarTipoRepuesto();
        tiporId.getItems().addAll(tipoR);

        MarcaId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                idMarcaRe = appGestor.marcaRepuestoID(newValue);
            }
        });
        tiporId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                tipoSelecionadoID = appGestor.tipoRepuestoID(newValue);
            }
        });
    }
    @FXML
    protected void registrarRepuesto(ActionEvent event) throws IOException {
        String nombre = nomId.getText();
        String descripcion = descId.getText();
        String categoria = categId.getText();
        int annio = Integer.parseInt(anioId.getText());
        int cantidad = Integer.parseInt(cantId.getText());
        int precio = Integer.parseInt(preciId.getText());
        appGestor.registrarRepuesto(tipoSelecionadoID,nombre,descripcion,categoria,precio, idMarcaRe,annio,cantidad);
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroRepuestos-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();


        initialize();



    }

    @FXML
    protected void regresarMenu(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();

    }

    @FXML
    protected void registrarMarcaTipo(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroMarcaRepuesto-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
