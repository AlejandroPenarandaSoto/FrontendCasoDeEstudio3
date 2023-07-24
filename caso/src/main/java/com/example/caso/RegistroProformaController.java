package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.ProformaDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroProformaController implements Initializable {

    private Gestor appGestor = new Gestor();

    @FXML
    private ComboBox<String> comboCliente;
    private int slctClienteId;

    @FXML
    private ComboBox<String> comboVendedor;
    private int slctVendedorId;

    private ProformaDAO proformaDAO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        proformaDAO = new ProformaDAO();

        List<String> clientes = proformaDAO.getClientes();
        comboCliente.getItems().addAll(clientes);

        List<String> vendedores = proformaDAO.getVendedores();
        comboVendedor.getItems().addAll(vendedores);

        comboCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                slctClienteId = proformaDAO.getClienteId(newValue);
            }
        });

        comboVendedor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                slctVendedorId = proformaDAO.getVendedorId(newValue);
            }
        });
    }

    @FXML
    protected void registrarProforma(ActionEvent event) throws IOException {
        String estado = "pendiente";
        appGestor.registrarProforma(estado, slctClienteId, slctVendedorId);

        comboCliente.getSelectionModel().clearSelection();
        comboVendedor.getSelectionModel().clearSelection();
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuCliente-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
