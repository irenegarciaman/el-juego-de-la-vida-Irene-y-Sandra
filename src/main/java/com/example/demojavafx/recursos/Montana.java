package com.example.demojavafx.recursos;

public class Montana extends Recursos {
    private int disminucionDeVida;
    private int probMontana;

    public Montana(int probMontana) {
        this.probMontana = probMontana;
    }

    public Montana(int turnosRestantes, int disminucionDeVida) {
        super(turnosRestantes);
        this.disminucionDeVida = disminucionDeVida;
    }

    public Montana() {
    }

    public Montana(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int disminucionDeVida, int probMontana) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.disminucionDeVida = disminucionDeVida;
        this.probMontana = probMontana;
    }

    public int getDisminucionDeVida() {
        return disminucionDeVida;
    }

    public void setDisminucionDeVida(int disminucionDeVida) {
        this.disminucionDeVida = disminucionDeVida;
    }

    public int getProbMontana() {
        return probMontana;
    }

    public void setProbMontana(int probMontana) {
        this.probMontana = probMontana;
    }

    @Override
    public String toString() {
        return "Montana, {" +
                "disminucionDeVida=" + disminucionDeVida +
                ", probMontana=" + probMontana +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
