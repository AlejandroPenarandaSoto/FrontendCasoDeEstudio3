package com.example.caso;

import casoestudio.objetos.*;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class InventarioVendedorController {





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


    public void initialize() {

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

    }


    @FXML
    protected void onPressbtnMenuCliente(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuCliente-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();

    }





}