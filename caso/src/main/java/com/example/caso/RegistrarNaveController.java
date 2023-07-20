package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.constructores.ConstructorConcreto;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class RegistrarNaveController {
    @FXML
    private ComboBox<String> nombreCombo;
    @FXML
    private ComboBox<String> catCombo;
    private _UsuarioDAO usuarioDAO;
    private CategoriaDAO catDAO;
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
        usuarioDAO = new _UsuarioDAO();
        catDAO= new CategoriaDAO();
        List<String> usuarios = usuarioDAO.getUsuarios();
        nombreCombo.getItems().addAll(usuarios);
        List<String> categorias = catDAO.getCategorias();
        catCombo.getItems().addAll(categorias);




    }
}
