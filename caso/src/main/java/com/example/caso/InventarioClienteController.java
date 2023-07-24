package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.Nave;
import casoestudio.objetos.NaveDAO;
import casoestudio.producto_Concreto._UsuarioDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class InventarioClienteController {





    @FXML
    private TableView<Nave> tablaInventarioCliente;
    @FXML
    private TableColumn<Nave,Integer> codCol;
    @FXML
    private TableColumn<Nave,String> ColorCol;

    @FXML
    private TableColumn<Nave,Integer> cateCol;
    @FXML
    private TableColumn<Nave,Integer> MarcaMCol;
    @FXML
    private TableColumn<Nave,Integer> UserCol1;
    private String userName;
    @FXML
    public Label clientID;


    public String getUserName() {
        return userName;
    }

    Gestor appGestor = new Gestor();
    _UsuarioDAO usuarioDAO = new _UsuarioDAO();

    public void initialize() {


        userName = UsuarioGlobal.getNombreUsuario();
        System.out.println("Nombre de usuario: " + userName);

        codCol.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        ColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));
        cateCol.setCellValueFactory(new PropertyValueFactory<>("idCat"));
        MarcaMCol.setCellValueFactory(new PropertyValueFactory<>("marcaM"));
        UserCol1.setCellValueFactory(new PropertyValueFactory<>("idU"));
        NaveDAO naveDAO = new NaveDAO();
        List<Nave> naveList = naveDAO.getNaveUser(usuarioDAO.getUsuarioId(userName));
        tablaInventarioCliente.setItems(FXCollections.observableArrayList(naveList));


    }


    @FXML
    protected void onPressbtnMenuCliente1(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuCliente-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }



}
