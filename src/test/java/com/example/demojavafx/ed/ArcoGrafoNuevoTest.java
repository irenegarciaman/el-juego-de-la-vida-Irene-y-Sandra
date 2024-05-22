package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcoGrafoNuevoTest {

    @Test
    void getOrigen() {
        NodoGrafoNuevo<Integer> b = new NodoGrafoNuevo<>(2);
        NodoGrafoNuevo<Integer> d = new NodoGrafoNuevo<>(22);
        ArcoGrafoNuevo<String> a = new ArcoGrafoNuevo<>("a",b,d, 4.3);
        assertEquals(b,a.getOrigen());
    }

    @Test
    void getDestino() {
        NodoGrafoNuevo<Integer> b = new NodoGrafoNuevo<>(2);
        NodoGrafoNuevo<Integer> d = new NodoGrafoNuevo<>(22);
        ArcoGrafoNuevo<String> a = new ArcoGrafoNuevo<>("a",b,d, 4.3);
        assertEquals(d,a.getDestino());
    }
}