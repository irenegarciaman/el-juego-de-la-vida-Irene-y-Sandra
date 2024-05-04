package com.example.demojavafx.recursos;

public class Comida extends Recursos {
    private int aumentoDeVida;
    private int probComida;

    public Comida(int tiempoVida) {
        super(tiempoVida);

    }

    public Comida(int turnosRestantes, int aumentoDeVida) {
        super(turnosRestantes);
        this.aumentoDeVida = aumentoDeVida;
    }

    public Comida() {
    }

    public int getAumentoDeVida() {
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getProbComida() {
        return probComida;
    }

    public void setProbComida(int probComida) {
        this.probComida = probComida;
    }
}
