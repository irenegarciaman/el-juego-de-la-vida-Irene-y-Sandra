package com.example.demojavafx.ed;

public class NodoGrafoNuevo <TipoDelDato>{
    TipoDelDato dato;
    ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaEntrada;
    ListaSimple<ArcoGrafoNuevo<TipoDelDato>> listaSalida;


    public NodoGrafoNuevo(TipoDelDato dato) {
        this.dato = dato;
        this.listaEntrada = new ListaSimple<>();
        this.listaSalida = new ListaSimple<>();
    }


    public TipoDelDato getDato() {
        return dato;
    }
}
