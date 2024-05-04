package com.example.demojavafx.ed;


public class Camino <TipoDelDato>{
    public ListaSimple<NodoGrafoNuevo<TipoDelDato>> camino;
    public Double coste;

    public Camino(ListaSimple<NodoGrafoNuevo<TipoDelDato>> camino, Double coste) {
        this.camino = camino;
        this.coste = coste;
    }

    public ListaSimple<NodoGrafoNuevo<TipoDelDato>> getCamino() {
        return camino;
    }



    @Override
    public String toString() {
        for (int i=0; i<camino.getNumeroElementos(); i++){
            System.out.println("Los elemnetos del camino son: " + camino.getElemento(i).getData().dato);
        }
        return "Camino{" + "camino=" + camino + " , coste=" + coste + '}';
    }
}
