package com.example.caso;

import casoestudio.Gestores.Gestor;
import casoestudio.objetos.Proforma;
import casoestudio.producto_Concreto._UsuarioDAO;
import casoestudio.producto_Concreto._Usuarios;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaClientesPorProformaController implements Initializable {

    private Gestor appGestor = new Gestor();
    private _UsuarioDAO uDao = new _UsuarioDAO();
    @FXML
    private TableView<Proforma> tableCliente;

    @FXML
    private TableColumn<Proforma, String> IdProformaCol;
    @FXML
    private TableColumn<Proforma, String> IdClienteCol;
    @FXML
    private TableColumn<Proforma, String> nombreClienteCol;
    @FXML
    private TableColumn<Proforma, String> estadoProformaCol;
    @FXML
    private TableColumn<Proforma, String> IdVendedorCol;
    @FXML
    private TableColumn<Proforma, String> nombreVendedorCol;
    @FXML
    private TableColumn<Proforma, String> IdRepuestoCol;
    @FXML
    private TableColumn<Proforma, String> IdRechazoCol;


    @FXML
    private ComboBox<String> comboClientes;







    @FXML
    protected void verTabla(ActionEvent event) throws IOException {
        IdProformaCol.setCellValueFactory(new PropertyValueFactory<>("id_Proforma"));
        IdClienteCol.setCellValueFactory(new PropertyValueFactory<>("id_Cliente"));
        //nombreClienteCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        estadoProformaCol.setCellValueFactory(new PropertyValueFactory<>("estado"));
        IdVendedorCol.setCellValueFactory(new PropertyValueFactory<>("id_Vendedor"));
        // nombreVendedorCol.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        //IdRepuestoCol.setCellValueFactory(new PropertyValueFactory<>("id_repuesto"));
        //  IdRechazoCol.setCellValueFactory(new PropertyValueFactory<>("razon_rechazo_id"));

        String selectedVendedor = comboClientes.getValue();
        _UsuarioDAO udao = new _UsuarioDAO();
        int idUsuario = udao.getUsuariosId(selectedVendedor);
        List<Proforma> proformaList = udao.getProformasCliente(idUsuario);
        tableCliente.setItems(FXCollections.observableArrayList(proformaList));
        System.out.println("Proforma List: ");
        for (Proforma proforma : proformaList) {
            System.out.println(proforma);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> usuarios = uDao.getClientes();
        comboClientes.getItems().addAll(usuarios);

    }
}
