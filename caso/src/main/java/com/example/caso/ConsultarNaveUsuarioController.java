package com.example.caso;

import casoestudio.Composite.Componente;
import casoestudio.Composite.GrupoComponente;
import casoestudio.Gestores.Gestor;
import casoestudio.objetos.Categoria;
import casoestudio.objetos.Nave;
import casoestudio.objetos.Repuesto;
import casoestudio.producto_Concreto._Usuarios;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConsultarNaveUsuarioController {


    @FXML
    private TextField txtUser;
    @FXML
    private TableView<GrupoComponente> tablaINaveUsuario;
    @FXML
    private TableColumn<GrupoComponente,String> UsuarioCol;
    @FXML
    private TableColumn<GrupoComponente, Nave> NaveCol;
    @FXML
    private TableColumn<GrupoComponente,String> CategoriaCol;

    @FXML
    private TextArea textResul;
    Gestor appGestor = new Gestor();

    private List<GrupoComponente> grupos = new ArrayList<>();
    @FXML
    protected void onBtnConsultar(ActionEvent event) throws IOException {
        String naver = txtUser.getText();

        Nave naveObtenida = appGestor.ObtenerNave(naver);
        _Usuarios usuariosObtenido = appGestor.ObtenerUsuario( String.valueOf(naveObtenida.getIdU()));
        Categoria categoriaObtenida = appGestor.ObtenerCategoria(String.valueOf(naveObtenida.getIdCat()));
        Componente nave = new Nave(naveObtenida.getCodigo(), naveObtenida.getColor(), naveObtenida.getIdCat(),
                naveObtenida.getMarcaM(), naveObtenida.getIdU());
        Componente usuario = new _Usuarios(usuariosObtenido.getNombre(), usuariosObtenido.getApellido1(), usuariosObtenido.getApellido2(), usuariosObtenido.getTelefono(), usuariosObtenido.getRol_id());
        Componente categoria1 = new Categoria(categoriaObtenida.getCategoria());

        GrupoComponente grupo = new GrupoComponente();
        grupo.agregar(nave);
        grupo.agregar(usuario);
        grupo.agregar(categoria1);
        System.out.println(grupo.getDescripcion());
        textResul.setText(grupo.getDescripcion());


    }


    @FXML
    protected void onBtnMenu(ActionEvent event) throws IOException {
        Parent newPageParent = FXMLLoader.load(getClass().getResource("MenuVendedor-view.fxml"));
        Scene newPageScene = new Scene(newPageParent);
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(newPageScene);
        currentStage.show();
    }


}
