package com.example.demojavafx.recursos;

public class Comida extends Recursos {
    private int aumentoDeVida;
    private int probComida;

    public Comida(int probComida) {
        this.probComida = probComida;
    }

    public Comida(int turnosRestantes, int aumentoDeVida) {
        super(turnosRestantes);
        this.aumentoDeVida = aumentoDeVida;
    }

    public Comida(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDeVida, int probComida) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
    }

    public Comida(int turnosRestantes, int posN, int posM, int aumentoDeVida, int probComida) {
        super(turnosRestantes, posN, posM);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
    }

    public Comida(int tiempoVida, int aumentoDeVida, int probComida) {
        super(tiempoVida);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
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

    @Override
    public String toString() {
        return "Comida, {" +
                "aumentoDeVida=" + aumentoDeVida +
                ", probComida=" + probComida +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
