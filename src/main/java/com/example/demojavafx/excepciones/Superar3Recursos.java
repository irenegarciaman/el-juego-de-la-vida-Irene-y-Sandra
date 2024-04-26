package com.example.demojavafx.excepciones;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.Recursos;

public class Superar3Recursos extends Exception{
    public Superar3Recursos(ListaEnlazada<Recursos> listaRecurso) {
        int res = 0;
        int aux = 0;
        while (aux < listaRecurso.getNumeroElementos()) {
            int elem = listaRecurso.getElemento(aux).getData().getTurnosRestantes();
            if (elem > listaRecurso.getElemento(res).getData().getTurnosRestantes()) {
                res = aux;
            }
            aux++;
        }
        listaRecurso.delete(res);
    }
}
