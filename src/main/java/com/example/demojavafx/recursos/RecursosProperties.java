package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import javafx.beans.property.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RecursosProperties {

    private static final Logger log = LogManager.getLogger(RecursosProperties.class);
    protected Recursos original;


    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty posN = new SimpleIntegerProperty();
    private IntegerProperty posM = new SimpleIntegerProperty();
    private IntegerProperty probNuevoRecurso = new SimpleIntegerProperty();

    public RecursosProperties(Recursos original) {
        this.original = original;
    }

    public void setOriginal(Recursos original) {
        this.original = original;
        rollback();
    }

    public Recursos getOriginal() {
        return original;
    }


    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        posN.set(original.getPosN());
        posM.set(original.getPosM());
        probNuevoRecurso.set(original.getProbNuevoRecurso());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setPosN(posN.get());
        original.setPosM(posM.get());
        original.setProbNuevoRecurso(probNuevoRecurso.get());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que guarda los cambios establecidos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

    }

    public Property<Number> turnosRestantesProperty() {
        return turnosRestantes;
    }

    public Property<Number> posNProperty() {
        return posN;
    }

    public Property<Number> posMProperty() {
        return posM;
    }

    public Property<Number> probNuevoRecursoProperty() {
        return probNuevoRecurso;
    }
}
