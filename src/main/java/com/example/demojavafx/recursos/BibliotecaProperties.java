package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BibliotecaProperties extends RecursosProperties {
    private static final Logger log = LogManager.getLogger(BibliotecaProperties.class);
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
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que guarda los cambios establecidos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        aumentoDePorenClon.set(original.getAumentoDePorcenClon());
        probBilio.set(original.getProbBiblioteca());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
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
