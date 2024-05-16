package com.example.demojavafx;

import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.*;

public class Celda {

    private ListaEnlazada<Individuo> listaIndividuo;
    private ListaEnlazada<Recursos> listaRecurso;

    public Celda() {
        ListaEnlazada<Individuo> listaIndividuo = new ListaEnlazada<>(null);
        ListaEnlazada<Recursos> listaRecurso = new ListaEnlazada<>(null);
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
        if (listaIndividuo.getNumeroElementos() > 3) {
            int res = 0;
            int aux = 0;
            while (aux < listaIndividuo.getNumeroElementos()) {
                int elem = listaIndividuo.getElemento(aux).getData().getTurnosRestantes();
                if (elem < listaIndividuo.getElemento(res).getData().getTurnosRestantes()) {
                    res = aux;
                }
                aux++;
            }
            listaIndividuo.delete(res);
        }

    }


    public void addRecurso(Recursos recurso) throws Superar3Recursos {
        listaRecurso.add(recurso);
        if (listaRecurso.getNumeroElementos() > 3) {
            int res = 0;
            int aux = 0;
            while (aux < listaRecurso.getNumeroElementos()) {
                int elem = listaRecurso.getElemento(aux).getData().getTurnosRestantes();
                if (elem < listaRecurso.getElemento(res).getData().getTurnosRestantes()) {
                    res = aux;
                }
                aux++;
            }
            listaRecurso.delete(res);
        }

    }

    public void eliminarRecurso(Recursos recurso) {
        int pos = listaRecurso.getPosicion(new ElementoLE<>(recurso));
        listaRecurso.delete(pos);
    }

    public void eliminarIndividuo(Individuo ind) {
        int pos = listaIndividuo.getPosicion(new ElementoLE<>(ind));
        listaIndividuo.delete(pos);
    }

    @Override
    public String toString() {
        String resInd = "Lista de individuos: \n";
        String resRec = "Lista de recurso: \n";

        resInd += listaIndividuo.toString() + "\n";
        resRec += listaRecurso.toString() + "\n";
        return resInd + "\n" + resRec;
    }




}
