package com.example.demojavafx.excepciones;

import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.Individuo;

public class Superar3Individuos extends Exception {
    public Superar3Individuos(ListaEnlazada<Individuo> listaIndividuo) {
        int res = 0;
        int aux = 0;
        while (aux < listaIndividuo.getNumeroElementos()) {
            int elem = listaIndividuo.getElemento(aux).getData().getTurnosRestantes();
            if (elem > listaIndividuo.getElemento(res).getData().getTurnosRestantes()) {
                res = aux;
            }
            aux++;
        }
        listaIndividuo.delete(res);
    }
}
