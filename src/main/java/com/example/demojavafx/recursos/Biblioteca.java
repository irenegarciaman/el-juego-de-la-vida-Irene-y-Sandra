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
        return aumentoDePorcenClon;
    }

    public void setAumentoDePorcenClon(int aumentoDePorcenClon) {
        this.aumentoDePorcenClon = aumentoDePorcenClon;
    }

    public int getProbBiblioteca() {
        return probBiblioteca;
    }

    public void setProbBiblioteca(int probBiblioteca) {
        this.probBiblioteca = probBiblioteca;
    }

    @Override
    public String toString() {
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
