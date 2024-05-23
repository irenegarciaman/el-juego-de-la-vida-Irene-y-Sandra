package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tesoro extends Recursos {
    private static final Logger log = LogManager.getLogger(Tesoro.class);

    public Tesoro(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDePorcenRep, int probTesoro) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDePorcenRep = aumentoDePorcenRep;
        this.probTesoro = probTesoro;
    }

    private int aumentoDePorcenRep;
    private int probTesoro;

    public Tesoro(int probTesoro) {
        this.probTesoro = probTesoro;
    }

    public Tesoro(int tiempoVida, int aumentoDePorcenRep) {
        super(tiempoVida);
        this.aumentoDePorcenRep = aumentoDePorcenRep;
    }

    public Tesoro() {
    }

    public int getAumentoDePorcenRep() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el aumento de porcentaje de reproduccion que proporciona el tesoro");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return aumentoDePorcenRep;
    }

    public void setAumentoDePorcenRep(int aumentoDePorcenRep) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el aumento de porcentaje de reproduccion que proporciona el tesoro");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.aumentoDePorcenRep = aumentoDePorcenRep;
    }

    public int getProbTesoro() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de que el recurso sea tesoro");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probTesoro;
    }

    public void setProbTesoro(int probTesoro) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea tesoro");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probTesoro = probTesoro;
    }

    @Override
    public String toString() {
        return "Tesoro, {" +
                "aumentoDePorcenRep=" + aumentoDePorcenRep +
                ", probTesoro=" + probTesoro +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
