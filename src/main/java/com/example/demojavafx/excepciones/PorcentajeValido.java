package com.example.demojavafx.excepciones;

public class PorcentajeValido extends Exception {
    public int porcentaje;

    public PorcentajeValido(int porcentaje) {
        this.porcentaje = porcentaje;
    }
}
