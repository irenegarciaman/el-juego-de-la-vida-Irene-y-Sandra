package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.recursos.Recursos;

import java.util.Random;

public class IndNormal extends Individuo {
    public IndNormal(int id) {
        super(id);
    }

    public IndNormal(int id, int turnoVidaRestantes) {
        super(id, turnoVidaRestantes);
    }
    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz){
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        //Recorrer las filas
        for (int i = 0; i < maxFilas; i++) {
            for(int j = 0; j <matriz[i][posM].getListaRecurso().getNumeroElementos()-1 ; j++) {
                Recursos recurso = matriz[i][posM].getListaRecurso().getElemento(j).getData();
                listaOpciones.add(recurso);
            }
        }
        //Recorrer las columnas
        for (int i = 0; i < maxColumnas; i++) {
            for (int j = 0; j<matriz[posN][i].getListaRecurso().getNumeroElementos()-1; j++) {
                Recursos recursos = matriz[posN][i].getListaRecurso().getElemento(j).getData();
                listaOpciones.add(recursos);
            }
        }
        Random rand = new Random();
        int aux = rand.nextInt(listaOpciones.getNumeroElementos());
        Recursos recurso = listaOpciones.getElemento(aux).getData();
        posN = recurso.getPosN();
        posM = recurso.getPosM();
    }
}
