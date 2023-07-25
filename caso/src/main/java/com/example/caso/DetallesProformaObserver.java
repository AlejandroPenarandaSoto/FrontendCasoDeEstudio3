package com.example.caso;

import casoestudio.IObservador.ObservadorProforma;
import casoestudio.objetos.DetalleProforma;
import casoestudio.objetos.Proforma;
import casoestudio.producto_Concreto._Usuarios;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
public class DetallesProformaObserver implements ObservadorProforma {



    @Override
    public void notificarNuevosDetalles(Proforma proforma, DetalleProforma detalleProforma) {
        System.out.println("Se ha agregado un nuevo detalle a la proforma: " + detalleProforma.toString());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Nuevo Detalle de Proforma");
        alert.setHeaderText("Se ha agregado un nuevo detalle a la proforma #" + proforma.getId_Proforma());
        alert.setContentText(detalleProforma.toString());
        alert.showAndWait();
    }
}
