package com.example.demojavafx.recursos;

public class Biblioteca extends Recursos {

    private int aumentoDePorcenClon;
    private int probBiblioteca;

    public Biblioteca(int tiempoVida) {
        super(tiempoVida);

    }

    public Biblioteca(int turnosRestantes, int aumentoDePorcenClon) {
        super(turnosRestantes);
        this.aumentoDePorcenClon = aumentoDePorcenClon;
    }

    public Biblioteca() {
    }

    public int getAumentoDePorcenClon() {
        return aumentoDePorcenClon;
    }

    public void setAumentoDePorcenClon(int aumentoDePorcenClon) {
        this.aumentoDePorcenClon = aumentoDePorcenClon;
    }

    public int getProbBiblioteca() {
        return probBiblioteca;
    }

    public void setProbBiblioteca(int probBiblioteca) {
        this.probBiblioteca = probBiblioteca;
    }
}
