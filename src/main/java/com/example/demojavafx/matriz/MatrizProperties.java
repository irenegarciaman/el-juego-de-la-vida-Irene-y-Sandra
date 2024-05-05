package com.example.demojavafx.matriz;

import com.example.demojavafx.HelloController;
import javafx.beans.property.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Esta es una clase de utilidad, que permite generar unas propiedades observables para el GUI a partir
 * de los datos del modelo originalAgua de java.
 * Tiene los métodos de commit y rollback para establecer la operación final de traspasar los datos modificados
 * o reiniciarlos según se quiera.
 */
public class MatrizProperties {
    private static final Logger log = LogManager.getLogger(MatrizProperties.class);
    //Modelo de datos originalAgua
    protected Matriz original;

    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty filas = new SimpleIntegerProperty();


    public MatrizProperties(Matriz original) {
        setOriginal(original);
    }

    public void commit() {
        original.setColumna(columnas.get());
        original.setFila(filas.get());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }

    public void rollback() {
        columnas.set(original.getColumna());
        filas.set(original.getFila());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }

    public Matriz getOriginal() {
        return original;

    }

    public void setOriginal(Matriz original) {
        this.original = original;
        rollback(); //Se inicializan los properties.
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");

    }

    public Property<Number> columnasProperty() {
        return columnas;

    }

    public Property<Number> filasProperty() {
        return filas;

    }

}
