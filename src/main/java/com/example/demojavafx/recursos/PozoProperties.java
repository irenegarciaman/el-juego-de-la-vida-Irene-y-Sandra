package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PozoProperties extends RecursosProperties {

    private static final Logger log = LogManager.getLogger(PozoProperties.class);

    protected Pozo original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty probPozo = new SimpleIntegerProperty();


    public PozoProperties(Pozo original, Recursos recursos) {
        super(recursos);
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
