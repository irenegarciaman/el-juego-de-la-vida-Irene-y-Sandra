package com.example.demojavafx;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CeldaProperties {
    private static final Logger log = LogManager.getLogger(CeldaProperties.class);

    protected Celda[][] original;

    protected Celda[][] properties;

    public CeldaProperties(Celda[][] original) {
    }

    public Celda[][] getOriginal() {
        return original;
    }

    public void setOriginal(Celda[][] original) {
        this.original = original;
    }

    public Celda[][] getProperties() {
        return properties;
    }

    public void setProperties(Celda[][] properties) {
        this.properties = properties;
    }

    public void commit() {
        original = properties;
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que guarda los cambios establecidos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void rollback() {
        properties = original;
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que vuelve ha reestablecer los valores anteriores");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

}
