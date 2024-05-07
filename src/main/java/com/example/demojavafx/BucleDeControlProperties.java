package com.example.demojavafx;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BucleDeControlProperties {
    private static final Logger log = LogManager.getLogger(BucleDeControlProperties.class);
    //Modelo de datos originalAgua
    protected BucleDeControl original;

    private IntegerProperty columnas = new SimpleIntegerProperty();
    private IntegerProperty filas = new SimpleIntegerProperty();

    protected Celda[][] matriz = new Celda[columnas.get()][columnas.get()];




    public BucleDeControlProperties(BucleDeControl original) {
        setOriginal(original);
    }

    public void commit() {
        original.setColumna(columnas.get());
        original.setFila(filas.get());
        original.matriz = matriz;
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
        matriz = original.matriz;
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }

    public BucleDeControl getOriginal() {
        return original;

    }

    public void setOriginal(BucleDeControl original) {
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
    public Celda[][] matrizProperty() {
        return matriz;
    }

}
