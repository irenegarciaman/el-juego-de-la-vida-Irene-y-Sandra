package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaminoTest {

    @Test
    void getCamino() {
        ListaSimple s = new ListaSimple();
        Camino c = new Camino<>(s,8.0);
        assertEquals(0,c.getCamino().getNumeroElementos());
    }

    @Test
    void testToString() {
        ListaSimple s = new ListaSimple();
        Camino c = new Camino<>(s,8.0);
        String a = "Camino{camino=com.example.demojavafx.ed.ListaSimple@77602954 , coste=8.0}";
        //assertEquals(a,c.toString());
    }
}