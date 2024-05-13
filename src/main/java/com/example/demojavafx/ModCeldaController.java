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
        //boxTipoInd.textProperty().bind(ti);

        //boxTipoRecuso.textProperty().bind(tr);

        /***
         //Matriz
         sliderFilasMatriz.valueProperty().bindBidirectional(mf);
         labelFilasMatriz.textProperty().bind(mf.asString());

         sliderColumnasMatriz.valueProperty().bindBidirectional(mc);
         labelColumnasMatriz.textProperty().bind(mc.asString());*/

    }

    // Manejar el evento de selección del MenuButton
    EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            Label labelRec = new Label();
            MenuItem selectedItem = (MenuItem)e.getSource();
            String selectedValue = selectedItem.getLabel();
            labelRec.setText("Valor seleccionado: " + selectedValue);
        }
    };



    protected void updateGUIwithModel() {

/***
 sliderColumnasMatriz.valueProperty().bindBidirectional(matrizModel.columnasProperty());
 sliderFilasMatriz.valueProperty().bindBidirectional(matrizModel.filasProperty());*/
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/

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

    public void onButtonAction(int f, int c) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mod-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Modificar celda {fila: " + f +" columna: "+ c+"}");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
