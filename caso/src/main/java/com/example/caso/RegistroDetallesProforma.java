package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.*;
import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class RegistroDetallesProforma implements Initializable {

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
    void CLICK(ActionEvent event) {

    }

    @FXML
    void Click(ActionEvent event) {

    }
    @FXML
    private TableView<Repuesto> tablaInventarioVendedor1;
    @FXML
    private TableColumn<Repuesto,Integer> tipoCol1;
    @FXML
    private TableColumn<Repuesto,String> nombrerCol1;
    @FXML
    private TableColumn<Repuesto,String> descCol1;
    @FXML
    private TableColumn<Repuesto,String> categoriaCol1;
    @FXML
    private TableColumn<Repuesto,Integer> precioCol1;
    @FXML
    private TableColumn<Repuesto,Integer> marcaCol1;
    @FXML
    private TableColumn<Repuesto,Integer> annioCol1;
    @FXML
    private TableColumn<Repuesto,Integer> cantidadCol2;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tipoCol1.setCellValueFactory(new PropertyValueFactory<>("tipoR"));
        nombrerCol1.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        descCol1.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        categoriaCol1.setCellValueFactory(new PropertyValueFactory<>("Categoria"));
        precioCol1.setCellValueFactory(new PropertyValueFactory<>("Precio"));
        marcaCol1.setCellValueFactory(new PropertyValueFactory<>("marcaR"));
        annioCol1.setCellValueFactory(new PropertyValueFactory<>("Annio"));
        cantidadCol2.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        RepuestoDAO repuestoDAO = new RepuestoDAO();
        List<Repuesto> repuestoList = repuestoDAO.getRepuesto();
        tablaInventarioVendedor1.setItems(FXCollections.observableArrayList(repuestoList));


        detalleDAO = new ProformaDetalleDAO();
        rechazoDAO = new RechazoDAO();
        repuestoDAO = new RepuestoDAO();
        proforma = new ProformaDAO();

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
        int detalleId = 0;

        // Crear el objeto DetalleProforma
        DetalleProforma detalleProforma = new DetalleProforma(proformaId, repuestoId, estado, rechazoId, detalleId);

        // Generar el JSON del objeto DetalleProforma usando la librería Gson
        Gson gson = new Gson();
        String jsonDetalleProforma = gson.toJson(detalleProforma);

        // Imprimir el JSON generado (opcional, para ver el resultado)
        System.out.println("JSON del DetalleProforma: " + jsonDetalleProforma);
    }
}
