package com.example.demojavafx.recursos;


import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Agua extends Recursos {

    private int aumentoDeVida;
    private int probAgua;

    private static final Logger log = LogManager.getLogger(Agua.class);

    public Agua(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDeVida, int probAgua) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDeVida = aumentoDeVida;
        this.probAgua = probAgua;
    }

    public Agua() {
    }

    public Agua(int probAgua) {
        this.probAgua = probAgua;
    }

    public Agua(int tiempoVida, int aumentoDeVida) {
        super(tiempoVida);
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getAumentoDeVida() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el aumento de vida que proporciona el agua");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return aumentoDeVida;
    }

    public void setAumentoDeVida(int aumentoDeVida) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el aumento de vida que proporciona el agua");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.aumentoDeVida = aumentoDeVida;
    }

    public int getProbAgua() {

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de que el recurso sea agua");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probAgua;
    }

    public void setProbAgua(int probAgua) {

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea agua");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probAgua = probAgua;
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() de agua");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "Agua, {" +
                "aumentoDeVida=" + aumentoDeVida +
                ", probAgua=" + probAgua +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
