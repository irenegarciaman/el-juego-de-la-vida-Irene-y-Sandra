package com.example.demojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoCeldaController implements Initializable {

    private Stage scene;

    private BucleDeControlProperties matrizModel;

    protected Celda[][] matriz;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


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
    public void cerrarButton(){
        scene.close();
    }
    public void cancelarButton(){

        matrizModel.rollback();
    }
}
