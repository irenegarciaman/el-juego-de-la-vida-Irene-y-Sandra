package com.example.demojavafx;

import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Matriz1Controller implements Initializable {


    private Stage scene;

    private BucleDeControlProperties matrizModel;





    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    protected void updateGUIwithModel() {

    }



    public void loadUserData(BucleDeControlProperties parametrosBucleDeControl,CeldaProperties celdaProp) {
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




    public void onButtonAction(int f, int c,RecursosController rec) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("md-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 300, 300);
            stage.setTitle("Modificar celda {fila: " + f +" columna: "+ c+"}");
            ModCeldaController p = fxmlLoader.getController();
            p.loadUserData(this.matrizModel);


            MenuButton menuButtonInd = new MenuButton("TipoInd");

            MenuItem item1 = new MenuItem("Básico");
            MenuItem item2 = new MenuItem("Normal");
            MenuItem item3 = new MenuItem("Avanzado");

            menuButtonInd.getItems().addAll(item1, item2, item3);

            // Crear un Label para mostrar el valor seleccionado
            Label label = new Label("Valor seleccionado: ");

            // Manejar el evento de selección del MenuButton
            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    MenuItem selectedItem = (MenuItem)e.getSource();
                    String selectedValue = selectedItem.getText();
                    label.setText(selectedValue);
                }
            };
            item1.setOnAction(event);
            item2.setOnAction(event);
            item3.setOnAction(event);
            Label decor = new Label("--");
            Button button = new Button("Añadir Individuo");
            VBox rootInd = new VBox(menuButtonInd, label,decor,button);
            rootInd.setAlignment(Pos.CENTER);

            MenuButton menuButtonRec = new MenuButton("TipoRec");

            MenuItem itemr1 = new MenuItem("Agua");
            MenuItem itemr2 = new MenuItem("Comida");
            MenuItem itemr3 = new MenuItem("Biblioteca");
            MenuItem itemr4 = new MenuItem("Montaña");
            MenuItem itemr5 = new MenuItem("Pozo");
            MenuItem itemr6 = new MenuItem("Tesoro");

            menuButtonRec.getItems().addAll(itemr1, itemr2, itemr3,itemr4,itemr5,itemr6);

            // Crear un Label para mostrar el valor seleccionado
            Label labelRec = new Label("Valor seleccionado:  ");

            // Manejar el evento de selección del MenuButton
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    MenuItem selectedItem = (MenuItem)e.getSource();
                    String selectedValue = selectedItem.getText();
                    labelRec.setText(selectedValue);
                }
            };
            itemr1.setOnAction(event2);
            itemr2.setOnAction(event2);
            itemr3.setOnAction(event2);
            itemr4.setOnAction(event2);
            itemr5.setOnAction(event2);
            itemr6.setOnAction(event2);

            Button buttonR = new Button("Añadir Recurso");
            VBox rootRec = new VBox(menuButtonRec, labelRec,decor,buttonR);

            rootRec.setAlignment(Pos.CENTER);

            EventHandler<ActionEvent> eventButtonRec = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if(labelRec.getText()=="Agua"){
                        System.out.println("if");
                        Agua agua = new Agua();
                        try {
                            matrizModel.matriz[f][c].addRecurso(agua);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Biblioteca"){

                        Biblioteca biblioteca = new Biblioteca();
                        try {
                            System.out.println(matrizModel.original.matriz[f][c].getListaRecurso().getNumeroElementos());
                            matrizModel.matriz[f][c].addRecurso(biblioteca);
                            System.out.println(matrizModel.original.matriz[f][c].getListaRecurso().getNumeroElementos());


                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Comida"){

                        Comida comida = new Comida();
                        try {
                            matrizModel.matriz[f][c].addRecurso(comida);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Montaña"){

                        Montana montana = new Montana();
                        try {
                            matrizModel.matriz[f][c].addRecurso(montana);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Pozo"){

                        Pozo pozo = new Pozo();
                        try {
                            matrizModel.matriz[f][c].addRecurso(pozo);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Tesoro"){

                        Tesoro tesoro = new Tesoro();
                        try {
                            matrizModel.matriz[f][c].addRecurso(tesoro);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                }
            };
            buttonR.setOnAction(eventButtonRec);

            EventHandler<ActionEvent> eventButtonInd = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (label.getText()=="Básico") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndBasico ind = new IndBasico(rand.nextInt(900));
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText()=="Normal") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndNormal ind = new IndNormal(rand.nextInt(900));
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText()=="Avanzado") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndAvanzado ind = new IndAvanzado(rand.nextInt(900));
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                }
            };

            button.setOnAction(eventButtonInd);

            SplitPane splitPane = new SplitPane(rootInd,rootRec);
            splitPane.setMinHeight(250);
            splitPane.setOrientation(Orientation.VERTICAL);

            Button button1 = new Button("Guardar");
            EventHandler eventButtonGuardar = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    matrizModel.commit();
                    rec.loadUserData(rec.getRecursosModel(),rec.getAguaModel(),rec.getBibliotecaModel(),rec.getComidaModel(),rec.getMontanaModel(),rec.getPozoModel(),rec.getTesoroModel(),rec.getIndividuoModel(),matrizModel);
                    rec.actualizarButton(f,c);
                    stage.close();
                }
            };
            button1.setOnAction(eventButtonGuardar);
            VBox vbox = new VBox(splitPane,button1);
            vbox.setAlignment(Pos.CENTER);

            Scene scene2 = new Scene(vbox, 200, 300);

            stage.setScene(scene2);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
