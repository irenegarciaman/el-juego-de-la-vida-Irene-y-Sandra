package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
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


    public ListaEnlazada<Individuo> getListaIndividuo() {
        return listaIndividuo;
    }

    public void setListaIndividuo(ListaEnlazada<Individuo> listaIndividuo) {
        this.listaIndividuo = listaIndividuo;
    }

    public ListaEnlazada<Recursos> getListaRecurso() {
        return listaRecurso;
    }

    public void setListaRecurso(ListaEnlazada<Recursos> listaRecurso) {
        this.listaRecurso = listaRecurso;
    }


    public void addIndividuo(Individuo individuo) throws Superar3Individuos {
        listaIndividuo.add(individuo);
        if(listaIndividuo.getNumeroElementos()>3) {

            throw new Superar3Individuos(listaIndividuo);
        }

    }
    public void addRecurso(Recursos recurso) throws Superar3Recursos {
        listaRecurso.add(recurso);
        if(listaRecurso.getNumeroElementos()>3) {
            throw new Superar3Recursos(listaRecurso);
        }

    }
}
