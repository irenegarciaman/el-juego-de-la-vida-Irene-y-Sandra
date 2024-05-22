package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoGrafoNuevoTest {

    @Test
    void getDato() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(4);
        assertEquals(4,a.getDato());
    }

    @Test
    void setDato() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2);
        assertDoesNotThrow(()->a.setDato(4));
        assertEquals(4,a.dato);
    }

    @Test
    void getPosN() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        assertEquals(3,a.getPosN());
    }

    @Test
    void getPosM() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        assertEquals(4,a.getPosM());
    }

    @Test
    void getListaEntrada() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        ListaSimple<ArcoGrafoNuevo<Integer>> d = new ListaSimple<>();
        assertDoesNotThrow(()->a.setListaEntrada(d));
        assertEquals(d,a.getListaEntrada());
    }

    @Test
    void setListaEntrada() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        ListaSimple<ArcoGrafoNuevo<Integer>> d = new ListaSimple<>();
        assertDoesNotThrow(()->a.setListaEntrada(d));
        assertEquals(d,a.getListaEntrada());
    }

    @Test
    void getListaSalida() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        ListaSimple<ArcoGrafoNuevo<Integer>> d = new ListaSimple<>();
        assertDoesNotThrow(()->a.setListaSalida(d));
        assertEquals(d,a.getListaSalida());
    }

    @Test
    void setListaSalida() {
        NodoGrafoNuevo<Integer> a = new NodoGrafoNuevo<>(2,3,4);
        ListaSimple<ArcoGrafoNuevo<Integer>> d = new ListaSimple<>();
        assertDoesNotThrow(()->a.setListaSalida(d));
        assertEquals(d,a.getListaSalida());
    }
}