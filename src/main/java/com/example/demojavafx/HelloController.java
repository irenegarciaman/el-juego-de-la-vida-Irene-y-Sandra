package com.example.demojavafx;

import com.example.demojavafx.ed.Gson1;
import com.example.demojavafx.individuos.IndBasico;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demojavafx.ed.Gson1.cargarObjetoDesdeArchivo;

public class HelloController implements Initializable {


    private Stage stage;
    private static final Logger log = LogManager.getLogger(HelloController.class);




    private Recursos recursos = new Recursos(4);
    private RecursosProperties modeloRecursos = new RecursosProperties(recursos);

    private Agua agua = new Agua(3, 4);
    private AguaProperties modeloAgua = new AguaProperties(agua);

    private Biblioteca biblioteca = new Biblioteca(3, 10);
    private BibliotecaProperties modeloBiblioteca = new BibliotecaProperties(biblioteca);

    private Comida comida = new Comida(3, 4);
    private ComidaProperties modeloComida = new ComidaProperties(comida);

    private Montana montana = new Montana(3, 4);
    private MontanaProperties modeloMontana = new MontanaProperties(montana);

    private Tesoro tesoro = new Tesoro(3, 4);
    private TesoroProperties modeloTesoro = new TesoroProperties(tesoro);

    private Pozo pozo = new Pozo(3);
    private PozoProperties modeloPozo = new PozoProperties(pozo);


    private Individuo ind = new IndBasico(0);
    private IndividuoProperties modeloInd = new IndividuoProperties(ind);

    private BucleDeControl matriz = new BucleDeControl(15, 15);
    private BucleDeControlProperties modeloMatriz = new BucleDeControlProperties(matriz);

    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */




    @FXML
    protected void onMiBotonNuevaVentajaClick() {
        try{
            JuegoController p = new JuegoController();
            GuardarDatos gd = cargarObjetoDesdeArchivo("partidaAnterior.json", GuardarDatos.class);


            this.matriz = gd.cargarBucle();
            this.modeloMatriz = new BucleDeControlProperties(this.matriz);


            p.loadUserData(modeloRecursos, modeloAgua, modeloBiblioteca, modeloComida, modeloMontana, modeloPozo, modeloTesoro, modeloInd, modeloMatriz);
            p.crearJuegoR(this.modeloMatriz);
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    @FXML
    protected void onMiBotonNuevaVentanaAjustesClick() {
        log.info("Inicio del método de arranque de la aplicación para elegir los parámetros");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cond-iniciales.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Ajustes: ");
            stage.setScene(scene);
            //Recursos
            RecursosController p = fxmlLoader.getController();
            p.loadUserData(this.modeloRecursos, this.modeloAgua, this.modeloBiblioteca,
                    this.modeloComida, this.modeloMontana, this.modeloPozo, this.modeloTesoro, this.modeloInd,
                    this.modeloMatriz);
            p.setStage(stage);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");


        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }

}