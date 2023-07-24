package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.ProformaDAO;
import casoestudio.objetos.Rechazo;
import casoestudio.objetos.RechazoDAO;
import casoestudio.producto_Concreto.GestorPrueba;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroRechazosController{

    @FXML
    private TextField fldDescripcion;
    private Gestor appGestor = new Gestor();

    @FXML
    private TableView<Rechazo> tblRazonesRechazo;

    @FXML
    private TableColumn<Rechazo,Integer> idRechazoCol;
    @FXML
    private TableColumn<Rechazo,String> descripcionCol;

    private RechazoDAO rechazoDAO;


    public void initialize() {
        idRechazoCol.setCellValueFactory(new PropertyValueFactory<>("id_Rechazo"));
        descripcionCol.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        RechazoDAO rechDAO = new RechazoDAO();
        List<Rechazo> RazonesRechazoList = rechDAO.getRazonesRechazo();
        tblRazonesRechazo.setItems(FXCollections.observableArrayList(RazonesRechazoList));
    }

    @FXML
    protected void registrarRazonRechazo(ActionEvent event) throws IOException {
        String descripcion = fldDescripcion.getText();
        appGestor.registrarRazonRechazo(descripcion);
        fldDescripcion.clear();
    }

    @FXML
    protected void IrRegistroDetalles(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroDetallesProformaController-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }
}
