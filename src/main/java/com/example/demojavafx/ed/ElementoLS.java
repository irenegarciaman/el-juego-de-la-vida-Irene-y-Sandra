package com.example.demojavafx.ed;

public class ElementoLS<TipoDelDato> {
    TipoDelDato dato;

    public ElementoLS(TipoDelDato dato) {
        this.dato = dato;
    }

    public TipoDelDato getData() {
        return dato;
    }

    public void setData(TipoDelDato dato) {
        this.dato = dato;
    }
}

