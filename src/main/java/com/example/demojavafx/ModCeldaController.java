package com.example.demojavafx;

import com.example.demojavafx.recursos.Agua;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ModCeldaController implements Initializable {


    @FXML
    private MenuButton boxTipoRecuso;

    @FXML
    private MenuButton boxTipoInd;


    private Stage scene;

    private BucleDeControlProperties matrizModel;

    protected Celda[][] matriz;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Label labelRec = new Label();
            MenuItem selectedItem = (MenuItem) e.getSource();
            String selectedValue = selectedItem.getLabel();
            labelRec.setText("Valor seleccionado: " + selectedValue);
        }
    };


    protected void updateGUIwithModel() {
    }



    public void loadUserData(BucleDeControlProperties parametrosBucleDeControl) {
        this.matriz = parametrosBucleDeControl.matrizProperty();
        this.matrizModel = parametrosBucleDeControl;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s) {
        this.scene = s;
    }

    public void guardarButton() {

        matrizModel.commit();

    }

    public void cerrarButton() {
        scene.close();
    }

    public void cancelarButton() {

        matrizModel.rollback();
    }



}
