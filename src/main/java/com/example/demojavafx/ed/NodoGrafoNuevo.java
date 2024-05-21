package com.example.demojavafx.ed;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NodoGrafoNuevo<TipoDelDato> {
    private static final Logger log = LogManager.getLogger(NodoGrafoNuevo.class);
    TipoDelDato dato;
    ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaEntrada;
    ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaSalida;

    int posN;
    int posM;


    public NodoGrafoNuevo(TipoDelDato dato) {
        this.dato = dato;
        this.listaEntrada = new ListaSimple<>();
        this.listaSalida = new ListaSimple<>();
    }

    public NodoGrafoNuevo(TipoDelDato dato, int posN, int posM) {
        this.dato = dato;
        this.posN = posN;
        this.posM = posM;
        this.listaEntrada = new ListaSimple<>();
        this.listaSalida = new ListaSimple<>();
    }


    public TipoDelDato getDato() {
        return dato;
    }

    public void setDato(TipoDelDato dato) {
        this.dato = dato;
    }

    public int getPosN() {
        return posN;
    }

    public int getPosM() {
        return posM;
    }

    public ListaSimple<ArcoGrafoNuevo<TipoDelDato>> getListaEntrada() {
        return listaEntrada;
    }

    public void setListaEntrada(ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaEntrada) {
        this.listaEntrada = listaEntrada;
    }

    public ListaSimple<ArcoGrafoNuevo<TipoDelDato>> getListaSalida() {
        return listaSalida;
    }

    public void setListaSalida(ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaSalida) {
        this.listaSalida = listaSalida;
    }
}
