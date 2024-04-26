package com.example.demojavafx;

import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.matriz.Matriz;
import com.example.demojavafx.matriz.MatrizProperties;
import com.example.demojavafx.recursos.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    static int contadorDeVentanasHijas = 0;

    @FXML
    private Label welcomeText;

    @FXML
    private Label labelValorSlider;
    @FXML
    private Slider miSlider;



    protected StringProperty texto = new SimpleStringProperty("No Hay Nada");
    protected IntegerProperty medida = new SimpleIntegerProperty(0);


    /** Modelo de datos **/


    private Recursos recursos = new Recursos(4);
    private RecursosProperties modeloRecursos = new RecursosProperties(recursos);

    private Agua agua = new Agua(3,4);
    private ParameterAguaProperties modeloAgua = new ParameterAguaProperties(agua);

    private Biblioteca biblioteca = new Biblioteca(3,10);
    private ParameterBibliotecaProperties modeloBiblioteca = new ParameterBibliotecaProperties(biblioteca);

    private Comida comida = new Comida(3,4);
    private ParameterComidaProperties modeloComida = new ParameterComidaProperties(comida);

    private Montana montana = new Montana(3,4);
    private ParameterMontanaProperties modeloMontana = new ParameterMontanaProperties(montana);

    private Tesoro tesoro = new Tesoro(3,4);
    private ParameterTesoroProperties modeloTesoro = new ParameterTesoroProperties(tesoro);

    private Pozo pozo = new Pozo(3);
    private ParameterPozoProperties modeloPozo = new ParameterPozoProperties(pozo);


    private Individuo ind = new Individuo(0);
    private IndividuoProperties modeloInd = new IndividuoProperties(ind);

    private Matriz matriz = new Matriz(2,3);
    private MatrizProperties modeloMatriz = new MatrizProperties(matriz);

    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        texto.set("Recambiamos una propiedad");
    }

    @FXML
    protected void onMiBotonEjemploClick() {
        welcomeText.setText("Establecemos un texto de ejemplo");
        texto.set("Cambiamos una propiedad!");
    }

    @FXML
    protected String getTexto() {
        return texto.toString();
    }


    @FXML
    protected void onMiBotonNuevaVentajaClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Hello! Ventana hija: " + contadorDeVentanasHijas++);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @FXML
    protected void onMiBotonNuevaVentanaAjustesClick(){
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cond-iniciales.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Ajustes: ");
            stage.setScene(scene);
            //Recursos
            RecursosController p = fxmlLoader.getController();
            p.loadUserData(this.modeloRecursos,this.modeloAgua,this.modeloBiblioteca,
                    this.modeloComida,this.modeloMontana,this.modeloPozo,this.modeloTesoro,this.modeloInd,
                    this.modeloMatriz);
            p.setStage(stage);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    protected void onMiBotonNuevaVentanaParametrosClick() {
        /***
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("parameters-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 500, 400);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            p.loadUserData(this.modeloMatriz); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
            //p.loadUserData(new ParameterDataModelProperties(this.parametrosData)); esta linea si quiero separar los valores
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }//Si quieres cambiar los datos inmmediatamente se quitarán "las cosas limpias"

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");
        //labelTextoEjemplo.textProperty().bind(texto);
        miSlider.valueProperty().bindBidirectional(medida);
        labelValorSlider.textProperty().bind(medida.asString());
    }
/***
    @FXML
    protected void onMiBotonNuevaVentanaMatrizClick() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("matrix-view.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 1000, 1000);
            stage.setTitle("Tablero de juego: ");
            stage.setScene(scene);
            MatrixController p = fxmlLoader.getController();
            p.loadUserData(this.modeloMatriz);
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/
}