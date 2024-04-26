package com.example.demojavafx.individuos;

public class Individuo {
    int id;
    int generacion;
    int turnosRestantes;
    int probReproduccion;
    int probClonacion;
    int probMuerte;
    int posN;
    int posM;


    public Individuo(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnoVidaRestantes;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = probMuerte;
        this.posN = posN;
        this.posM = posM;
    }

    public Individuo(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnoVidaRestantes;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = probMuerte;
    }

    public Individuo(int id) {
        this.id = id;
    }

    public Individuo(int id, int turnoVidaRestantes) {
        this.id = id;
        this.turnosRestantes = turnoVidaRestantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnoVidaRestantes) {
        this.turnosRestantes = turnoVidaRestantes;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        this.probReproduccion = probReproduccion;
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        this.probClonacion = probClonacion;
    }

    public int getProbMuerte() {
        return probMuerte;
    }

    public void setProbMuerte(int probMuerte) {
        this.probMuerte = probMuerte;
    }

    public int getPosM() {
        return posM;
    }

    public void setPosM(int posM) {
        this.posM = posM;
    }

    public int getPosN() {
        return posN;
    }

    public void setPosN(int posN) {
        this.posN = posN;
    }

    @Override
    public String toString() {
        return "Individuo{" +
                "id=" + id +
                ", generacion=" + generacion +
                ", turnoVidaRestantes=" + turnosRestantes +
                ", probReproduccion=" + probReproduccion +
                ", probClonacion=" + probClonacion +
                ", probMuerte=" + probMuerte +
                '}';
    }
}
