package com.example.demojavafx;

import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.*;
import com.example.demojavafx.recursos.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Matriz1Controller implements Initializable {

    private static final Logger log = LogManager.getLogger(Matriz1Controller.class);


    private Stage scene;

    private BucleDeControlProperties matrizModel;
    protected RecursosProperties recursosModel;
    protected AguaProperties aguaModel;
    protected BibliotecaProperties bibliotecaModel;
    protected ComidaProperties comidaModel;
    protected MontanaProperties montanaModel;
    protected PozoProperties pozoModel;
    protected TesoroProperties tesoroModel;

    protected IndividuoProperties individuoModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    protected void updateGUIwithModel() {

    }


    public void loadUserData(RecursosProperties parametrosRecursos, AguaProperties parametrosAgua,
                             BibliotecaProperties parametrosBiblioteca, ComidaProperties parametrosComida,
                             MontanaProperties parametrosMontana, PozoProperties parametrosPozo,
                             TesoroProperties parametrosTesoro, IndividuoProperties parametrosInd,
                             BucleDeControlProperties parametroMatriz) {
        this.recursosModel = parametrosRecursos;
        this.aguaModel = parametrosAgua;
        this.bibliotecaModel = parametrosBiblioteca;
        this.comidaModel = parametrosComida;
        this.montanaModel = parametrosMontana;
        this.pozoModel = parametrosPozo;
        this.tesoroModel = parametrosTesoro;
        this.individuoModel = parametrosInd;
        this.matrizModel = parametroMatriz;

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


    public void onButtonAction(int c, int f, RecursosController rec) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("md-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 300, 300);
            stage.setTitle("Modificar celda {fila: " + f + " columna: " + c + "}");
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
                    MenuItem selectedItem = (MenuItem) e.getSource();
                    String selectedValue = selectedItem.getText();
                    label.setText(selectedValue);
                }
            };
            item1.setOnAction(event);
            item2.setOnAction(event);
            item3.setOnAction(event);
            Label decor = new Label("--");
            Button button = new Button("Añadir Individuo");
            VBox rootInd = new VBox(menuButtonInd, label, decor, button);
            rootInd.setAlignment(Pos.CENTER);

            MenuButton menuButtonRec = new MenuButton("TipoRec");

            MenuItem itemr1 = new MenuItem("Agua");
            MenuItem itemr2 = new MenuItem("Comida");
            MenuItem itemr3 = new MenuItem("Biblioteca");
            MenuItem itemr4 = new MenuItem("Montaña");
            MenuItem itemr5 = new MenuItem("Pozo");
            MenuItem itemr6 = new MenuItem("Tesoro");

            menuButtonRec.getItems().addAll(itemr1, itemr2, itemr3, itemr4, itemr5, itemr6);

            // Crear un Label para mostrar el valor seleccionado
            Label labelRec = new Label("Valor seleccionado:  ");

            // Manejar el evento de selección del MenuButton
            EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    MenuItem selectedItem = (MenuItem) e.getSource();
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
            VBox rootRec = new VBox(menuButtonRec, labelRec, decor, buttonR);

            rootRec.setAlignment(Pos.CENTER);

            EventHandler<ActionEvent> eventButtonRec = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    if (labelRec.getText() == "Agua") {

                        Agua agua = aguaModel.getOriginalAgua();
                        agua.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        agua.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(agua);
                            agua.setPosN(f);
                            agua.setPosM(c);
                            agua.setProbAgua(aguaModel.probAguaProperty().get());


                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if (labelRec.getText() == "Biblioteca") {

                        Biblioteca biblioteca = bibliotecaModel.getOriginal();
                        biblioteca.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        biblioteca.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(biblioteca);
                            biblioteca.setPosN(f);
                            biblioteca.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if (labelRec.getText() == "Comida") {

                        Comida comida = comidaModel.getOriginal();
                        comida.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        comida.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(comida);
                            comida.setPosN(f);
                            comida.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if (labelRec.getText() == "Montaña") {

                        Montana montana = montanaModel.getOriginal();
                        montana.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        montana.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(montana);
                            montana.setPosN(f);
                            montana.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if (labelRec.getText() == "Pozo") {

                        Pozo pozo = pozoModel.getOriginal();
                        pozo.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        pozo.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(pozo);
                            pozo.setPosN(f);
                            pozo.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if (labelRec.getText() == "Tesoro") {

                        Tesoro tesoro = tesoroModel.getOriginal();
                        tesoro.setTurnosRestantes(recursosModel.getOriginal().getTurnosRestantes());
                        tesoro.setProbNuevoRecurso(recursosModel.getOriginal().getProbNuevoRecurso());
                        try {
                            matrizModel.matriz[f][c].addRecurso(tesoro);
                            tesoro.setPosN(f);
                            tesoro.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                }
            };
            buttonR.setOnAction(eventButtonRec);

            EventHandler<ActionEvent> eventButtonInd = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    Individuo aux = individuoModel.getOriginal();
                    if (label.getText() == "Básico") {

                        Random rand = new Random();
                        IndBasico ind = new IndBasico(rand.nextInt(900));
                        ind.setTurnosRestantes(aux.getTurnosRestantes());
                        ind.setProbClonacion(aux.getProbClonacion());
                        ind.setProbMuerte(aux.getProbMuerte());
                        ind.setProbReproduccion(aux.getProbReproduccion());
                        ind.setGeneracion(matrizModel.original.turno);
//                        ind.setId(rand.nextInt(900));
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText() == "Normal") {
                        Random rand = new Random();
                        IndNormal ind = new IndNormal(rand.nextInt(900));
                        ind.setTurnosRestantes(aux.getTurnosRestantes());
                        ind.setProbClonacion(aux.getProbClonacion());
                        ind.setProbMuerte(aux.getProbMuerte());
                        ind.setProbReproduccion(aux.getProbReproduccion());
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText() == "Avanzado") {
                        Random rand = new Random();
                        IndAvanzado ind = new IndAvanzado(rand.nextInt(900));
                        ind.setTurnosRestantes(aux.getTurnosRestantes());
                        ind.setProbClonacion(aux.getProbClonacion());
                        ind.setProbMuerte(aux.getProbMuerte());
                        ind.setProbReproduccion(aux.getProbReproduccion());
                        try {
                            matrizModel.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                }
            };

            button.setOnAction(eventButtonInd);

            SplitPane splitPane = new SplitPane(rootInd, rootRec);
            splitPane.setMinHeight(250);
            splitPane.setOrientation(Orientation.VERTICAL);

            Button button1 = new Button("Guardar");
            EventHandler eventButtonGuardar = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    matrizModel.commit();
                    rec.loadUserData(rec.getRecursosModel(), rec.getAguaModel(), rec.getBibliotecaModel(), rec.getComidaModel(), rec.getMontanaModel(), rec.getPozoModel(), rec.getTesoroModel(), rec.getIndividuoModel(), matrizModel);
                    rec.actualizarButton(f, c);
                    stage.close();
                }
            };
            button1.setOnAction(eventButtonGuardar);
            VBox vbox = new VBox(splitPane, button1);
            vbox.setAlignment(Pos.CENTER);

            Scene scene2 = new Scene(vbox, 200, 300);

            stage.setScene(scene2);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
