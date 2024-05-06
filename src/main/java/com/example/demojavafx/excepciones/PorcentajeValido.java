package com.example.demojavafx.excepciones;

public class PorcentajeValido extends Exception{

    public PorcentajeValido(int porcentaje) {
        if (porcentaje < 0) {
            porcentaje = 0;
        }else if (porcentaje > 100){
            porcentaje = 100;
        }
    }
}
