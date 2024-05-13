package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.Recursos;

import java.util.Random;

public class IndNormal extends Individuo {
    public IndNormal(int id) {
        super(id);
    }

    public IndNormal(int id, int gerenacion, int turnsRestantes) {
        super(id, gerenacion, turnsRestantes);
    }

    public IndNormal(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
    }

    public IndNormal(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
    }

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        //Recorrer las filas
        for (int i = 0; i < maxFilas; i++) {
            for(int j = 0; j <matriz[i][this.posM].getListaRecurso().getNumeroElementos(); j++) {
                if (i!=this.posN) {
                    Recursos recurso = matriz[i][this.posM].getListaRecurso().getElemento(j).getData();
                    listaOpciones.add(recurso);
                }
            }
        }
        //Recorrer las columnas
        for (int i = 0; i <maxColumnas; i++) {
            for (int j = 0; j<matriz[this.posN][i].getListaRecurso().getNumeroElementos(); j++) {
                if (i!=this.posM) {
                    Recursos recursos = matriz[this.posN][i].getListaRecurso().getElemento(j).getData();
                    listaOpciones.add(recursos);
                }
            }
        }
        matriz[this.posN][this.posM].eliminarIndividuo(this);
        Random rand = new Random();
        int aux = rand.nextInt(listaOpciones.getNumeroElementos());
        Recursos recurso = listaOpciones.getElemento(aux).getData();
        this.setPosN(recurso.getPosN());
        this.setPosM(recurso.getPosM());
        matriz[posN][posM].addIndividuo(this);
    }

    @Override
    public String toString() {
        return "IndNormal, {" +
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
