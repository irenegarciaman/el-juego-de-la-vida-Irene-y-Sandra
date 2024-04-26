package com.example.demojavafx.recursos;

public class Agua extends Recursos {

    private int aumentoDeVida;
    private float probAgua;


    public Agua(int turnosRestantes, int aumentoDeVida) {
        super(turnosRestantes);
        this.aumentoDeVida = aumentoDeVida;
    }

    public Agua(int tiempoVida, float probAgua) {
        super(tiempoVida);
        this.probAgua = probAgua;
    }

    public int getAumentoDeVida() {
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        this.aumentoDeVida = aumentoDeVida;
    }

    public float getProbAgua() {
        return probAgua;
    }

    public void setProbAgua(float probAgua) {
        this.probAgua = probAgua;
    }
}
