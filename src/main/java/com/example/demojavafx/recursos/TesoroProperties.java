package com.example.demojavafx.recursos;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TesoroProperties {
    protected Tesoro original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty aumentoDePorcenRep = new SimpleIntegerProperty();
    private IntegerProperty probTesoro = new SimpleIntegerProperty();


    public TesoroProperties(Tesoro original) {
        setOriginal(original);
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setAumentoDePorcenRep(aumentoDePorcenRep.get());
        original.setProbTesoro(probTesoro.get());
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        aumentoDePorcenRep.set(original.getAumentoDePorcenRep());
        probTesoro.set(original.getProbTesoro());
    }

    public Tesoro getOriginal() {
        return original;
    }

    public void setOriginal(Tesoro original) {
        this.original = original;
        rollback();
    }

    public IntegerProperty turnosRestantesProperty() {
        return turnosRestantes;
    }

    public IntegerProperty aumentoDePorenRepProperty() {
        return aumentoDePorcenRep;
    }

    public IntegerProperty probTesoroProperty() {
        return probTesoro;
    }
}
