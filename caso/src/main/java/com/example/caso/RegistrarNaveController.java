package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.Gestores.GestorBuilder;
import casoestudio.constructores.ConstructorConcreto;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;


import casoestudio.Gestores.Gestor;
import casoestudio.Gestores.GestorBuilder;
import casoestudio.constructores.ConstructorConcreto;
import casoestudio.objetos.*;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrarNaveController {
    @FXML
    private TextField codigoField;
    @FXML
    private TextField ColorField;
    @FXML
    private ComboBox<String> nombreCombo;
    @FXML
    private ComboBox<String> catCombo;
    @FXML
    private ComboBox<String> marcaModeloCombo;
    private _UsuarioDAO usuarioDAO;
    private MarcaModeloDAO mmDAO;
    private CategoriaDAO catDAO;
    private NaveDAO naveDao;
    private int selectedUserId;
    private int selectedCategoriaId;
    private GestorBuilder gBuilder = new GestorBuilder();
    private Gestor appGestor = new Gestor();
    @FXML
    private TableView <MarcaModelo>  tablaMM;
    @FXML
    private TableView <Nave>  tablaNaves;
    private int idMarcaModelo;
    @FXML
    private TableColumn<Nave,String> codigoCol;
    @FXML
    private TableColumn<Nave,String> colorCol;
    @FXML
    private TableColumn<Nave,Integer> catCol;
    @FXML
    private TableColumn<Nave,Integer> marcaMCol;
    @FXML
    private TableColumn<Nave,Integer> nombreCol;

    @FXML
    private TableColumn<MarcaModelo,Integer> marcamodCol;
    @FXML
    private TableColumn<MarcaModelo,Integer> marcaCol;
    @FXML
    private TableColumn<MarcaModelo,Integer> modeloCol;
    private int selectMM;

    @FXML
    private TableColumn<MarcaModelo,Integer> anioCol;
    public void initialize() {
        codigoCol.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        catCol.setCellValueFactory(new PropertyValueFactory<>("idCat"));
        marcaMCol.setCellValueFactory(new PropertyValueFactory<>("marcaM"));
        nombreCol.setCellValueFactory(new PropertyValueFactory<>("idU"));
        NaveDAO navdao = new NaveDAO();
        List<Nave> naveList = navdao.getNaveData();
        tablaNaves.setItems(FXCollections.observableArrayList(naveList));

        marcamodCol.setCellValueFactory(new PropertyValueFactory<>("id_marcaM"));
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marcaId"));
        modeloCol.setCellValueFactory(new PropertyValueFactory<>("modeloId"));
        anioCol.setCellValueFactory(new PropertyValueFactory<>("anio"));
        MarcaModeloDAO marcaModeloDAO = new MarcaModeloDAO();
        List<MarcaModelo> marcaModeloList = marcaModeloDAO.getMarcaModeloData();
        tablaMM.setItems(FXCollections.observableArrayList(marcaModeloList));
        usuarioDAO = new _UsuarioDAO();
        catDAO= new CategoriaDAO();
        naveDao = new NaveDAO();
        mmDAO = new MarcaModeloDAO();
        List<String> mms = mmDAO.getMMs();
        marcaModeloCombo.getItems().addAll(mms);
        List<String> usuarios = usuarioDAO.getUsuarios();
        nombreCombo.getItems().addAll(usuarios);
        List<String> categorias = catDAO.getCategorias();
        catCombo.getItems().addAll(categorias);
        marcaModeloCombo.setOnAction(e -> {
            String selectedValue = marcaModeloCombo.getSelectionModel().getSelectedItem();
            if (selectedValue != null) {
                String[] brandAndModel = selectedValue.split(" - ");
                if (brandAndModel.length == 2) {
                    String selectedBrand = brandAndModel[0].trim();
                    String selectedModel = brandAndModel[1].trim();

                    int idMarcaModelo = marcaModeloDAO.queryIdMarcaModelo(selectedBrand, selectedModel);

                    if (idMarcaModelo != -1) {
                        this.idMarcaModelo = idMarcaModelo;
                    }
                }
            }
        });
        nombreCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedUserId = usuarioDAO.getUsuariosId(newValue);

            }
        });
        catCombo.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                selectedCategoriaId = catDAO.getCatId(newValue);

            }
        });

    }

    @FXML
    protected void registrarNave(ActionEvent event) throws IOException {
        String codigo = codigoField.getText();
        String color = ColorField.getText();
        gBuilder.construccion_base(codigo, color, selectedCategoriaId, idMarcaModelo, selectedUserId);
        Nave nave = gBuilder.getNave();
        naveDao.registrarNave(nave);
        initialize();
    }




}
