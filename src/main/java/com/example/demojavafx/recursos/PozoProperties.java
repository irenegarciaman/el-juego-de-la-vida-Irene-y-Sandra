package com.example.demojavafx.recursos;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PozoProperties {
    protected Pozo original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty probPozo = new SimpleIntegerProperty();


    public PozoProperties(Pozo original) {
        setOriginal(original);
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setProbPozo(probPozo.get());
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        probPozo.set(original.getProbPozo());
    }

    public Pozo getOriginal() {
        return original;
    }

    public void setOriginal(Pozo original) {
        this.original = original;
        rollback();
    }

    public IntegerProperty turnosRestantesProperty() {
        return turnosRestantes;
    }

    public IntegerProperty probPozoProperty() {
        return probPozo;
    }

}
