package com.example.demojavafx;


import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.Individuo;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;

import static com.example.demojavafx.ed.Gson1.cargarObjetoDesdeArchivo;

public class JuegoController implements Initializable {

    private static final Logger log = LogManager.getLogger(JuegoController.class);


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

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion, la cual se encarga de cargar datos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


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


    public void onButtonInfo(int f, int c, BucleDeControlProperties matrizModel) {
        //se llama desde recursos controller
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("info-celda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);
            stage.setScene(scene);
            stage.setTitle("Ver celda {fila: " + c + " columna: " + f + "}");


            Label label = new Label(matrizModel.original.matriz[c][f].toString());

            VBox vbox = new VBox(label);

            ScrollPane s = new ScrollPane(vbox);

            Scene scene2 = new Scene(s, 900, 600);


            stage.setScene(scene2);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crearJuegoR(BucleDeControlProperties modeloMatriz) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego.fxml"));
        try {
            Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);
            int turno = modeloMatriz.original.turno;
            stage.setTitle("juego en turno: " + turno);
            stage.setScene(scene1);

            JuegoController p = fxmlLoader.getController();
            p.loadUserData(recursosModel, aguaModel, bibliotecaModel, comidaModel, montanaModel, pozoModel, tesoroModel, individuoModel, matrizModel);


            int filas = modeloMatriz.getFilas();
            int columnas = modeloMatriz.getColumnas();



            listaButton = new ListaEnlazada<>();


            GridPane mainGrid2 = new GridPane();
            ScrollPane scrollPane2 = new ScrollPane(mainGrid2);


            for (int j = 0; j < filas; j++) {
                for (int i = 0; i < columnas; i++) {
                    int numI = matrizModel.matriz[j][i].getListaIndividuo().getNumeroElementos();
                    int numR = matrizModel.matriz[j][i].getListaRecurso().getNumeroElementos();
                    String label = "nºInd: " + numI + "\n nºRec: " + numR;
                    Button b = new Button(label);
                    b.setId(i + "," + j);

                    listaButton.add(b);

                    int finalJ = j;
                    int finalI = i;

                    EventHandler e = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            p.onButtonInfo(finalI, finalJ, matrizModel);
                        }
                    };
                    b.setOnAction(e);


                    VBox placeholder = new VBox(b);

                    b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    b.setMinSize(80, 80);
                    placeholder.setMinHeight(80);
                    placeholder.setMinWidth(80);

                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid2.add(placeholder, i, j);


                }
            }
            Button pauseB = new Button("Pausar");

            HBox hbox = new HBox(pauseB);
            hbox.setAlignment(Pos.BOTTOM_CENTER);
            Button button = new Button("Empezar");
            double op =  button.getOpacity();

            EventHandler empezarHandler = new EventHandler() {
                @Override
                public void handle(Event event) {

                    try {
                        button.setText("Sigiente turno");
                        matrizModel.original.bucleEntero();
                        moverIndividuo(matrizModel);
                        for (int j = 0; j < filas; j++) {
                            for (int i = 0; i < columnas; i++) {
                                actualizarButton(i, j, modeloMatriz, listaButton);
                            }
                        }
                        stage.setTitle("juego en turno: " + matrizModel.original.turno);
                        if(matrizModel.original.condicionFinalizacion()){
                            stage.close();

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pantalla-final.fxml"));
                            PantallaFinalController p = new PantallaFinalController();

                            p.loadUserData(modeloMatriz);

                            p.abrirPantallaFinal();

                        }


                    } catch (Superar3Individuos e) {
                        e.printStackTrace();
                    } catch (Superar3Recursos e) {
                        e.printStackTrace();
                    }

                }
            };
            button.setOnAction(empezarHandler);
            hbox.getChildren().add(button);


            RecursosController h = new RecursosController();

            EventHandler pauseHandler = new EventHandler() {
                @Override
                public void handle(Event event) {

                    button.setOpacity(0);

                    String style = listaButton.getElemento(0).getData().getStyle();
                    for (int m = 0; m < listaButton.getNumeroElementos(); m++) {
                        listaButton.getElemento(m).getData().setStyle("-fx-background-color: #ac5e5e; -fx-text-fill: black;");
                        String id = listaButton.getElemento(m).getData().getId();
                        String[] split = id.split(",");
                        int f = Integer.parseInt(split[0]);
                        int c = Integer.parseInt(split[1]);
                        AjustesMidJuegoController a = new AjustesMidJuegoController();
                        EventHandler y = new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                a.loadUserData(recursosModel, aguaModel, bibliotecaModel, comidaModel, montanaModel,
                                        pozoModel, tesoroModel, individuoModel, modeloMatriz, listaButton);
                                a.modificarCelda(f, c, matrizModel);
                            }
                        };
                        listaButton.getElemento(m).getData().setOnAction(y);
                    }

                    hbox.getChildren().remove(pauseB);

                    Button fin = new Button("Finalizar");
                    Button ajustes = new Button("Ajustes Propiedades");
                    Button play = new Button("Play");
                    play.setStyle("-fx-background-color: #3397cd; -fx-text-fill: white;");
                    hbox.getChildren().addAll(fin, ajustes, play);


