package com.example.demojavafx.matriz;

/**
 * Esta es la clase del modelo de datos básico
 **/
public class Matriz {

    private int columna;
    private int fila;


    /**
     * Constructor
     **/
    public Matriz(int vida, int velocidad) {
        this.columna = vida;
        this.fila = velocidad;
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
