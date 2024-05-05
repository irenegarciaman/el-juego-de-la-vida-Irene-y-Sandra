package com.example.demojavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        // Ejemplo de cómo usar los LOGS de sistema que se habían definido antes.
        // Los logs trabajan por niveles:
        // trace, debug, info, warn, error y fatal
        //
        // Según la configuración del fichero de log4j2.xml, se guardarán los mensajes
        // del nivel configurado y superiores, pero no inferiores.

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        // Los logs sólo operan si la clase utilizada coincide con el patrón que se pone en el log4j2.xml.
        // En este caso el patrón es "es.uah" que coincide con nuestro paquete, por eso funciona.


        log.info("Fin del método de arranque de la aplicación para mostrar un menú de inicio\"");
    }

    public static void main(String[] args) {
        launch();
    }
}