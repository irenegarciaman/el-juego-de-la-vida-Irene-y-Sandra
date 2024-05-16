package com.example.demojavafx.recursos;

import javafx.beans.property.*;

public class AguaProperties extends RecursosProperties {
    protected Agua originalAgua;


    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty aumentoDeVida = new SimpleIntegerProperty();
    private IntegerProperty probAgua = new SimpleIntegerProperty();


    public AguaProperties(Agua original, Recursos rec) {
        super(rec);
        this.originalAgua = original;
    }

    @Override
    public void commit() {
        originalAgua.setTurnosRestantes(turnosRestantes.get());
        originalAgua.setAumentoDeVida(aumentoDeVida.get());
        originalAgua.setProbAgua(probAgua.get());
    }

    @Override
    public void rollback() {
        turnosRestantes.set(originalAgua.getTurnosRestantes());
        aumentoDeVida.set(originalAgua.getAumentoDeVida());
        probAgua.set(originalAgua.getProbAgua());
    }

    public Agua getOriginalAgua() {
        return originalAgua;
    }

    public void setOriginalAgua(Agua originalAgua) {
        this.originalAgua = originalAgua;
        rollback();
    }

    @Override
    public IntegerProperty turnosRestantesProperty() {
        return turnosRestantes;
    }

    public IntegerProperty aumentoDeVidaProperty() {
        return aumentoDeVida;
    }

    public IntegerProperty probAguaProperty() {
        return probAgua;
    }


}
