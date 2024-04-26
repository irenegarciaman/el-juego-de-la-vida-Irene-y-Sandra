package com.example.demojavafx.recursos;

public class Tesoro extends Recursos {

    private float aumentoDePorcenRep;
    private float probTesoro;

    public Tesoro(int turnosRestantes, int aumentoDePorcenRep) {
        super(turnosRestantes);
        this.aumentoDePorcenRep = aumentoDePorcenRep;
    }

    public Tesoro(int tiempoVida, float probTesoro) {
        super(tiempoVida);
        this.probTesoro = probTesoro;
    }

    public float getAumentoDePorcenRep() {
        return aumentoDePorcenRep;
    }

    public void setAumentoDePorcenRep(float aumentoDePorcenRep) {
        this.aumentoDePorcenRep = aumentoDePorcenRep;
    }

    public float getProbTesoro() {
        return probTesoro;
    }

    public void setProbTesoro(float probTesoro) {
        this.probTesoro = probTesoro;
    }
}
