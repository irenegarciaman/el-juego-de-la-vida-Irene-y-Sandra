package com.example.demojavafx.ed;

public class ArcoGrafoNuevo<TipoDelDato> {
    public TipoDelDato relacion;
    public NodoGrafoNuevo origen;

    public NodoGrafoNuevo destino;
    public Double peso;


    public ArcoGrafoNuevo(TipoDelDato relacion, NodoGrafoNuevo origen, NodoGrafoNuevo destino, Double peso) {
        this.relacion = relacion;
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }


}
