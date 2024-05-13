package com.example.demojavafx.ed;

import com.example.demojavafx.recursos.Recursos;

public class ElementoLE<TipoDelDato> {
    private ElementoLE<TipoDelDato> siguiente;
    private TipoDelDato data;

    public ElementoLE(TipoDelDato dato) {
        this.data = dato;
        this.siguiente = null;
    }

    public ElementoLE(TipoDelDato dato, ElementoLE<TipoDelDato> siguiente) {
        this.data = dato;
        this.siguiente = siguiente;
    }

    public void insertarmeEn(ElementoLE<TipoDelDato> el) {
        el.siguiente = this.siguiente;
        this.siguiente = el;
    }

    public ElementoLE<TipoDelDato> getSiguiente() {
        return siguiente;
    }


    public void setData(TipoDelDato data) {
        this.data = data;
    }

    public TipoDelDato getData() {
        return data;
    }


    public void setSiguiente(ElementoLE<TipoDelDato> siguiente) {
        this.siguiente = siguiente;
    }


}

