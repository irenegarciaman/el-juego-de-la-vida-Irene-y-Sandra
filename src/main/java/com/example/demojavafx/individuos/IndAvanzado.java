package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.*;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.*;

public class IndAvanzado extends Individuo {
    String claseRecurso;
    public IndAvanzado(int id) {
        super(id);
    }

    public IndAvanzado(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
    }

    public IndAvanzado(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
    }

    public IndAvanzado(int id, int gerenacion, int turnosRestantes) {
        super(id, gerenacion, turnosRestantes);
    }

    public IndAvanzado(int id, int generacion, int turnosRestantes, String claseRecurso) {
        super(id, generacion, turnosRestantes);
        this.claseRecurso = claseRecurso;
    }

    public IndAvanzado(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, String claseRecurso) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
        this.claseRecurso = claseRecurso;
    }

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        //Se pueden recorrer filas y columnas a la vez
        for (int i = 0; i < maxFilas; i++) {
            for (int j = 0; j < maxColumnas; j++) {
                for (int h = 0; h<matriz[i][j].getListaRecurso().getNumeroElementos(); h++) {
                    Recursos recurso = matriz[i][j].getListaRecurso().getElemento(h).getData();
                    if (this.posN!=i || this.posM!=j) {
                        listaOpciones.add(recurso);
                    }
                }
            }
        }
        Recursos aux = null;
        Integer dist = Integer.MAX_VALUE;
        for (int j = 0; j<listaOpciones.getNumeroElementos();j++){
            Recursos recurso = listaOpciones.getElemento(j).getData();
            int posColumna = recurso.getPosM() - this.posM;
            if (posColumna<0){
                posColumna = posColumna*(-1);
            }
            int posFila = recurso.getPosN() - this.posN;
            if (posFila<0){
                posFila = posFila*(-1);
            }
            int distacia = posColumna+posFila;
            if (distacia<dist){
                dist = distacia;
                aux = recurso;
            }
        }
        if (aux != null) {
            matriz[this.posN][this.posM].eliminarIndividuo(this);
            this.posN = aux.getPosN();
            this.posM = aux.getPosM();
            matriz[this.posN][this.posM].addIndividuo(this);
        }
    }

    @Override
    public String toString() {
        return "IndAvanzado, {" +
                "arbolGenealogico=" + arbolGenealogico +
                ", posM=" + posM +
                ", posN=" + posN +
                ", probMuerte=" + probMuerte +
                ", probClonacion=" + probClonacion +
                ", probReproduccion=" + probReproduccion +
                ", turnosRestantes=" + turnosRestantes +
                ", generacion=" + generacion +
                ", id=" + id +
                ", }";
    }
}
