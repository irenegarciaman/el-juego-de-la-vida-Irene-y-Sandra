package com.example.demojavafx.recursos;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class ParameterMontanaProperties {
    protected Montana original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty disminucionDeVida = new SimpleIntegerProperty();
    private FloatProperty probMontana = new SimpleFloatProperty();



    public ParameterMontanaProperties(Montana original) {
        setOriginal(original);
    }

    public void commit(){
        original.setTurnosRestantes(turnosRestantes.get());
        original.setDisminucionDeVida(disminucionDeVida.get());
        original.setProbMontana(probMontana.get());
    }

    public void rollback(){
        turnosRestantes.set(original.getTurnosRestantes());
        disminucionDeVida.set(original.getDisminucionDeVida());
        probMontana.set(original.getProbMontana());
    }

    public Montana getOriginal() {
        return original;
    }

    public void setOriginal(Montana original) {
        this.original = original;
        rollback();
    }

    public IntegerProperty turnosRestantesProperty() {
        return turnosRestantes;
    }

    public IntegerProperty disminucionDeVidaProperty() {
        return disminucionDeVida;
    }

    public FloatProperty probMontanaProperty() {return probMontana;}
}
