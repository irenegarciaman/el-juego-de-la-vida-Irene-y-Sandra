package com.example.demojavafx;

import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class HelloApplication extends Application {



    private static final Logger log = LogManager.getLogger(HelloApplication.class);

    private Recursos recursos = new Recursos(6, 8, 9, 70);
    private RecursosProperties modeloRecursos = new RecursosProperties(recursos);

    private Agua agua = new Agua(6, 8, 9, 70, 50, 70);
    private AguaProperties modeloAgua = new AguaProperties(agua, recursos);

    private Biblioteca biblioteca = new Biblioteca(6, 8, 9, 70, 50, 70);
    private BibliotecaProperties modeloBiblioteca = new BibliotecaProperties(biblioteca, recursos);

    private Comida comida = new Comida(6, 8, 9, 70, 50, 70);
    private ComidaProperties modeloComida = new ComidaProperties(comida, recursos);

    private Montana montana = new Montana(6, 8, 9, 70, 50, 70);
    private MontanaProperties modeloMontana = new MontanaProperties(montana, recursos);

    private Tesoro tesoro = new Tesoro(6, 8, 9, 70, 50, 70);
    private TesoroProperties modeloTesoro = new TesoroProperties(tesoro, recursos);

    private Pozo pozo = new Pozo(3);
    private PozoProperties modeloPozo = new PozoProperties(pozo, recursos);


    private Individuo ind = new IndBasico(80, 80, 80, 80, 80, 80);
    private IndividuoProperties modeloInd = new IndividuoProperties(ind);

    private BucleDeControl matriz = new BucleDeControl(15, 15);
    private BucleDeControlProperties modeloMatriz = new BucleDeControlProperties(matriz);

    @Override
    public void start(Stage stage) throws IOException {

        log.info("Inicio del método de arranque de la aplicación para mostrar un menú de inicio");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));


        HelloController h = new HelloController();
        h.loadUserData(this.modeloRecursos, this.modeloAgua, this.modeloBiblioteca, this.modeloComida, this.modeloMontana, this.modeloPozo, this.modeloTesoro, this.modeloInd, this.modeloMatriz);

        Scene scene = new Scene(fxmlLoader.load(), 400, 200);
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
        vbox.setStyle("-fx-background-color: rgba(192,120,207,0.56);");
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);

        scene = new Scene(vbox, 400, 200);


        stage.setScene(scene);
        stage.show();


        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para mostrar un menú de inicio\"");
    }

    public static void main(String[] args) {
        launch();
    }
}