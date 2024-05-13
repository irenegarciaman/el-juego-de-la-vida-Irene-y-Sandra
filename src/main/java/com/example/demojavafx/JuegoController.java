package com.example.demojavafx;



import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.ScrollPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class JuegoController implements Initializable {


    private Stage scene;

    private BucleDeControlProperties matrizModel;

    protected Celda[][] matriz;

    protected ListaEnlazada<Button> listaButton;

    protected RecursosProperties recursosModel;
    protected AguaProperties aguaModel;
    protected BibliotecaProperties bibliotecaModel;
    protected ComidaProperties comidaModel;
    protected MontanaProperties montanaModel;
    protected PozoProperties pozoModel;
    protected TesoroProperties tesoroModel;
    //Individuos model
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setScene(scene);
            stage.setTitle("Ver celda {fila: " + f +" columna: "+ c+"}");
            String strRec = "";
            String strInd = "";
            for (int i = 0; i < matrizModel.original.getFila();i++){
                for (int j = 0; j < matrizModel.original.getColumna();j++){
                    for (int k=0;k<matrizModel.original.matriz[i][j].getListaIndividuo().getNumeroElementos();k++){
                        strInd += matrizModel.original.matriz[i][j].getListaIndividuo().getElemento(k).toString();
                    }
                    for (int k=0;k<matrizModel.original.matriz[i][j].getListaRecurso().getNumeroElementos();k++){
                        strRec += matrizModel.original.matriz[i][j].getListaRecurso().getElemento(k).toString();
                    }

                }
            }

            Label labelInd = new Label(strInd);
            Label labelRec = new Label(strRec);

            VBox vbox = new VBox(labelInd, labelRec);

            ScrollPane s = new ScrollPane(vbox);

            Scene scene2 = new Scene(s,100,100);


            stage.setScene(scene2);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void crearJuego(BucleDeControlProperties modeloMatriz){

        //Este es el llamado por el helloController
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego.fxml"));
        try {
            Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);
            int turno = modeloMatriz.original.turno;
            stage.setTitle("juego en turno: "+ turno);
            stage.setScene(scene1);

            JuegoController p = fxmlLoader.getController();
            p.loadUserData(recursosModel,aguaModel,bibliotecaModel,comidaModel,montanaModel,pozoModel,tesoroModel,individuoModel,matrizModel);


            int filas = modeloMatriz.getFilas();
            int columnas = modeloMatriz.getColumnas();


            GridPane mainGrid2 = new GridPane();
            ScrollPane scrollPane2 = new ScrollPane(mainGrid2);

            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    int numI = modeloMatriz.matriz[i][j].getListaIndividuo().getNumeroElementos();
                    int numR = modeloMatriz.matriz[i][j].getListaRecurso().getNumeroElementos();
                    String label = "nºInd: " + numI + "\n nºRec: " + numR;
                    Button b = new Button(label);
                    b.setId(i + "," + j);

                    int finalJ = j;
                    int finalI = i;

                    System.out.println("bucle");
                    EventHandler y = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            System.out.println("event");
                            p.onButtonInfo(finalI,finalJ,matrizModel);
                        }
                    };
                    b.setOnAction(y);




                    VBox placeholder = new VBox(b);

                    b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    placeholder.setMinSize(100, 100);
                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid2.add(placeholder, i, j);


                }
            }

            p.setStage(stage);
            stage.show();


            Scene scene2 = new Scene(scrollPane2, 600, 600);
            scene1 = scene2;
            stage.setScene(scene1);
            stage.show();
            //modeloMatriz.original.guardar();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void onButtonInfo(int f, int c,BucleDeControlProperties matrizModel) {
        //se llama desde recursos controller
        System.out.println("entra?");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-celda.fxml"));
        try {
            System.out.println("funcion");
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setScene(scene);
            stage.setTitle("Ver celda {fila: " + f +" columna: "+ c+"}");

            Label label = new Label(matrizModel.matriz[f][c].toString());

            VBox vbox = new VBox(label);

            ScrollPane s = new ScrollPane(vbox);

            Scene scene2 = new Scene(s,900,600);


            stage.setScene(scene2);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearJuegoR(BucleDeControlProperties modeloMatriz){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego.fxml"));
        try {
            Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);
            int turno = modeloMatriz.original.turno;
            stage.setTitle("juego en turno: "+ turno);
            stage.setScene(scene1);

            JuegoController p = fxmlLoader.getController();
            p.loadUserData(recursosModel,aguaModel,bibliotecaModel,comidaModel,montanaModel,pozoModel,tesoroModel,individuoModel,matrizModel);


            int filas = modeloMatriz.getFilas();
            int columnas = modeloMatriz.getColumnas();

            listaButton = new ListaEnlazada<>();


            GridPane mainGrid2 = new GridPane();
            ScrollPane scrollPane2 = new ScrollPane(mainGrid2);



            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    int numI = modeloMatriz.matriz[i][j].getListaIndividuo().getNumeroElementos();
                    int numR = modeloMatriz.matriz[i][j].getListaRecurso().getNumeroElementos();
                    String label = "nºInd: " + numI + "\n nºRec: " + numR;
                    Button b = new Button(label);
                    b.setId(i + "," + j);

                    listaButton.add(b);

                    int finalJ = j;
                    int finalI = i;

                    EventHandler e = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            p.onButtonInfo(finalI, finalJ,matrizModel);
                        }
                    };
                    b.setOnAction(e);


                    VBox placeholder = new VBox(b);

                    b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    placeholder.setMinSize(100, 100); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid2.add(placeholder, i, j);


                }
            }
            Button pauseB = new Button("Pausar");

            HBox hbox = new HBox(pauseB);
            hbox.setAlignment(Pos.BOTTOM_CENTER);

            RecursosController h = new RecursosController();

            EventHandler pauseHandler = new EventHandler() {
                @Override
                public void handle(Event event) {
                    System.out.println("pause handler");

                    String style = listaButton.getElemento(0).getData().getStyle();
                    for(int m=0;m<listaButton.getNumeroElementos();m++){
                        listaButton.getElemento(m).getData().setStyle("-fx-background-color: #ac5e5e; -fx-text-fill: black;");
                        String id = listaButton.getElemento(m).getData().getId();
                        String[] split = id.split(",");
                        int f = Integer.parseInt(split[0]);
                        int c = Integer.parseInt(split[1]);
                        AjustesMidJuegoController a = new AjustesMidJuegoController();
                        EventHandler y = new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                a.loadUserData(recursosModel, aguaModel,bibliotecaModel,comidaModel,montanaModel,
                                        pozoModel,tesoroModel,individuoModel,modeloMatriz);
                                a.modificarCelda(f,c,matrizModel);
                            }
                        };
                        listaButton.getElemento(m).getData().setOnAction(y);
                    }

                    RecursosController rec = h;
                    hbox.getChildren().remove(pauseB);

                    Button fin = new Button("Finalizar");
                    Button ajustes = new Button("Ajustes Propiedades");
                    Button play = new Button("Play");
                    play.setStyle("-fx-background-color: #3397cd; -fx-text-fill: white;");
                    hbox.getChildren().addAll(fin, ajustes, play);



                    EventHandler playHandler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            for(int m=0;m<listaButton.getNumeroElementos();m++){
                                listaButton.getElemento(m).getData().setStyle(style);
                                String id = listaButton.getElemento(m).getData().getId();
                                String[] split = id.split(",");
                                int f = Integer.parseInt(split[0]);
                                int c = Integer.parseInt(split[1]);
                                AjustesMidJuegoController a = new AjustesMidJuegoController();
                                JuegoController j = new JuegoController();
                                EventHandler y = new EventHandler() {
                                    @Override
                                    public void handle(Event event) {
                                        a.loadUserData(recursosModel, aguaModel,bibliotecaModel,comidaModel,montanaModel,
                                                pozoModel,tesoroModel,individuoModel,modeloMatriz);
                                        //a.modificarCelda(f,c);
                                        j.onButtonInfo(f,c,matrizModel);
                                    }
                                };
                                listaButton.getElemento(m).getData().setOnAction(y);
                            }
                            hbox.getChildren().remove(play);
                            hbox.getChildren().remove(ajustes);
                            hbox.getChildren().remove(fin);

                            hbox.getChildren().add(pauseB);

                            //continuar el juego
                        }
                    };
                    play.setOnAction(playHandler);

                    EventHandler finHandler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            GuardarDatos g = new GuardarDatos();
                            g.guardarDatos(modeloMatriz.original,individuoModel.getOriginal(),aguaModel.getOriginalAgua(),bibliotecaModel.getOriginal(),comidaModel.getOriginal(),montanaModel.getOriginal(),pozoModel.getOriginal(),tesoroModel.getOriginal());
                            stage.close();

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

                            HelloController h = new HelloController();

                            stage.setTitle("Hello!");

                            Label lab = new Label("Bienvenidos al juego de la vida");
                            lab.setStyle("-fx-font-size: 24px; -fx-text-fill: green;");

                            Button nuevoBtn = new Button("Nueva Partida");
                            Button cargarBtn = new Button("Cargar Partida");

                            EventHandler n = new EventHandler() {
                                @Override
                                public void handle(Event event) {
                                    stage.close();
                                    h.onMiBotonNuevaVentanaAjustesClick();
                                }
                            };

                            nuevoBtn.setOnAction(n);

                            EventHandler c = new EventHandler() {
                                @Override
                                public void handle(Event event) {
                                    stage.close();
                                    h.onMiBotonNuevaVentajaClick();
                                }
                            };

                            cargarBtn.setOnAction(c);


                            VBox vbox = new VBox(lab, nuevoBtn, cargarBtn);
                            vbox.setAlignment(Pos.CENTER);
                            vbox.setSpacing(20);

                            Scene scene = new Scene(vbox, 400, 200);


                            stage.setScene(scene);
                            stage.show();
                        }
                    };
                    fin.setOnAction(finHandler);

                    AjustesMidJuegoController l = new AjustesMidJuegoController();
                    EventHandler ajustesHandler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            System.out.println("ajustes handler");

                            for(int i=0;i<h.modeloMatriz.getFilas();i++){
                                for (int j = 0; j < h.modeloMatriz.getColumnas(); j++) {
                                    for (int k = 0; k < listaButton.getNumeroElementos(); k++) {
                                        String label = i+","+j;
                                        if(listaButton.getElemento(k).getData().getId().equals(label)){
                                            System.out.println("if");
                                            int finalI = i;
                                            int finalJ = j;
                                            EventHandler e = new EventHandler() {
                                                @Override
                                                public void handle(Event event) {
                                                    l.modificarCelda(finalI, finalJ,matrizModel);
                                                }
                                            };
                                            listaButton.getElemento(k).getData().setOnAction(e);
                                        }
                                    }
                                }
                            }

                        }
                    };

                    ajustes.setOnAction(ajustesHandler);






                }
            };

            pauseB.setOnAction(pauseHandler);

            mainGrid2.add(hbox, columnas, filas);

            p.setStage(stage);
            stage.show();


            Scene scene2 = new Scene(scrollPane2, 600, 600);
            scene1 = scene2;
            stage.setScene(scene1);
            stage.show();
            //modeloMatriz.original.guardar();
        }catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void actualizarButton(int f, int c,BucleDeControlProperties modeloMatriz,ListaEnlazada<Button> listaButton) {
        System.out.println("entra actualizar");
        this.listaButton = listaButton;
        int aux = 0;
        Button res = new Button();
        res.setId("hola");
        Button smt = new Button();
        while (aux < listaButton.getNumeroElementos()) {
            String[] splitted = listaButton.getElemento(aux).getData().getId().split(",");
            int n = Integer.parseInt(splitted[0]);
            int m = Integer.parseInt(splitted[1]);
            if (n==f && m==c) {
                res = listaButton.getElemento(aux).getData();
            }
            aux++;
        }
        System.out.println(res.getId());
        int numI = modeloMatriz.original.matriz[f][c].getListaIndividuo().getNumeroElementos();
        int numR = modeloMatriz.original.matriz[f][c].getListaRecurso().getNumeroElementos();
        String nombre = "nºInd: " + numI + "\n nºRec: " + numR;
        res.setText(nombre);

    }
}
