package com.example.caso;

import casoestudio.objetos.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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
    private TableColumn<?, ?> anioCol;

    @FXML
    private TableColumn<?, ?> categoriaCol;

    @FXML
    private TableColumn<?, ?> descCol;

    @FXML
    private TextField estadoField;

    @FXML
    private TableColumn<?, ?> idCol;

    @FXML
    private Button ingDetalle;

    @FXML
    private Button ingDetalle1;

    @FXML
    private Button ingDetalle2;


    @FXML
    private TableView<?> tablaInventarioVendedor;

    @FXML
    private TableColumn<?, ?> tipoCol;
    private ProformaDetalleDAO detalleDAO;
    private RechazoDAO rechazoDAO;

    private RepuestoDAO repuestoDAO;


    @FXML
    void click(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        detalleDAO = new ProformaDetalleDAO();
        rechazoDAO = new RechazoDAO();
        repuestoDAO = new RepuestoDAO();

        List<Rechazo> razonesRechazo = rechazoDAO.getRazonesRechazo();
        for (Rechazo razon : razonesRechazo) {
            CmboRechz.getItems().add(String.valueOf(razon.getDescripcion()));
        }


        List<Repuesto> repuestos = repuestoDAO.getRepuesto();
        for (Repuesto repuesto : repuestos) {
            CmboRep.getItems().add(String.valueOf(repuesto.getNombre()));
        }
        List<DetalleProforma> proforma = detalleDAO.getDetallesProf();
        for (DetalleProforma proformas : proforma) {
            CmboProf.getItems().add(String.valueOf(proformas.getId_detalle()));
        }



        CmboProf.setOnAction(e -> slctProf = Integer.parseInt(CmboProf.getValue()));
        CmboRechz.setOnAction(e -> slctRechz = String.valueOf(CmboRechz.getValue()));
        CmboRep.setOnAction(e -> slctRep = String.valueOf(CmboRep.getValue()));
    }
}
