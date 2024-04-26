package com.example.demojavafx;

import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.matriz.MatrizProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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


    private Stage scene;



    // Recursos medidas
    protected FloatProperty medida = new SimpleFloatProperty(0);

    protected FloatProperty medB1 = new SimpleFloatProperty(0);
    protected FloatProperty medB2 = new SimpleFloatProperty(0);

    protected FloatProperty medT1 = new SimpleFloatProperty(0);
    protected FloatProperty medT2 = new SimpleFloatProperty(0);

    protected FloatProperty medC1 = new SimpleFloatProperty(0);
    protected IntegerProperty medC2 = new SimpleIntegerProperty(0);

    protected FloatProperty medM1 = new SimpleFloatProperty(0);
    protected IntegerProperty medM2 = new SimpleIntegerProperty(0);

    protected FloatProperty medP1 = new SimpleFloatProperty(0);

    protected FloatProperty medA1 = new SimpleFloatProperty(0);
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
    private ParameterAguaProperties aguaModel;
    private ParameterBibliotecaProperties bibliotecaModel;
    private ParameterComidaProperties comidaModel;
    private ParameterMontanaProperties montanaModel;
    private ParameterPozoProperties pozoModel;
    private ParameterTesoroProperties tesoroModel;
//Individuos model
    private IndividuoProperties individuoModel;
//Matriz mode
    private MatrizProperties matrizModel;


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

    public void loadUserData(RecursosProperties parametrosRecursos, ParameterAguaProperties parametrosAgua,
                             ParameterBibliotecaProperties parametrosBiblioteca, ParameterComidaProperties parametrosComida,
                             ParameterMontanaProperties parametrosMontana, ParameterPozoProperties parametrosPozo,
                             ParameterTesoroProperties parametrosTesoro,IndividuoProperties parametrosInd,
                             MatrizProperties parametroMatriz) {
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
    }

}
