package com.example.demojavafx.ed;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArcoGrafoNuevo<TipoDelDato> {
    private static final Logger log = LogManager.getLogger(ArcoGrafoNuevo.class);
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


    public NodoGrafoNuevo getOrigen() {
        return origen;
    }

    public NodoGrafoNuevo getDestino() {
        return destino;
    }
}