                    EventHandler playHandler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            button.setOpacity(op);
                            for (int m = 0; m < listaButton.getNumeroElementos(); m++) {
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
                                        a.loadUserData(recursosModel, aguaModel, bibliotecaModel, comidaModel, montanaModel,
                                                pozoModel, tesoroModel, individuoModel, modeloMatriz, listaButton);
                                        //a.modificarCelda(f,c);
                                        j.onButtonInfo(f, c, matrizModel);
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
                            g.guardarDatos(modeloMatriz.original, individuoModel.getOriginal(), aguaModel.getOriginalAgua(), bibliotecaModel.getOriginal(), comidaModel.getOriginal(), montanaModel.getOriginal(), pozoModel.getOriginal(), tesoroModel.getOriginal());
                            stage.close();

                            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("pantalla-final.fxml"));
                            PantallaFinalController p = new PantallaFinalController();

                            p.loadUserData(modeloMatriz);

                            p.abrirPantallaFinal();

                        }
                    };
                    fin.setOnAction(finHandler);

                    HelloController h = new HelloController();
                    GuardarDatos g = cargarObjetoDesdeArchivo("partidaAnterior.json", GuardarDatos.class);;
                    Recursos rM = g.cargarRecursos();
                    Agua aM = g.cargarAgua();
                    Biblioteca bM = g.cargarBiblioteca();
                    Comida coM = g.cargarComida();
                    Montana mM = g.cargarMontana();
                    Pozo pM = g.cargarPozo();
                    Tesoro tM = g.cargarTesoro();
                    Individuo iM = g.cargarIndividuo();

                    RecursosProperties r = new RecursosProperties(rM);
                    AguaProperties a = new AguaProperties(aM,rM);
                    BibliotecaProperties b = new BibliotecaProperties(bM,rM);
                    ComidaProperties co = new ComidaProperties(coM,rM);
                    MontanaProperties m = new MontanaProperties(mM,rM);
                    PozoProperties po = new PozoProperties(pM,rM);
                    TesoroProperties t = new TesoroProperties(tM,rM);

                    IndividuoProperties i = new IndividuoProperties(iM);




                    h.loadUserData(r,a,b,co,m,po,t,i,modeloMatriz);
                    EventHandler ajustesHandler = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            stage.close();
                            h.onMiBotonNuevaVentanaAjustesClick();
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


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void actualizarButton(int c, int f, BucleDeControlProperties modeloMatriz, ListaEnlazada<Button> listaButton) {
        this.listaButton = listaButton;
        int aux = 0;
        Button res = new Button();
        res.setId("hola");


        while (aux < listaButton.getNumeroElementos()) {
            String[] splitted = listaButton.getElemento(aux).getData().getId().split(",");

            int m = Integer.parseInt(splitted[0]);
            int n = Integer.parseInt(splitted[1]);

            if (n == f && m == c) {
                res = listaButton.getElemento(aux).getData();
            }
            aux++;
        }
        int numI = modeloMatriz.original.matriz[f][c].getListaIndividuo().getNumeroElementos();
        int numR = modeloMatriz.original.matriz[f][c].getListaRecurso().getNumeroElementos();
        String nombre = "nºInd: " + numI + "\n nºRec: " + numR;
        res.setText(nombre);

    }



    public void moverIndividuo(BucleDeControlProperties bucle) throws Superar3Individuos, Superar3Recursos {
        ListaEnlazada<Individuo> listaIndividuo = new ListaEnlazada<>();
        for (int j = 0; j < bucle.getFilas(); j++) {
            for (int i = 0; i < bucle.getColumnas(); i++) {
                for (int k = 0; k < matrizModel.matriz[j][i].getListaIndividuo().getNumeroElementos(); k++) {
                    listaIndividuo.add(matrizModel.matriz[j][i].getListaIndividuo().getElemento(k).getData());
                }
            }
        }

        BucleDeControl bucleDeControl = new BucleDeControl(bucle.getFilas(), bucle.getColumnas());
        Celda[][] matriz = bucleDeControl.matriz;
        for (int j = 0; j < bucle.getFilas(); j++) {
            for (int i = 0; i < bucle.getColumnas(); i++) {
                for (int k = 0; k < listaIndividuo.getNumeroElementos(); k++) {
                    Individuo ind = listaIndividuo.getElemento(k).getData();
                    if (j == ind.getPosN() && i == ind.getPosM()) {
                        matriz[j][i].addIndividuo(ind);
                    }
                }
                for (int h = 0; h < matrizModel.original.matriz[j][i].getListaRecurso().getNumeroElementos(); h++) {
                    if(matrizModel.original.matriz[j][i].getListaRecurso().getElemento(h).getData().getTurnosRestantes()!=0){
                        matriz[j][i].addRecurso(matrizModel.original.matriz[j][i].getListaRecurso().getElemento(h).getData());
                    }
                }
            }
        }

        bucle.original.matriz = matriz;


    }

}
