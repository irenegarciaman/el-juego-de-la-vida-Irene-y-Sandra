package com.example.demojavafx.recursos;

import com.example.demojavafx.matriz.Matriz;

public class Agua extends Recursos {

    private int aumentoDeVida;
    private int probAgua;

    public Agua() {
    }

    public Agua(int turnosRestantes) {
        super(turnosRestantes);

    }

    public Agua(int tiempoVida, int probAgua) {
        super(tiempoVida);
        this.probAgua = probAgua;
    }

    public int getAumentoDeVida() {
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getProbAgua() {
        return probAgua;
    }

    public void setProbAgua(int probAgua) {
        this.probAgua = probAgua;
    }


}
