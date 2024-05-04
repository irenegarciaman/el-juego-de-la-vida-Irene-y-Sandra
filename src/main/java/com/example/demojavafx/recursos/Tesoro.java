package com.example.demojavafx.recursos;

public class Tesoro extends Recursos {

    private int aumentoDePorcenRep;
    private int probTesoro;

    public Tesoro(int turnosRestantes) {
        super(turnosRestantes);

    }

    public Tesoro(int tiempoVida, int probTesoro) {
        super(tiempoVida);
        this.probTesoro = probTesoro;
    }

    public Tesoro() {
    }

    public int getAumentoDePorcenRep() {
        return aumentoDePorcenRep;
    }

    public void setAumentoDePorcenRep(int aumentoDePorcenRep) {
        this.aumentoDePorcenRep = aumentoDePorcenRep;
    }

    public int getProbTesoro() {
        return probTesoro;
    }

    public void setProbTesoro(int probTesoro) {
        this.probTesoro = probTesoro;
    }
}
