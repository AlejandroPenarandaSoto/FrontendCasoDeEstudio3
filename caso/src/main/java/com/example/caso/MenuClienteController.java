package com.example.caso;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuClienteController implements Initializable {

    @FXML
    private Button btnRegistrarNave,btnInvCliente,btnInvVendedor,btnCerrarSesion;

    @FXML
    private Text txtCliente;
    private String userName;


    @FXML
    protected void onPressbtnRegistroNave(ActionEvent event) throws IOException{
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroNave-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }


    @FXML
    protected void onPressbtnInventarioV(ActionEvent event) throws IOException{
        Parent newPageParent = FXMLLoader.load(getClass().getResource("InventarioVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }
    @FXML
    protected void onPressbtnInvCliente(ActionEvent event) throws IOException{

        Parent newPageParent = FXMLLoader.load(getClass().getResource("InventarioCliente-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();


    }

    @FXML
    protected void onPressbtnProforma(ActionEvent event) throws IOException{
        Parent newPageParent = FXMLLoader.load(getClass().getResource("ListaProformasPorVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

    @FXML
    protected void onPressbtnCerrarSesion(ActionEvent event) throws IOException{
        Parent newPageParent = FXMLLoader.load(getClass().getResource("InicioSesion-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
