package com.example.caso;

import casoestudio.Fabrica_Abstracta.Usuarios;
import casoestudio.Fabrica_Concreta.Fabrica_Usuario;
import casoestudio.Gestores.Gestor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarVendedorController implements Initializable {
    @FXML
    private Button btnRegsitrar;
    @FXML
    private TextField txtNombre, txtApellido1,txtApellido2,txtPswd,txtCel, txtUser;

    @FXML
    private ComboBox comboRol;

    private Gestor appGestor = new Gestor();
    private Usuarios miUser = new Fabrica_Usuario();

    @FXML
    protected  void registrarUser(ActionEvent event) throws IOException {

        String _nombre, _apellido1, _apellido2, _Pswd, _cel, _rolID, _User;

        _nombre = txtNombre.getText();
        _apellido1 = txtApellido1.getText();
        _apellido2 = txtApellido2.getText();
        _Pswd = txtPswd.getText();
        _User = txtUser.getText();
        _cel = txtCel.getText();
        _rolID = (String)comboRol.getSelectionModel().getSelectedItem();

        if (_rolID == "Cliente"){
            _rolID = "1";
        } else if (_rolID == "Vendedor") {
            _rolID = "2";

        }


        appGestor.registrarUsuario(miUser,_nombre,_apellido1,_apellido2,_cel, Integer.parseInt(_rolID),_User,_Pswd);

        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();

    }

    @FXML
    protected void listarRoles(){
        String roles[] = {"Cliente", "Vendedor"};
        for (String rol:roles){
            comboRol.getItems().addAll(rol);
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listarRoles();

    }
}