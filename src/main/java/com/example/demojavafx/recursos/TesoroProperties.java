package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TesoroProperties extends RecursosProperties {
    protected Tesoro original;

    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty aumentoDePorcenRep = new SimpleIntegerProperty();
    private IntegerProperty probTesoro = new SimpleIntegerProperty();

    private static final Logger log = LogManager.getLogger(TesoroProperties.class);


    public TesoroProperties(Tesoro original, Recursos recursos) {
        super(recursos);
        setOriginal(original);
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setAumentoDePorcenRep(aumentoDePorcenRep.get());
        original.setProbTesoro(probTesoro.get());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que guarda los cambios establecidos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        aumentoDePorcenRep.set(original.getAumentoDePorcenRep());
        probTesoro.set(original.getProbTesoro());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
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
