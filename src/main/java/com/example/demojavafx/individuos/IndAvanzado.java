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

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        //Recorrer las filas
        /**for (int i = 0; i < maxFilas; i++) {
            for(int j = 0; j <matriz[i][posM].getListaRecurso().getNumeroElementos()-1 ; j++) {
                Recursos recurso = matriz[i][posM].getListaRecurso().getElemento(j).getData();
                if(claseRecurso=="agua"){
                    if(recurso.getClass()== Agua.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="agua"){
                    if(recurso.getClass()== Agua.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="comida"){
                    if(recurso.getClass()== Comida.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="montaña"){
                    if(recurso.getClass()== Montana.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="tesoro"){
                    if(recurso.getClass()== Tesoro.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="biblioteca"){
                    if(recurso.getClass()== Biblioteca.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="pozo"){
                    if(recurso.getClass()== Pozo.class){
                        listaOpciones.add(recurso);
                    }
                }

            }
        }
        //Recorrer las columnas
        for (int i = 0; i < maxColumnas; i++) {
            for (int j = 0; j<matriz[posN][i].getListaRecurso().getNumeroElementos()-1; j++) {
                Recursos recurso = matriz[posN][i].getListaRecurso().getElemento(j).getData();
                if(claseRecurso=="agua"){
                    if(recurso.getClass()== Agua.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="agua"){
                    if(recurso.getClass()== Agua.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="comida"){
                    if(recurso.getClass()== Comida.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="montaña"){
                    if(recurso.getClass()== Montana.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="tesoro"){
                    if(recurso.getClass()== Tesoro.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="biblioteca"){
                    if(recurso.getClass()== Biblioteca.class){
                        listaOpciones.add(recurso);
                    }
                } else if(claseRecurso=="pozo"){
                    if(recurso.getClass()== Pozo.class){
                        listaOpciones.add(recurso);
                    }
                }
            }
        }*/
        //Se pueden recorrer filas y columnas a la vez
        for (int i = 0; i < maxFilas; i++) {
            for (int j = 0; j < maxColumnas; j++) {
                for (int h = 0; h<matriz[i][j].getListaRecurso().getNumeroElementos(); h++) {
                    Recursos recurso = matriz[i][j].getListaRecurso().getElemento(h).getData();
                    if (claseRecurso == "agua") {
                        if (recurso.getClass() == Agua.class) {
                            listaOpciones.add(recurso);
                        }
                    } else if (claseRecurso == "comida") {
                        if (recurso.getClass() == Comida.class) {
                            listaOpciones.add(recurso);
                        }
                    } else if (claseRecurso == "montaña") {
                        if (recurso.getClass() == Montana.class) {
                            listaOpciones.add(recurso);
                        }
                    } else if (claseRecurso == "tesoro") {
                        if (recurso.getClass() == Tesoro.class) {
                            listaOpciones.add(recurso);
                        }
                    } else if (claseRecurso == "biblioteca") {
                        if (recurso.getClass() == Biblioteca.class) {
                            listaOpciones.add(recurso);
                        }
                    } else if (claseRecurso == "pozo") {
                        if (recurso.getClass() == Pozo.class) {
                            listaOpciones.add(recurso);
                        }
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

}
