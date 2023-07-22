package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.producto_Concreto._UsuarioDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class InicioSesionController {

    @FXML
    private TextField txtUser,txtPswd;

    @FXML
    private Label txtError;


    private Gestor appGestor = new Gestor();

    @FXML
    protected void onBtnInicioSesion(ActionEvent event) throws IOException {


        if (txtUser.getText().equals(appGestor.getUsername(txtUser.getText()))){

            if (appGestor.getUsuarioIdByUser(txtUser.getText()) == 1){
                Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuCliente-view.fxml"));
                Scene newPageScene = new Scene(newPageParent);
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setScene(newPageScene);
                currentStage.show();
            } else if (appGestor.getUsuarioIdByUser(txtUser.getText()) == 2) {
                Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuVendedor-view.fxml"));
                Scene newPageScene = new Scene(newPageParent);
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.setScene(newPageScene);
                currentStage.show();
            }


        }else txtError.setText("Usuario o Contrasenna incorrecta!");

    }
}
