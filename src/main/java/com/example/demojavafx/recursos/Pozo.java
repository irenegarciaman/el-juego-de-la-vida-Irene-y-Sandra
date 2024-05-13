package com.example.demojavafx.recursos;

public class Pozo extends Recursos {

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
        return probPozo;
    }

    public void setProbPozo(int probPozo) {
        this.probPozo = probPozo;
    }

    @Override
    public String toString() {
        return "Pozo, {" +
                "probPozo=" + probPozo +
                ", turnosRestantes=" + turnosRestantes +
                ", posN=" + posN +
                ", posM=" + posM +
                ", probNuevoRecurso=" + probNuevoRecurso +
                ", }";
    }
}
