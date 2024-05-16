package com.example.demojavafx.recursos;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class BibliotecaProperties extends RecursosProperties {
    protected Biblioteca original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty aumentoDePorenClon = new SimpleIntegerProperty();
    private IntegerProperty probBilio = new SimpleIntegerProperty();


    public BibliotecaProperties(Biblioteca original, Recursos rec) {
        super(rec);
        setOriginal(original);
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setAumentoDePorcenClon(aumentoDePorenClon.get());
        original.setProbBiblioteca(probBilio.get());
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        aumentoDePorenClon.set(original.getAumentoDePorcenClon());
        probBilio.set(original.getProbBiblioteca());
    }

    public Biblioteca getOriginal() {
        return original;
    }

    public void setOriginal(Biblioteca original) {
        this.original = original;
        rollback();
    }

    public IntegerProperty turnosRestantesProperty() {
        return turnosRestantes;
    }

    public IntegerProperty aumentoDePorenClonProperty() {
        return aumentoDePorenClon;
    }

    public IntegerProperty probBibliotecaProperty() {
        return probBilio;
    }
}
