package com.example.demojavafx;

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

/***
    <?xml version="1.0" encoding="UTF-8"?>
     <Configuration status="DEBUG">
     <Appenders>
     <Console name="LogToConsole" target="SYSTEM_OUT">
     <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
     </Console>
     <RollingFile name="LogToRollingFile" fileName="logs/app.log"
    filePattern="logs/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
     <PatternLayout>
     <Pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} - %-5level - %logger - %msg%n</Pattern>
     </PatternLayout>
     <Policies>
     <TimeBasedTriggeringPolicy />
     <SizeBasedTriggeringPolicy size="10 MB"/>
     </Policies>
     </RollingFile>

     </Appenders>
     <Loggers>
     <!-- Elimina duplicados con additivity=false -->
     <Logger name="es.uah" level="info" additivity="false">
     <AppenderRef ref="LogToRollingFile"/>
     <AppenderRef ref="LogToConsole"/>
     </Logger>
     <Root level="error">
     <AppenderRef ref="LogToConsole"/>
     </Root>
     </Loggers>
     </Configuration>*/


    private static final Logger log = LogManager.getLogger(HelloApplication.class);
    @Override
    public void start(Stage stage) throws IOException {

        log.info("Inicio del método de arranque de la aplicación para mostrar un menú de inicio");
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        HelloController h = new HelloController();

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