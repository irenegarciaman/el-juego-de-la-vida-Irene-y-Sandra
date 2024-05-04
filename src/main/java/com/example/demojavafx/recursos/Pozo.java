package com.example.demojavafx.recursos;

public class Pozo extends Recursos {

    protected int probPozo;

    public Pozo(int tiempoVida) {
        super(tiempoVida);
    }

    public Pozo(int tiempoVida, int probPozo) {
        super(tiempoVida);
        this.probPozo = probPozo;
    }

    public Pozo() {
    }

    public int getProbPozo() {
        return probPozo;
    }

    public void setProbPozo(int probPozo) {
        this.probPozo = probPozo;
    }
}
