package com.example.demojavafx.recursos;

import com.example.demojavafx.matriz.Matriz;

public class Agua extends Recursos {

    private int aumentoDeVida;
    private int probAgua;

    public Agua(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDeVida, int probAgua) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDeVida = aumentoDeVida;
        this.probAgua = probAgua;
    }

    public Agua() {
    }

    public Agua(int probAgua) {
        this.probAgua = probAgua;
    }

    public Agua(int tiempoVida, int aumentoDeVida) {
        super(tiempoVida);
        this.aumentoDeVida = aumentoDeVida;
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

    @Override
    public String toString() {
        return "Agua, {" +
                "turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", probAgua=" + probAgua +
                ", aumentoDeVida=" + aumentoDeVida +
                ", }";
    }
}
