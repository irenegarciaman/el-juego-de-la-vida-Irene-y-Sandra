package com.example.demojavafx.recursos;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Recursos {

    private static final Logger log = LogManager.getLogger(Recursos.class);


    protected int turnosRestantes;
    protected int posN;
    protected int posM;
    protected int probNuevoRecurso;

    public Recursos() {
    }

    public Recursos(int turnosRestantes, int posN, int posM, int probNuevoRecurso) {
        this.turnosRestantes = turnosRestantes;
        this.posN = posN;
        this.posM = posM;
        this.probNuevoRecurso = probNuevoRecurso;
    }

    public Recursos(int turnosRestantes, int posN, int posM) {
        this.turnosRestantes = turnosRestantes;
        this.posN = posN;
        this.posM = posM;
    }


    public Recursos(int tiempoVida) {
        this.turnosRestantes = tiempoVida;
    }

    public int getTurnosRestantes() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener los turnos de vida del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnosRestantes) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar los turnos de vida del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.turnosRestantes = turnosRestantes;
    }

    public int getPosN() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la posicion N del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return posN;
    }

    public void setPosN(int posN) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la posicion N del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.posN = posN;
    }

    public int getPosM() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la posicion M del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return posM;
    }

    public void setPosM(int posM) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la posicion M del recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.posM = posM;
    }

    public int getProbNuevoRecurso() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener la probabilidad de nuevo recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return probNuevoRecurso;
    }

    public void setProbNuevoRecurso(int probNuevoRecurso) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar la probabilidad de nuevo recurso");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.probNuevoRecurso = probNuevoRecurso;
    }


}
