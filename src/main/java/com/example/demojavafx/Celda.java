package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Elementos;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.Recursos;

public class Celda {

    private ListaEnlazada<Individuo> listaIndividuo;
    private ListaEnlazada<Recursos> listaRecurso;

    public Celda() {
        ListaEnlazada<Individuo> listaIndividuo = new ListaEnlazada<>();
        ListaEnlazada<Recursos> listaRecurso = new ListaEnlazada<>();
        this.listaIndividuo = listaIndividuo;
        this.listaRecurso = listaRecurso;
    }

    public Celda(ListaEnlazada<Individuo> listaIndividuo, ListaEnlazada<Recursos> listaRecurso) {
        this.listaIndividuo = listaIndividuo;
        this.listaRecurso = listaRecurso;
    }

    public void addIndividuo(Individuo individuo) throws Superar3Elementos {
        if(listaIndividuo.getNumeroElementos()==3) {
            throw new Superar3Elementos("ha superado el numero de individuos máximo");
        }
        listaIndividuo.add(individuo);
    }
    public void addRecurso(Recursos recurso) throws Superar3Elementos {
        if(listaRecurso.getNumeroElementos()==3) {
            throw new Superar3Elementos("ha superado el numero de recursos máximo");
        }
        listaRecurso.add(recurso);
    }
}
