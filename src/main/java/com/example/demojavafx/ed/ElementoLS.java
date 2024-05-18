package com.example.demojavafx.ed;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ElementoLS<TipoDelDato> {

    private static final Logger log = LogManager.getLogger(ElementoLS.class);

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

