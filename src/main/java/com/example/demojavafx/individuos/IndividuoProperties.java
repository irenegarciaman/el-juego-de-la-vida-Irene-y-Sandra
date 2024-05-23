package com.example.demojavafx.individuos;


import com.example.demojavafx.HelloApplication;
import javafx.beans.property.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IndividuoProperties {

    private static final Logger log = LogManager.getLogger(IndividuoProperties.class);

    protected Individuo original;


    private IntegerProperty turnosRestantes = new SimpleIntegerProperty();
    private IntegerProperty probReproduccion = new SimpleIntegerProperty();
    private IntegerProperty probClonacion = new SimpleIntegerProperty();
    private IntegerProperty probMuerte = new SimpleIntegerProperty();

    public IndividuoProperties(Individuo original) {
        setOriginal(original);
    }

    public void setOriginal(Individuo original) {
        this.original = original;
        rollback();
    }

    public Individuo getOriginal() {
        return original;
    }

    public void rollback() {
        turnosRestantes.set(original.getTurnosRestantes());
        probReproduccion.set(original.getProbReproduccion());
        probClonacion.set(original.getProbClonacion());
        probMuerte.set(original.getProbMuerte());
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void commit() {
        original.setTurnosRestantes(turnosRestantes.get());
        original.setProbReproduccion(probReproduccion.get());
        original.setProbClonacion(probClonacion.get());
        original.setProbMuerte(probMuerte.get());
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

    public Property<Number> probReproduccionProperty() {
        return probReproduccion;
    }

    public Property<Number> probClonacionProperty() {
        return probClonacion;
    }

    public Property<Number> probMuerteProperty() {
        return probMuerte;
    }


}
