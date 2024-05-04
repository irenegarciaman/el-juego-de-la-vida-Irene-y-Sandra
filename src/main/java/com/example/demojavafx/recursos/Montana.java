package com.example.demojavafx.recursos;

public class Montana extends Recursos {
    private int disminucionDeVida;
    private int probMontana;

    public Montana(int tiempoVida) {
        super(tiempoVida);
    }

    public Montana(int turnosRestantes, int disminucionDeVida) {
        super(turnosRestantes);
        this.disminucionDeVida = disminucionDeVida;
    }

    public Montana() {
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
}
