package com.example.demojavafx;

import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.individuos.Individuo;
import javafx.event.ActionEvent;
import javafx.event.Event;
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

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.net.URL;
import java.util.ResourceBundle;

public class PantallaFinalController implements Initializable {
    private Stage stage;

    private BucleDeControlProperties matrizModel;

    private static final Logger log = LogManager.getLogger(PantallaFinalController.class);


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


    public void loadUserData(BucleDeControlProperties parametrosBucleDeControl) {
        this.matrizModel = parametrosBucleDeControl;
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion, la cual se encarga de cargar datos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void setStage(Stage s) {
        this.stage = s;
    }

    public void guardarButton() {
        matrizModel.commit();
    }

    public void cerrarButton() {
        stage.close();
    }

    public void cancelarButton() {
        matrizModel.rollback();
    }


    public void abrirPantallaFinal() {
        Stage stage = new Stage();
        this.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantalla-final.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("¡El juego ha finalizado! ");
            stage.setScene(scene);


            VBox vbox = new VBox();

            for (int j = 0; j < matrizModel.getFilas(); j++) {
                for (int i = 0; i < matrizModel.getColumnas(); i++) {
                    for (int k = 0; k < matrizModel.original.matriz[j][i].getListaIndividuo().getNumeroElementos(); k++) {
                        Individuo ind = matrizModel.original.matriz[j][i].getListaIndividuo().getElemento(k).getData();
                        Label lab = new Label(ind.toString());
                        Button b = new Button("Ver árbol");
                        vbox.getChildren().addAll(lab, b);

                        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent e) {
                                DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(ind.getArbolGenealogico().raiz.getDato());
                                mostrarArboles(rootNode, ind.getArbolGenealogico());


                                JTree tree = new JTree(rootNode);

                                JScrollPane scrollPane = new JScrollPane(tree);

                                JFrame frame = new JFrame("Tree View Ind" + ind.getId());
                                frame.add(scrollPane);
                                frame.setSize(500, 300);
                                frame.setVisible(true);
                            }
                        };
                        b.setOnAction(event);

                    }
                }
            }

            Label l1 = new Label("¿Cuántas mutaciones ha habido?:" + matrizModel.original.numeroClonacionesTotales());
            Label l2 = new Label("¿¿Cuántas reproducciones ha habido?:" + matrizModel.original.numeroReproduccionesTotales());
            Label l3 = new Label("¿Qué individuo ha tenido más reproducciones?: " + matrizModel.original.individuoMaximoReproducciones());
            Label l4 = new Label("¿Qué individuo ha tenido más mutaciones?: " + matrizModel.original.individuoMaximoClonaciones());
            Label l5 = new Label("¿Qué individuo ha bebido más agua?: " + matrizModel.original.individuoMaximoAgua());
            Label l6 = new Label("¿Qué individuo ha conseguido llegar a un momento de máximo tiempo de vida disponible?: " + matrizModel.original.individuoMaximoVidaDisponible());
            Label l9 = new Label("¿Cuál es el individuo más longevo?: " + matrizModel.original.individuoLongevo());
            Label l10 = new Label("Cuál es la cola de operaciones del individuo más longevo?: "+matrizModel.original.individuoLongevo().getColaOperaciones());
            Label l7 = new Label("¿Cuánto ha sido?: " + matrizModel.original.cantidadIndividuoMaximoVidaDisponible());
            boolean bool =  matrizModel.original.individuoMaximoVidaDisponible().equals(matrizModel.original.individuoLongevo());
            Label l8 = new Label("¿Coincide con el más longevo?: " + bool);



            VBox vertical = new VBox(l1,l2,l3,l4,l5,l6,l9,l10,l7,l8);
            ScrollPane sc = new ScrollPane(vertical);
            ScrollPane scroll = new ScrollPane(vbox);
            SplitPane split = new SplitPane(scroll,sc);

            split.setOrientation(Orientation.VERTICAL);
            Scene scene1 = new Scene(split, 800, 600);

            stage.setScene(scene1);


            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarArboles(DefaultMutableTreeNode d, ArbolBinarioDeBusqueda<Individuo> ind) {


        if (ind.raiz.getDerecha() != null) {
            DefaultMutableTreeNode child1 = new DefaultMutableTreeNode(ind.raiz.getDerecha().getDato());
            d.add(child1);
            mostrarArboles(child1, ind.getSubArbolDcha());
        }
        if (ind.raiz.getIzquierda() != null) {
            DefaultMutableTreeNode child2 = new DefaultMutableTreeNode(ind.raiz.getIzquierda().getDato());
            d.add(child2);
            mostrarArboles(child2, ind.getSubArbolIzq());
        }

    }

}

