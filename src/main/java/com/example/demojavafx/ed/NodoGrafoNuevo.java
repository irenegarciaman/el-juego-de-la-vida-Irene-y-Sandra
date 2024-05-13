package com.example.demojavafx.ed;

public class NodoGrafoNuevo <TipoDelDato>{
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
}
