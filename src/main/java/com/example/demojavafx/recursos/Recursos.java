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
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    public int getPosN() {
        return posN;
    }

    public void setPosN(int posN) {
        this.posN = posN;
    }

    public int getPosM() {
        return posM;
    }

    public void setPosM(int posM) {
        this.posM = posM;
    }

    public int getProbNuevoRecurso() {
        return probNuevoRecurso;
    }

    public void setProbNuevoRecurso(int probNuevoRecurso) {
        this.probNuevoRecurso = probNuevoRecurso;
    }


}
