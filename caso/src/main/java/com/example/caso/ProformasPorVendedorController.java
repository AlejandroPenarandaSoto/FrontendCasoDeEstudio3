package com.example.caso;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.Gestores.Gestor;
import casoestudio.Gestores.GestorBuilder;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProformasPorVendedorController {

    @FXML
    private ComboBox<String> comboVendedores;
    private _UsuarioDAO usuarioDAO;



    private int selectedClienteId;


    private GestorBuilder gBuilder = new GestorBuilder();
    private Gestor appGestor = new Gestor();
    @FXML
    private TableView<Proforma> tablaP;


    @FXML
    private TableColumn<Proforma,Integer> proformaCol;
    @FXML
    private TableColumn<Proforma,Integer> clienteCol;
    @FXML
    private TableColumn<Proforma,Integer> estadoCol;
    @FXML
    private TableColumn<Proforma,Integer> vendedorCol;
    @FXML
    public void initialize() {
        usuarioDAO = new _UsuarioDAO();
        List<String> usuarios = usuarioDAO.getVendedores();
        comboVendedores.getItems().addAll(usuarios);
    }

    @FXML
    protected void verTabla(ActionEvent event) throws IOException {
        proformaCol.setCellValueFactory(new PropertyValueFactory<>("id_Proforma"));
        clienteCol.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<>("estado"));
        vendedorCol.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
        String selectedVendedor = comboVendedores.getValue();
        _UsuarioDAO udao = new _UsuarioDAO();
        int idUsuario = udao.getUsuariosId(selectedVendedor);
        List<Proforma> proformaList = udao.getProformasByUsuarioId(idUsuario);
        tablaP.setItems(FXCollections.observableArrayList(proformaList));
    }
    @FXML
    protected void backMenu(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }
    @FXML
    protected void detalles(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroDetallesProforma-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
