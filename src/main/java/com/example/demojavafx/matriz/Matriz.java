package com.example.demojavafx.matriz;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.recursos.Recursos;

/**
 * Esta es la clase del modelo de datos básico
 **/
public class Matriz {

    private int columna;
    private int fila;
    private Celda matriz[][];

    /**
     * Constructor
     **/
    public Matriz(int fila, int columna) {
        this.matriz = new Celda[fila][columna];
    }


    /**
     * Setters y Getters
     **/
    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }


}
