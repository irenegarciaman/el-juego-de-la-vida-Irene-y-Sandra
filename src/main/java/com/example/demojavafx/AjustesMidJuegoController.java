package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.*;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class AjustesMidJuegoController implements Initializable {
    @FXML
    private Label labelProbNuevoRecurso;

    @FXML
    private Slider sliderProbAgua;

    @FXML
    private Slider sliderProbAumentBiblio;

    @FXML
    private Slider sliderProbBiblioteca;

    @FXML
    private Slider sliderProbComida;

    @FXML
    private Slider sliderProbMontana;

    @FXML
    private Slider sliderProbRecurso;

    @FXML
    private Slider sliderProbPozo;

    @FXML
    private Slider sliderProbTesoro;

    @FXML
    private Slider sliderRepAumentoTesoro;

    @FXML
    private Slider sliderTurnosAumentoComida;

    @FXML
    private Slider sliderTurnosVidaAgua;

    @FXML
    private Slider sliderTurnosVidaMontana;

    @FXML
    private Label a1;

    @FXML
    private Label a2;

    @FXML
    private Label b1;

    @FXML
    private Label b2;

    @FXML
    private Label c1;

    @FXML
    private Label c2;

    @FXML
    private Label m1;

    @FXML
    private Label m2;

    @FXML
    private Label p1;

    @FXML
    private Label t1;

    @FXML
    private Label t2;

    @FXML
    private Label pc;

    @FXML
    private Label pm;

    @FXML
    private Label pr;

    @FXML
    private Label t;

    @FXML
    private Slider sliderTurnosRestantesInd;

    @FXML
    private Slider sliderProbRepInd;

    @FXML
    private Slider sliderProbClonInd;

    @FXML
    private Slider sliderProbMuerteInd;

    @FXML
    private Button cerrarButton;


    private Stage scene;


    // Recursos medidas
    protected IntegerProperty medida = new SimpleIntegerProperty(0);

    protected IntegerProperty medB1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medB2 = new SimpleIntegerProperty(0);

    protected IntegerProperty medT1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medT2 = new SimpleIntegerProperty(0);

    protected IntegerProperty medC1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medC2 = new SimpleIntegerProperty(0);

    protected IntegerProperty medM1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medM2 = new SimpleIntegerProperty(0);

    protected IntegerProperty medP1 = new SimpleIntegerProperty(0);

    protected IntegerProperty medA1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medA2 = new SimpleIntegerProperty(0);

    //Individuos medidas
    protected IntegerProperty ind1 = new SimpleIntegerProperty(0);
    protected IntegerProperty ind2 = new SimpleIntegerProperty(0);
    protected IntegerProperty ind3 = new SimpleIntegerProperty(0);
    protected IntegerProperty ind4 = new SimpleIntegerProperty(0);


    //matriz medidas
    protected IntegerProperty mf = new SimpleIntegerProperty(0);
    protected IntegerProperty mc = new SimpleIntegerProperty(0);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sliderProbRecurso.valueProperty().bindBidirectional(medida);
        labelProbNuevoRecurso.textProperty().bind(medida.asString());
        //biblioteca
        sliderProbBiblioteca.valueProperty().bindBidirectional(medB1);
        b1.textProperty().bind(medB1.asString());

        sliderProbAumentBiblio.valueProperty().bindBidirectional(medB2);
        b2.textProperty().bind(medB2.asString());
        //Tesoro
        sliderProbTesoro.valueProperty().bindBidirectional(medT1);
        t1.textProperty().bind(medT1.asString());

        sliderRepAumentoTesoro.valueProperty().bindBidirectional(medT2);
        t2.textProperty().bind(medT2.asString());
        //comida
        sliderProbComida.valueProperty().bindBidirectional(medC1);
        c1.textProperty().bind(medC1.asString());

        sliderTurnosAumentoComida.valueProperty().bindBidirectional(medC2);
        c2.textProperty().bind(medC2.asString());
        //Montaña
        sliderProbMontana.valueProperty().bindBidirectional(medM1);
        m1.textProperty().bind(medM1.asString());

        sliderTurnosVidaMontana.valueProperty().bindBidirectional(medM2);
        m2.textProperty().bind(medM2.asString());
        //Agua
        sliderProbAgua.valueProperty().bindBidirectional(medA1);
        a1.textProperty().bind(medA1.asString());

        sliderTurnosVidaAgua.valueProperty().bindBidirectional(medA2);
        a2.textProperty().bind(medA2.asString());
        //pozo
        sliderProbPozo.valueProperty().bindBidirectional(medP1);
        p1.textProperty().bind(medP1.asString());
        //Individuo
        sliderTurnosRestantesInd.valueProperty().bindBidirectional(ind1);
        t.textProperty().bind(ind1.asString());

        sliderProbRepInd.valueProperty().bindBidirectional(ind2);
        pr.textProperty().bind(ind2.asString());

        sliderProbClonInd.valueProperty().bindBidirectional(ind3);
        pc.textProperty().bind(ind3.asString());

        sliderProbMuerteInd.valueProperty().bindBidirectional(ind4);
        pm.textProperty().bind(ind4.asString());



    }

    //Recursos model
    private RecursosProperties recursosModel;
    private AguaProperties aguaModel;
    private BibliotecaProperties bibliotecaModel;
    private ComidaProperties comidaModel;
    private MontanaProperties montanaModel;
    private PozoProperties pozoModel;
    private TesoroProperties tesoroModel;
    //Individuos model
    private IndividuoProperties individuoModel;
    //Matriz mode


    protected BucleDeControl matriz = new BucleDeControl(16, 16);
    protected BucleDeControlProperties modeloMatriz = new BucleDeControlProperties(matriz);

    protected Celda[][] celda = matriz.matriz;
    protected CeldaProperties modeloCelda = new CeldaProperties(celda);

    public ListaEnlazada<Button> listaButton = new ListaEnlazada<>();

    public RecursosProperties getRecursosModel() {
        return recursosModel;
    }

    public AguaProperties getAguaModel() {
        return aguaModel;
    }

    public BibliotecaProperties getBibliotecaModel() {
        return bibliotecaModel;
    }

    public ComidaProperties getComidaModel() {
        return comidaModel;
    }

    public MontanaProperties getMontanaModel() {
        return montanaModel;
    }

    public PozoProperties getPozoModel() {
        return pozoModel;
    }

    public TesoroProperties getTesoroModel() {
        return tesoroModel;
    }

    public IndividuoProperties getIndividuoModel() {
        return individuoModel;
    }

    public BucleDeControlProperties getMatrizModel() {
        return modeloMatriz;
    }

    protected void updateGUIwithModel() {

        sliderProbRecurso.valueProperty().bindBidirectional(recursosModel.probNuevoRecursoProperty());

        sliderProbAgua.valueProperty().bindBidirectional(aguaModel.probAguaProperty());
        sliderTurnosVidaAgua.valueProperty().bindBidirectional(aguaModel.turnosRestantesProperty());

        sliderProbBiblioteca.valueProperty().bindBidirectional(bibliotecaModel.probBibliotecaProperty());
        sliderProbAumentBiblio.valueProperty().bindBidirectional(bibliotecaModel.aumentoDePorenClonProperty());

        sliderProbComida.valueProperty().bindBidirectional(comidaModel.probComidaProperty());
        sliderTurnosAumentoComida.valueProperty().bindBidirectional(comidaModel.turnosRestantesProperty());

        sliderProbMontana.valueProperty().bindBidirectional(montanaModel.probMontanaProperty());
        sliderTurnosVidaMontana.valueProperty().bindBidirectional(montanaModel.turnosRestantesProperty());

        sliderProbTesoro.valueProperty().bindBidirectional(tesoroModel.probTesoroProperty());
        sliderRepAumentoTesoro.valueProperty().bindBidirectional(tesoroModel.aumentoDePorenRepProperty());

        sliderProbPozo.valueProperty().bindBidirectional(pozoModel.probPozoProperty());

        //Individuos

        sliderTurnosRestantesInd.valueProperty().bindBidirectional(individuoModel.turnosRestantesProperty());
        sliderProbRepInd.valueProperty().bindBidirectional(individuoModel.probReproduccionProperty());
        sliderProbClonInd.valueProperty().bindBidirectional(individuoModel.probClonacionProperty());
        sliderProbMuerteInd.valueProperty().bindBidirectional(individuoModel.probMuerteProperty());

        //Matriz


    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/

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
        this.modeloMatriz = parametroMatriz;

        //this.updateGUIwithModel();
    }

    public void setStage(Stage s) {
        this.scene = s;
    }

    public void guardarButton() {
        recursosModel.commit();
        aguaModel.commit();
        bibliotecaModel.commit();
        comidaModel.commit();
        montanaModel.commit();
        pozoModel.commit();
        tesoroModel.commit();
        individuoModel.commit();
        modeloMatriz.commit();

        scene.close();

    }


    public void modificarCelda(int f, int c,BucleDeControlProperties modeloMatriz){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("add-eliminar.fxml"));
        System.out.println(fxmlLoader.getLocation());
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            AddEliminiarController p =  fxmlLoader.getController();

            stage.setTitle("Modificaciones: ");
            stage.setScene(scene);

            p.loadUserData(modeloMatriz);


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

            ListaEnlazada<Button> listaB = new ListaEnlazada<>();




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
                            modeloMatriz.matriz[f][c].addRecurso(agua);
                            agua.setPosN(f);
                            agua.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Biblioteca"){

                        Biblioteca biblioteca = new Biblioteca();
                        try {
                            modeloMatriz.matriz[f][c].addRecurso(biblioteca);
                            biblioteca.setPosN(f);
                            biblioteca.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Comida"){

                        Comida comida = new Comida();
                        try {
                            modeloMatriz.matriz[f][c].addRecurso(comida);
                            comida.setPosN(f);
                            comida.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Montaña"){

                        Montana montana = new Montana();
                        try {
                            modeloMatriz.matriz[f][c].addRecurso(montana);
                            montana.setPosN(f);
                            montana.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Pozo"){

                        Pozo pozo = new Pozo();
                        try {
                            modeloMatriz.matriz[f][c].addRecurso(pozo);
                            pozo.setPosN(f);
                            pozo.setPosM(c);

                        } catch (Superar3Recursos ex) {
                            labelRec.textProperty().setValue("Ha superado el máximo de recursos");
                        }
                    }
                    if(labelRec.getText()=="Tesoro"){

                        Tesoro tesoro = new Tesoro();
                        try {
                            modeloMatriz.matriz[f][c].addRecurso(tesoro);
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
                    if (label.getText()=="Básico") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndBasico ind = new IndBasico(rand.nextInt(900));
                        try {
                            modeloMatriz.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText()=="Normal") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndNormal ind = new IndNormal(rand.nextInt(900));
                        try {
                            modeloMatriz.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                    if (label.getText()=="Avanzado") {
                        System.out.println("entra");
                        Random rand = new Random();
                        IndAvanzado ind = new IndAvanzado(rand.nextInt(900));
                        try {
                            modeloMatriz.matriz[f][c].addIndividuo(ind);
                            ind.setPosN(f);
                            ind.setPosM(c);
                        } catch (Superar3Individuos ex) {
                            label.textProperty().setValue("Ha superado el máximo de individuos");
                        }
                    }
                }
            };



            VBox vbox = new VBox();

            for (int k=0;k < modeloMatriz.matriz[f][c].getListaIndividuo().getNumeroElementos();k++){
                System.out.println(k);
                Individuo ind = modeloMatriz.matriz[f][c].getListaIndividuo().getElemento(k).getData();
                System.out.println("Eliminar: "+ind.getClass().getName() + ind.getId());
                String labe = "";
                if(ind.getClass().equals(IndBasico.class)){
                    labe += "Ind Básico ";
                }else if(ind.getClass().equals(IndNormal.class)){
                    labe += "Ind Normal ";
                }else if(ind.getClass().equals(IndAvanzado.class)){
                    labe += "Ind Avanzado ";
                }


                Button bu = new Button("Eliminar: "+labe + "id: "+ ind.getId());
                vbox.getChildren().addAll(bu);

                int finalJ = f;
                int finalI = c;
                EventHandler d = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        modeloMatriz.matriz[finalI][finalJ].eliminarIndividuo(ind);
                        vbox.getChildren().remove(bu);
                    }
                };

                bu.setOnAction(d);


            }

            for (int k=0;k < modeloMatriz.matriz[f][c].getListaIndividuo().getNumeroElementos();k++){
                Recursos rec = modeloMatriz.matriz[f][c].getListaRecurso().getElemento(k).getData();

                String labe = "";
                if(rec.getClass().equals(Agua.class)){
                    labe += "Agua ";
                }else if(rec.getClass().equals(Biblioteca.class)){
                    labe += "Biblioteca ";
                }else if(rec.getClass().equals(Comida.class)){
                    labe += "Comida ";
                }else if(rec.getClass().equals(Montana.class)){
                    labe += "Montana ";
                }else if(rec.getClass().equals(Tesoro.class)){
                    labe += "Tesoro ";
                }else{
                    labe += "Pozo: ";
                }


                Button ba = new Button("Eliminar: "+labe );

                int finalJ = f;
                int finalI = c;
                EventHandler d = new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        modeloMatriz.matriz[finalI][finalJ].eliminarRecurso(rec);
                        vbox.getChildren().remove(ba);
                    }
                };

                ba.setOnAction(d);

                vbox.getChildren().addAll(ba);
            }





            button.setOnAction(eventButtonInd);

            SplitPane splitPane1 = new SplitPane(rootInd,rootRec);
            splitPane1.setMinHeight(250);
            splitPane1.setOrientation(Orientation.VERTICAL);

            SplitPane splitPane2 = new SplitPane(splitPane1,vbox);
            splitPane2.setMinHeight(400);
            splitPane2.setOrientation(Orientation.VERTICAL);

            RecursosController rec = new RecursosController();


            JuegoController j = new JuegoController();

            Button button1 = new Button("Guardar");
            EventHandler eventButtonGuardar = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    modeloMatriz.commit();
                    j.loadUserData(recursosModel,aguaModel,bibliotecaModel,comidaModel,montanaModel,pozoModel,tesoroModel,individuoModel,modeloMatriz);
                    j.actualizarButton(f,c,modeloMatriz,listaButton);
                    stage.close();
                }
            };
            button1.setOnAction(eventButtonGuardar);
            VBox vbox2 = new VBox(splitPane2,button1);
            vbox.setAlignment(Pos.CENTER);
            vbox2.setAlignment(Pos.CENTER);

            Scene scene2 = new Scene(vbox2, 200, 450);


            stage.setScene(scene2);

            p.setStage(stage);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public void cerrarButton() {
        scene.close();
    }

    public void cancelarButton() {
        recursosModel.rollback();
        aguaModel.rollback();
        bibliotecaModel.rollback();
        comidaModel.rollback();
        montanaModel.rollback();
        pozoModel.rollback();
        tesoroModel.rollback();
        individuoModel.rollback();
        modeloMatriz.rollback();
    }




    public void nuevaVentanaMatriz() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("matriz1.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Posicion Usuarios: ");
            stage.setScene(scene);
            //Recursos
            Matriz1Controller p = fxmlLoader.getController();
            p.loadUserData(this.modeloMatriz,this.modeloCelda);


            int filas = modeloMatriz.getFilas();
            int columnas = modeloMatriz.getColumnas();

            Button guardarButton = new Button("Guardar");

            GridPane mainGrid = new GridPane();
            ScrollPane scrollPane = new ScrollPane(mainGrid);



            System.out.println(modeloMatriz.matriz[0][0].getListaIndividuo().getNumeroElementos());

            for (int j = 0; j < filas; j++) {
                for (int i = 0; i < columnas; i++) {
                    int numI = modeloMatriz.matriz[i][j].getListaIndividuo().getNumeroElementos();
                    int numR = modeloMatriz.matriz[i][j].getListaRecurso().getNumeroElementos();
                    String label = "nºInd: " + numI + "\n nºRec: " + numR;
                    Button b = new Button(label);
                    b.setId(i + "," + j);
                    listaButton.add(b);

                    VBox placeholder = new VBox(b);
                    int finalJ = j;
                    int finalI = i;
                    /***
                    AjustesMidJuegoController rec = this;
                    EventHandler e = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            p.onButtonAction(finalI, finalJ, rec);
                        }
                    };
                    b.setOnAction(e);*/
                    b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    placeholder.setMinSize(100, 100); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid.add(placeholder, i, j);

                }
            }

            mainGrid.add(guardarButton,16,16);
            mainGrid.setAlignment(Pos.BOTTOM_RIGHT);

            EventHandler nuevaVentana = new EventHandler() {
                @Override
                public void handle(Event event) {
                    modeloMatriz.commit();
                    stage.close();

                }
            };




            guardarButton.setOnAction(nuevaVentana);

            p.setStage(stage);
            stage.show();


            Scene scene2 = new Scene(scrollPane, 600, 600);
            scene = scene2;
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void actualizarButton(int f, int c) {
        String label = f + "," + c;
        int aux = 0;
        Button res = new Button();
        res.setId("hola");
        Button smt = new Button();
        while (aux < listaButton.getNumeroElementos()) {
            smt = listaButton.getElemento(aux).getData();
            if (smt.getId().toString().equals(label)) {
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
