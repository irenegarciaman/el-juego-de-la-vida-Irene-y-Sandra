package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RecursosController implements Initializable {
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
    private Slider sliderProbNuevoRecurso;

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
    private Label labelColumnasMatriz;

    @FXML
    private Label labelFilasMatriz;

    @FXML
    private Slider sliderColumnasMatriz;

    @FXML
    private Slider sliderFilasMatriz;

    @FXML
    private Button cerrarButton;

    @FXML
    private Slider sliderTurnosVida1;

    @FXML Label labelTurnosVida1;

    private static final Logger log = LogManager.getLogger(RecursosController.class);


    private Stage scene;


    // Recursos medidas
    protected IntegerProperty medida = new SimpleIntegerProperty(0);
    protected IntegerProperty medTurnos = new SimpleIntegerProperty(0);

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
        sliderProbNuevoRecurso.valueProperty().bindBidirectional(medida);
        labelProbNuevoRecurso.textProperty().bind(medida.asString());

        sliderTurnosVida1.valueProperty().bindBidirectional(medTurnos);
        labelTurnosVida1.textProperty().bind(medTurnos.asString());
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

        //Matriz
        sliderFilasMatriz.valueProperty().bindBidirectional(mf);
        labelFilasMatriz.textProperty().bind(mf.asString());

        sliderColumnasMatriz.valueProperty().bindBidirectional(mc);
        labelColumnasMatriz.textProperty().bind(mc.asString());

    }

    //Recursos model
    protected RecursosProperties recursosModel;
    protected AguaProperties aguaModel;
    protected BibliotecaProperties bibliotecaModel;
    protected ComidaProperties comidaModel;
    protected MontanaProperties montanaModel;
    protected PozoProperties pozoModel;
    protected TesoroProperties tesoroModel;
    //Individuos model
    protected IndividuoProperties individuoModel;
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
        sliderProbNuevoRecurso.valueProperty().bindBidirectional(recursosModel.probNuevoRecursoProperty());
        sliderTurnosVida1.valueProperty().bindBidirectional(recursosModel.turnosRestantesProperty());


        aguaModel.turnosRestantesProperty().bind(recursosModel.turnosRestantesProperty());





        sliderProbAgua.valueProperty().bindBidirectional(aguaModel.probAguaProperty());
        sliderTurnosVidaAgua.valueProperty().bindBidirectional(aguaModel.aumentoDeVidaProperty());

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

        sliderColumnasMatriz.valueProperty().bindBidirectional(modeloMatriz.columnasProperty());
        sliderFilasMatriz.valueProperty().bindBidirectional(modeloMatriz.filasProperty());
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

        this.updateGUIwithModel();
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
        nuevaVentanaMatriz();

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
            p.loadUserData(this.recursosModel, this.getAguaModel(), this.getBibliotecaModel(), this.getComidaModel(), this.getMontanaModel(), this.getPozoModel(), this.getTesoroModel(), this.getIndividuoModel(), this.modeloMatriz);


            int filas = modeloMatriz.getFilas();
            int columnas = modeloMatriz.getColumnas();

            Button guardarButton = new Button("Guardar");

            GridPane mainGrid = new GridPane();
            ScrollPane scrollPane = new ScrollPane(mainGrid);


            for (int j = 0; j < filas; j++) {
                for (int i = 0; i < columnas; i++) {
                    int numI = modeloMatriz.matriz[j][i].getListaIndividuo().getNumeroElementos();
                    int numR = modeloMatriz.matriz[j][i].getListaRecurso().getNumeroElementos();
                    String label = "nºInd: " + numI + "\n nºRec: " + numR;
                    Button b = new Button(label);
                    b.setId(i + "," + j);
                    listaButton.add(b);

                    VBox placeholder = new VBox(b);
                    int finalJ = j;
                    int finalI = i;
                    RecursosController rec = this;
                    EventHandler e = new EventHandler() {
                        @Override
                        public void handle(Event event) {
                            p.onButtonAction(finalI, finalJ, rec);
                        }
                    };
                    b.setOnAction(e);
                    b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                    placeholder.setMinHeight(40);
                    placeholder.setMinWidth(100);
                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid.add(placeholder, i, j);

                }
            }

            mainGrid.add(guardarButton, 16, 16);
            mainGrid.setAlignment(Pos.BOTTOM_RIGHT);

            EventHandler nuevaVentana = new EventHandler() {
                @Override
                public void handle(Event event) {
                    modeloMatriz.commit();
                    stage.close();
                    crearJuego(modeloMatriz);

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

    public void actualizarButton(int c, int f) {
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
        int numI = modeloMatriz.original.matriz[c][f].getListaIndividuo().getNumeroElementos();
        int numR = modeloMatriz.original.matriz[c][f].getListaRecurso().getNumeroElementos();
        String nombre = "nºInd: " + numI + "\n nºRec: " + numR;
        res.setText(nombre);

    }

    public void crearJuego(BucleDeControlProperties modeloMatriz) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("juego.fxml"));
        try {
            Scene scene1 = new Scene(fxmlLoader.load(), 600, 400);
            int turno = modeloMatriz.original.turno;
            stage.setTitle("juego en turno: " + turno);
            stage.setScene(scene1);

            JuegoController p = fxmlLoader.getController();
            p.loadUserData(recursosModel, aguaModel, bibliotecaModel, comidaModel, montanaModel, pozoModel, tesoroModel, individuoModel, modeloMatriz);
            p.crearJuegoR(modeloMatriz);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

