package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.*;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.*;

import java.util.Random;

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

    public IndAvanzado(int id, int gerenacion) {
        super(id, gerenacion);
    }
    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz){
       /** ListaSimple<NodoGrafoNuevo> listaNodos = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> listaArcos = new ListaSimple<>();
        GrafoNuevo<Celda> grafo = new GrafoNuevo<>(listaNodos,listaArcos);
        for (int i = 0; i < maxFilas; i++) {
            for (int j = 0; j < maxColumnas; j++) {
                Celda c = matriz[i][j];
                grafo.addNodo(new NodoGrafoNuevo<>(c));
            }
        }
        for (int i = 0; i < maxColumnas; i++) {
            for (int j = 0; j < maxFilas; j++) {
                ArcoGrafoNuevo arco = new ArcoGrafoNuevo<>("e", new NodoGrafoNuevo(matriz[j][i]), new NodoGrafoNuevo(matriz[j + 1][i]), 1.0);
                grafo.addArco(arco);
            }
        }
        for (int j = 0; j < maxFilas; j++) {
            for (int i = 0; i < maxColumnas; i++) {
                ArcoGrafoNuevo arco = new ArcoGrafoNuevo<>("e", new NodoGrafoNuevo(matriz[j][i]), new NodoGrafoNuevo(matriz[j][i+1]), 1.0);
                grafo.addArco(arco);
            }
        }*/
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        //Recorrer las filas
        for (int i = 0; i < maxFilas; i++) {
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
        }
        Recursos aux = null;
        Integer dist = Integer.MAX_VALUE;
        for (int j = 0; j<listaOpciones.getNumeroElementos()-1;j++){
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
            posN = aux.getPosN();
            posM = aux.getPosM();
        }
    }

}
