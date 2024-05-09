package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        sliderProbNuevoRecurso.valueProperty().bindBidirectional(medida);
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

        //Matriz
        sliderFilasMatriz.valueProperty().bindBidirectional(mf);
        labelFilasMatriz.textProperty().bind(mf.asString());

        sliderColumnasMatriz.valueProperty().bindBidirectional(mc);
        labelColumnasMatriz.textProperty().bind(mc.asString());

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
    private BucleDeControlProperties matrizModel;

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
        return matrizModel;
    }

    protected void updateGUIwithModel() {
        sliderProbNuevoRecurso.valueProperty().bindBidirectional(recursosModel.probNuevoRecursoProperty());

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

        sliderColumnasMatriz.valueProperty().bindBidirectional(matrizModel.columnasProperty());
        sliderFilasMatriz.valueProperty().bindBidirectional(matrizModel.filasProperty());
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
        this.matrizModel = parametroMatriz;

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
        matrizModel.commit();

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
        matrizModel.rollback();
    }

    protected BucleDeControl matriz = new BucleDeControl(16, 16);
    protected BucleDeControlProperties modeloMatriz = new BucleDeControlProperties(matriz);

    protected Celda[][] celda = matriz.matriz;
    protected CeldaProperties modeloCelda = new CeldaProperties(celda);

    public ListaEnlazada<Button> listaButton = new ListaEnlazada<>();


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


            int filas = matrizModel.original.getFila();
            int columnas = matrizModel.original.getColumna();
            matrizModel.original.addCosas();


            GridPane mainGrid = new GridPane();
            ScrollPane scrollPane = new ScrollPane(mainGrid);

            System.out.println(matrizModel.original.matriz[0][0].getListaIndividuo().getNumeroElementos());

            for (int j = 0; j < filas; j++) {
                for (int i = 0; i < columnas; i++) {
                    int numI = matrizModel.original.matriz[i][j].getListaIndividuo().getNumeroElementos();
                    int numR = matrizModel.original.matriz[i][j].getListaRecurso().getNumeroElementos();
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
                    placeholder.setMinSize(100, 100); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(100, 100);
                    placeholder.setStyle("-fx-border-color: #000000; -fx-text-alignment: center;");
                    mainGrid.add(placeholder, i, j);

                    // OJO!: Tal como está programado, pierdo la referencia a los labels...
                    //       Si los quisiese usar después, debería guardarlos de alguna manera en algún sitio
                    // Pista: los quieres guardar para poder cambiar lo que aparece en pantalla :)
                }
            }
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
        Button smt = new Button();
        while (aux < listaButton.getNumeroElementos()) {
            smt = listaButton.getElemento(aux).getData();
            if (smt.getId() == label) {
                res = listaButton.getElemento(aux).getData();
            }
            aux++;
        }
        int numI = matrizModel.original.matriz[f][c].getListaIndividuo().getNumeroElementos();
        int numR = matrizModel.original.matriz[f][c].getListaRecurso().getNumeroElementos();
        String nombre = "nºInd: " + numI + "\n nºRec: " + numR;
        res.setText(nombre);

    }


}

