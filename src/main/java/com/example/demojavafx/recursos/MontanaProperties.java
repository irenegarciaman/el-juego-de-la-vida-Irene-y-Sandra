package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MontanaProperties extends RecursosProperties {

    private static final Logger log = LogManager.getLogger(MontanaProperties.class);
    protected Montana original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty disminucionDeVida = new SimpleIntegerProperty();
    private IntegerProperty probMontana = new SimpleIntegerProperty();


    public MontanaProperties(Montana original, Recursos rec) {
        super(rec);
        setOriginal(original);
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setDisminucionDeVida(disminucionDeVida.get());
        original.setProbMontana(probMontana.get());
    }

    public void rollback() {
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

    public IntegerProperty probMontanaProperty() {
        return probMontana;
    }
}
