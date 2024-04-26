package com.example.demojavafx.recursos;

public class Comida extends Recursos {
    private int aumentoDeVida;
    private float probComida;

    public Comida(int tiempoVida, float probComida) {
        super(tiempoVida);
        this.probComida = probComida;
    }

    public Comida(int turnosRestantes, int aumentoDeVida) {
        super(turnosRestantes);
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getAumentoDeVida() {
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        this.aumentoDeVida = aumentoDeVida;
    }

    public float getProbComida() {
        return probComida;
    }

    public void setProbComida(float probComida) {
        this.probComida = probComida;
    }
}
