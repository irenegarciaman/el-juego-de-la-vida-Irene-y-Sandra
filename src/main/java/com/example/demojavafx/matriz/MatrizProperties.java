package com.example.demojavafx.matriz;

import javafx.beans.property.*;


/**
 * Esta es una clase de utilidad, que permite generar unas propiedades observables para el GUI a partir
 * de los datos del modelo originalAgua de java.
 * Tiene los métodos de commit y rollback para establecer la operación final de traspasar los datos modificados
 * o reiniciarlos según se quiera.
 */
public class MatrizProperties {
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
    }

    public void rollback() {
        columnas.set(original.getColumna());
        filas.set(original.getFila());
    }

    public Matriz getOriginal() {
        return original;
    }

    public void setOriginal(Matriz original) {
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> columnasProperty() {
        return columnas;
    }

    public Property<Number> filasProperty() {
        return filas;
    }

}
