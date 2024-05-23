package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Biblioteca extends Recursos {

    private static final Logger log = LogManager.getLogger(Biblioteca.class);

    private int aumentoDePorcenClon;
    private int probBiblioteca;

    public Biblioteca(int probBiblioteca) {
        this.probBiblioteca = probBiblioteca;
    }

    public Biblioteca(int turnosRestantes, int aumentoDePorcenClon) {
        super(turnosRestantes);
        this.aumentoDePorcenClon = aumentoDePorcenClon;
    }

    public Biblioteca(int turnosRestantes, int posN, int posM, int probNuevoRecurso, int aumentoDePorcenClon, int probBiblioteca) {
        super(turnosRestantes, posN, posM, probNuevoRecurso);
        this.aumentoDePorcenClon = aumentoDePorcenClon;
        this.probBiblioteca = probBiblioteca;
    }

    public Biblioteca(int turnosRestantes, int posN, int posM, int aumentoDePorcenClon, int probBiblioteca) {
        super(turnosRestantes, posN, posM);
        this.aumentoDePorcenClon = aumentoDePorcenClon;
        this.probBiblioteca = probBiblioteca;
    }

    public Biblioteca(int tiempoVida, int aumentoDePorcenClon, int probBiblioteca) {
        super(tiempoVida);
        this.aumentoDePorcenClon = aumentoDePorcenClon;
        this.probBiblioteca = probBiblioteca;
    }

    public Biblioteca() {
    }

    public int getAumentoDePorcenClon() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el aumento de porcentaje que proporciona la biblioteca");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return aumentoDePorcenClon;
    }

    public void setAumentoDePorcenClon(int aumentoDePorcenClon) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el aumento de porcentaje que proporciona la biblioteca");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.aumentoDePorcenClon = aumentoDePorcenClon;
    }

    public int getProbBiblioteca() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de que el recurso sea biblioteca");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probBiblioteca;
    }

    public void setProbBiblioteca(int probBiblioteca) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de que el recurso sea biblioteca");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probBiblioteca = probBiblioteca;
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() de biblioteca");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "Biblioteca, {" +
                "aumentoDePorcenClon=" + aumentoDePorcenClon +
                ", probBiblioteca=" + probBiblioteca +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
