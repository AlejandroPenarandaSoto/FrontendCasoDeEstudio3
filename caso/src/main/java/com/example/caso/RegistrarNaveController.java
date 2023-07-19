package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.constructores.ConstructorConcreto;
import casoestudio.objetos.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class RegistrarNaveController {

    @FXML
    private TableView <MarcaModelo>  tablaMM;
    @FXML
    private TableColumn<MarcaModelo,Integer> marcamodCol;
    @FXML
    private TableColumn<MarcaModelo,Integer> marcaCol;
    @FXML
    private TableColumn<MarcaModelo,Integer> modeloCol;

    @FXML
    private TableColumn<MarcaModelo,Integer> anioCol;
    public void initialize() {
        marcamodCol.setCellValueFactory(new PropertyValueFactory<>("id_marcaM"));
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marcaId"));
        modeloCol.setCellValueFactory(new PropertyValueFactory<>("modeloId"));
        anioCol.setCellValueFactory(new PropertyValueFactory<>("anio"));


        MarcaModeloDAO marcaModeloDAO = new MarcaModeloDAO();
        List<MarcaModelo> marcaModeloList = marcaModeloDAO.getMarcaModeloData();
        tablaMM.setItems(FXCollections.observableArrayList(marcaModeloList));




    }
}
