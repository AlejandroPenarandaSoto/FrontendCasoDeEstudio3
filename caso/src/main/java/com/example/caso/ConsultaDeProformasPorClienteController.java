package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.Gestores.GestorProxy;
import casoestudio.objetos.DetalleProforma;
import casoestudio.objetos.Proforma;
import casoestudio.objetos.ProformaDAO;
import casoestudio.objetos.ProformaDetalleDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ConsultaDeProformasPorClienteController {

    @FXML
    private TableView<Proforma> tblProformas;
    @FXML
    private TableColumn<Proforma, Integer> proformaCol;
    @FXML
    private TableColumn<Proforma, Integer> idClienteCol;
    @FXML
    private TableColumn<Proforma, Integer> idVendedorCol;
    @FXML
    private TableView<DetalleProforma> tblDetalleProforma;
    @FXML
    private TableColumn<DetalleProforma, Integer> idDetalleCol;
    @FXML
    private TableColumn<DetalleProforma, Integer> idProformaCol;
    @FXML
    private TableColumn<DetalleProforma, Integer> idRepuestoCol;
    @FXML
    private TableColumn<DetalleProforma, String> estadoCol;
    @FXML
    private TableColumn<DetalleProforma, Integer> idRazonRechazoCol;
    @FXML
    private TextField fldContrasenna;
    @FXML
    private TextField fldCliente;
    @FXML
    private TextField fldIdProforma;
    GestorProxy gestorProxy = new GestorProxy();
    Gestor appGestor = new Gestor();
    Proforma proforma = new Proforma();
    DetalleProforma detalleP = new DetalleProforma();
    private int contrasenna;
    private int idCliente;
    private int idProforma;

    @FXML
    protected void ingresarContrasenna(ActionEvent event) throws IOException {
        String contrasenna = fldContrasenna.getText();
        idCliente = gestorProxy.getClienteId(contrasenna);

        if (idCliente != 0){
            fldCliente.setText(String.valueOf(idCliente));
        } else {
            fldCliente.clear();
        }

        fldContrasenna.clear();
    }

    @FXML
    protected void ingresarIdCliente(ActionEvent event) throws IOException {
        idCliente = Integer.parseInt(fldCliente.getText());
        appGestor.getProformasByIdCliente(idCliente);
        fldContrasenna.clear();
        proformaCol.setCellValueFactory(new PropertyValueFactory<>("id_Proforma"));
        idClienteCol.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));
        idVendedorCol.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
        ProformaDAO proformaDAO = new ProformaDAO();
        List<Proforma> proformaList = proformaDAO.getProformasByIdCliente(idCliente);
        tblProformas.setItems(FXCollections.observableArrayList(proformaList));
    }

    @FXML
    protected void ingresarIdProforma(ActionEvent event) throws IOException {
        int idProforma = Integer.parseInt(fldIdProforma.getText());
        appGestor.getDetalleProformaByProformaId(idProforma);
        fldContrasenna.clear();
        idDetalleCol.setCellValueFactory(new PropertyValueFactory<>("id_detalle"));
        idProformaCol.setCellValueFactory(new PropertyValueFactory<>("id_proforma"));
        idRepuestoCol.setCellValueFactory(new PropertyValueFactory<>("id_repuesto"));
        estadoCol.setCellValueFactory(new PropertyValueFactory<>("estado"));
        idRazonRechazoCol.setCellValueFactory(new PropertyValueFactory<>("id_rechazo"));
        ProformaDetalleDAO proformaDetalleDAO = new ProformaDetalleDAO();
        List<DetalleProforma> detalleProformaList = proformaDetalleDAO.getDetallesfById(idProforma);
        tblDetalleProforma.setItems(FXCollections.observableArrayList(detalleProformaList));
    }

    @FXML
    protected void backMenu(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }

}
