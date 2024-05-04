package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ArcoGrafoNuevo;
import com.example.demojavafx.ed.GrafoNuevo;
import com.example.demojavafx.ed.ListaSimple;
import com.example.demojavafx.ed.NodoGrafoNuevo;
import com.example.demojavafx.recursos.Recursos;

import java.util.Random;
Class<Recursos> claseRecurso;
public class IndAvanzado extends Individuo {
    public IndAvanzado(int id) {
        super(id);
    }

    public IndAvanzado(int id, int turnoVidaRestantes) {
        super(id, turnoVidaRestantes);
    }
    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz){
        ListaSimple<NodoGrafoNuevo> listaNodos = new ListaSimple<>();
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
        }

    }
}
