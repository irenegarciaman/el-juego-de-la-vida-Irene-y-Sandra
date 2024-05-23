package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Montana extends Recursos {

    private static final Logger log = LogManager.getLogger(Montana.class);
    private int disminucionDeVida;
    private int probMontana;

    public Montana(int probMontana) {
        this.probMontana = probMontana;
    }

    public Montana(int turnosRestantes, int disminucionDeVida) {
        super(turnosRestantes);
        this.disminucionDeVida = disminucionDeVida;
    }

    public Montana() {
    }

    public Montana(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int disminucionDeVida, int probMontana) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.disminucionDeVida = disminucionDeVida;
        this.probMontana = probMontana;
    }

    public int getDisminucionDeVida() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la disminucion de vida que proporciona el recurso montana");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return disminucionDeVida;
    }

    public void setDisminucionDeVida(int disminucionDeVida) {
        this.disminucionDeVida = disminucionDeVida;
    }

    public int getProbMontana() {

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la disminucion de vida que proporciona el recurso montana");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probMontana;
    }

    public void setProbMontana(int probMontana) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea montana");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probMontana = probMontana;
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() de montana");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "Montana, {" +
                "disminucionDeVida=" + disminucionDeVida +
                ", probMontana=" + probMontana +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
