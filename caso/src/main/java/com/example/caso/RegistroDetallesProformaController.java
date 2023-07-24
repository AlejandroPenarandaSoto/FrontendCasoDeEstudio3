package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.*;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class RegistroDetallesProformaController implements Initializable {

    @FXML
    private ComboBox<String> CmboProf;
    private int slctProf;

    @FXML
    private ComboBox<String> CmboRechz;
    private String slctRechz;

    @FXML
    private ComboBox<String> CmboRep;
    private  String slctRep;


    @FXML
    private TextField estadoField;
    @FXML
    private Button ingDetalle;

    @FXML
    private Button btnProformasV;

    @FXML
    private Button btnRechazo;



    private ProformaDetalleDAO detalleDAO;
    private ProformaDAO proforma;
    private RechazoDAO rechazoDAO;
    private RepuestoDAO repuestoDAO;


    private Gestor appGestor = new Gestor();


    @FXML
    protected void CLICK(ActionEvent event) throws IOException{
        Parent newPageParent = FXMLLoader.load(getClass().getResource("ListaProformasPorVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }


    @FXML
    protected void Click(ActionEvent event) throws IOException {
            Parent newPageParent = FXMLLoader.load(getClass().getResource("RegistroRechazos-view.fxml"));
            Scene newPageScene = new Scene(newPageParent);
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.setScene(newPageScene);
            currentStage.show();
    }
    @FXML
    private TableView<Repuesto> tablaInventarioVendedor;
    @FXML
    private TableColumn<Repuesto,Integer> tipoCol;
    @FXML
    private TableColumn<Repuesto,String> nombrerCol;
    @FXML
    private TableColumn<Repuesto,String> descCol;
    @FXML
    private TableColumn<Repuesto,String> categoriaCol;
    @FXML
    private TableColumn<Repuesto,Integer> precioCol;
    @FXML
    private TableColumn<Repuesto,Integer> marcaCol;
    @FXML
    private TableColumn<Repuesto,Integer> annioCol1;
    @FXML
    private TableColumn<Repuesto,Integer> cantidadCol2;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detalleDAO = new ProformaDetalleDAO();
        rechazoDAO = new RechazoDAO();
        repuestoDAO = new RepuestoDAO();
        proforma = new ProformaDAO();

        tipoCol.setCellValueFactory(new PropertyValueFactory<>("tipoR"));
        nombrerCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descCol.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        categoriaCol.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        precioCol.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marcaR"));
        annioCol1.setCellValueFactory(new PropertyValueFactory<>("Annio"));
        cantidadCol2.setCellValueFactory(new PropertyValueFactory<>("cantidad"));

        RepuestoDAO repuestoDAO = new RepuestoDAO();
        List<Repuesto> repuestoList = repuestoDAO.getRepuesto();
        tablaInventarioVendedor.setItems(FXCollections.observableArrayList(repuestoList));




        List<Rechazo> razonesRechazo = rechazoDAO.getRazonesRechazo();
        for (Rechazo razon : razonesRechazo) {
            CmboRechz.getItems().add(String.valueOf(razon.getDescripcion()));
        }


        List<Repuesto> repuestos = repuestoDAO.getRepuesto();
        for (Repuesto repuesto : repuestos) {
            CmboRep.getItems().add(String.valueOf(repuesto.getDescripcion()));
        }
        List<Proforma> proformas = proforma.getProformas() ;
        for (Proforma proforma : proformas) {
            CmboProf.getItems().add(String.valueOf(proforma.getId_Proforma()));
        }



        CmboProf.setOnAction(e -> slctProf = Integer.parseInt(CmboProf.getValue()));
        CmboRechz.setOnAction(e -> slctRechz = String.valueOf(CmboRechz.getValue()));
        CmboRep.setOnAction(e -> slctRep = String.valueOf(CmboRep.getValue()));


    }
    @FXML
    void click(ActionEvent event) {
        int proformaId = Integer.parseInt(CmboProf.getValue());
        int repuestoId = repuestoDAO.getRepuestoId(CmboRep.getValue());
        String estado = estadoField.getText();
        int rechazoId = rechazoDAO.getRechazoId(CmboRechz.getValue());

        appGestor.registrarDetalleProf(proformaId, repuestoId, estado, rechazoId);




    }

}
