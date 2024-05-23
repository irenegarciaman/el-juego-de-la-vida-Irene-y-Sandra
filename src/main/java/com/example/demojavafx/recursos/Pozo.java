package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Pozo extends Recursos {

    private static final Logger log = LogManager.getLogger(Pozo.class);

    protected int probPozo;

    public Pozo(int tiempoVida) {
        super(tiempoVida);
    }

    public Pozo(int tiempoVida, int probPozo) {
        super(tiempoVida);
        this.probPozo = probPozo;
    }

    public Pozo() {
    }

    public Pozo(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int probPozo) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.probPozo = probPozo;
    }

    public int getProbPozo() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de que el recurso sea pozo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probPozo;
    }

    public void setProbPozo(int probPozo) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea pozo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probPozo = probPozo;
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() de pozo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "Pozo, {" +
                "probPozo=" + probPozo +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
