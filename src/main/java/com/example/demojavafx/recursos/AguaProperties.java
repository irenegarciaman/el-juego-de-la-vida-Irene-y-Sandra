package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AguaProperties extends RecursosProperties {
    protected Agua originalAgua;

    private static final Logger log = LogManager.getLogger(AguaProperties.class);


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
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que guarda los cambios establecidos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    @Override
    public void rollback() {
        turnosRestantes.set(originalAgua.getTurnosRestantes());
        aumentoDeVida.set(originalAgua.getAumentoDeVida());
        probAgua.set(originalAgua.getProbAgua());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
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
