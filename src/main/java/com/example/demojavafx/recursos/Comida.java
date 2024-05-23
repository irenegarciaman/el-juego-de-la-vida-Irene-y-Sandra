package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Comida extends Recursos {

    private static final Logger log = LogManager.getLogger(Comida.class);

    private int aumentoDeVida;
    private int probComida;

    public Comida(int probComida) {
        this.probComida = probComida;
    }

    public Comida(int turnosRestantes, int aumentoDeVida) {
        super(turnosRestantes);
        this.aumentoDeVida = aumentoDeVida;
    }

    public Comida(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDeVida, int probComida) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
    }

    public Comida(int turnosRestantes, int posN, int posM, int aumentoDeVida, int probComida) {
        super(turnosRestantes, posN, posM);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
    }

    public Comida(int tiempoVida, int aumentoDeVida, int probComida) {
        super(tiempoVida);
        this.aumentoDeVida = aumentoDeVida;
        this.probComida = probComida;
    }

    public Comida() {
    }

    public int getAumentoDeVida() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el aumento de vida que proporciona la comida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el aumento de vida que proporciona la comida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getProbComida() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de que el recurso sea comida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probComida;
    }

    public void setProbComida(int probComida) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea comida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probComida = probComida;
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() de comida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "Comida, {" +
                "aumentoDeVida=" + aumentoDeVida +
                ", probComida=" + probComida +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
