package com.example.demojavafx;

import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Matriz1Controller implements Initializable {
    private Stage scene;

    private BucleDeControlProperties matrizModel;
    //matriz medidas
    protected IntegerProperty mf = new SimpleIntegerProperty(0);
    protected IntegerProperty mc = new SimpleIntegerProperty(0);

    //@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /***
        //Matriz
        sliderFilasMatriz.valueProperty().bindBidirectional(mf);
        labelFilasMatriz.textProperty().bind(mf.asString());

        sliderColumnasMatriz.valueProperty().bindBidirectional(mc);
        labelColumnasMatriz.textProperty().bind(mc.asString());*/

    }


    protected void updateGUIwithModel() {
/***
        sliderColumnasMatriz.valueProperty().bindBidirectional(matrizModel.columnasProperty());
        sliderFilasMatriz.valueProperty().bindBidirectional(matrizModel.filasProperty());*/
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/

    public void loadUserData(BucleDeControlProperties parametrosBucleDeControl) {
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

    public void onButtonAction(int f, int c) {


    }
}
