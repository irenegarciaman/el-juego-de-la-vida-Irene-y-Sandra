package com.example.demojavafx.ed;


public class ElementoLDE <TipoDelDato> {
    public ElementoLDE(TipoDelDato data) {
        this.data = data;
    }

    private ElementoLDE anterior;
    private ElementoLDE siguiente;
    public TipoDelDato data;

    public ElementoLDE(ElementoLDE anterior) {
        this.anterior = anterior;
    }

    public ElementoLDE(ElementoLDE anterior, ElementoLDE siguiente,TipoDelDato data) {
        this.data = data;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }


    public void insertameEn(ElementoLDE el){
        el.anterior = this.anterior;
        el.siguiente=this;
        if(this.anterior != null){
            this.anterior.siguiente=el;
        }
        this.anterior=el;
    }

    public ElementoLDE getAnterior() {
        return anterior;
    }

    public ElementoLDE getSiguiente() {
        return siguiente;
    }

    public TipoDelDato getData() {
        return data;
    }

    public void setData(TipoDelDato data) {
        this.data = data;
    }

    public void setAnterior(ElementoLDE anterior) {
        this.anterior = anterior;
    }

    public void setSiguiente(ElementoLDE siguiente) {
        this.siguiente = siguiente;
    }
}
