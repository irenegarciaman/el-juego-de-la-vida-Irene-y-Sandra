package com.example.demojavafx.recursos;

public class Montana extends Recursos{
    private int disminucionDeVida;
    private float probMontana;

    public Montana(int tiempoVida, float probMontana) {
        super(tiempoVida);
        this.probMontana = probMontana;
    }

    public Montana(int turnosRestantes, int disminucionDeVida) {
        super(turnosRestantes);
        this.disminucionDeVida = disminucionDeVida;
    }

    public int getDisminucionDeVida() {
        return disminucionDeVida;
    }

    public void setDisminucionDeVida(int disminucionDeVida) {
        this.disminucionDeVida = disminucionDeVida;
    }

    public float getProbMontana() {
        return probMontana;
    }

    public void setProbMontana(float probMontana) {
        this.probMontana = probMontana;
    }
}
