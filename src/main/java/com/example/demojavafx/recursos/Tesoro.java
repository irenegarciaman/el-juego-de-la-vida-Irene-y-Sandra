package com.example.demojavafx.recursos;

public class Tesoro extends Recursos {

    private int aumentoDePorcenRep;
    private int probTesoro;

    public Tesoro(int probTesoro) {
        this.probTesoro = probTesoro;
    }

    public Tesoro(int tiempoVida, int aumentoDePorcenRep) {
        super(tiempoVida);
        this.aumentoDePorcenRep = aumentoDePorcenRep;
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
