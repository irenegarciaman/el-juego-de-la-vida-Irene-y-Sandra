package com.example.demojavafx;

import com.example.demojavafx.matriz.ParameterDataModelMatriz;
import com.example.demojavafx.matriz.ParameterDataModelMatrizProperties;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {


    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/

    @FXML
    private Slider sliderColumnas;
    @FXML
    private Slider sliderFilas;
    @FXML
    private Label labelColumnas;
    @FXML
    private Label labelFilas;

    protected IntegerProperty medida = new SimpleIntegerProperty(0);
    protected IntegerProperty medida1 = new SimpleIntegerProperty(1);



    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    private ParameterDataModelMatrizProperties model;
    private Stage scene;


    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */


    @FXML
    protected void onBotonGuardarClick() {
        model.commit();
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
    }

    @FXML protected void onBotonCerrarClick(){
        scene.close();
    }

    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");
        sliderColumnas.valueProperty().bindBidirectional(medida);
        labelColumnas.textProperty().bind(medida.asString());
        sliderFilas.valueProperty().bindBidirectional(medida1);
        labelFilas.textProperty().bind(medida1.asString());
        if (model != null) {
            this.updateGUIwithModel();
        }
    }

    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        sliderColumnas.valueProperty().bindBidirectional(model.columnasProperty());
        sliderFilas.valueProperty().bindBidirectional(model.filasProperty());
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(ParameterDataModelMatrizProperties parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }

    public void setStage(Stage s){
        this.scene = s;
    }

}