package com.example.demojavafx.ed;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoArbolTest {

    @Test
    void getDerecha() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a4 = new NodoArbol<>(6);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertDoesNotThrow(()->a3.setDerecha(a4));
        assertEquals(a4,a3.getDerecha(), "Los nodos derecha no son iguales");
    }

    @Test
    void setDerecha() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a4 = new NodoArbol<>(6);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertDoesNotThrow(()->a3.setDerecha(a4));
        assertEquals(a4,a3.getDerecha(), "Los nodos derecha no son iguales");

    }

    @Test
    void getIzquierda() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a4 = new NodoArbol<>(6);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertDoesNotThrow(()->a3.setIzquierda(a4));
        assertEquals(a4,a3.getIzquierda(), "Los nodos izquierda no son iguales");
    }

    @Test
    void setIzquierda() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a4 = new NodoArbol<>(6);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertDoesNotThrow(()->a3.setIzquierda(a4));
        assertEquals(a4,a3.getIzquierda(), "Los nodos izquierda no son iguales");
    }

    @Test
    void getDato() {
        NodoArbol a = new NodoArbol<>(3);
        NodoArbol b = new NodoArbol<>(4);
        assertDoesNotThrow(()->a.setDato(b));
        assertEquals(b,a.getDato(), "Los datos no son iguales");
    }

    @Test
    void setDato() {
        NodoArbol a = new NodoArbol<>(3);
        NodoArbol b = new NodoArbol<>(4);
        assertDoesNotThrow(()->a.setDato(b));
        assertEquals(b,a.getDato(), "Los datos no son iguales");

    }

    @Test
    void comprarar() {
    }

    @Test
    void gradoNodo() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertEquals(2,a3.gradoNodo(),"Los grados no son iguales");

    }

    @Test
    void esHoja() {
        NodoArbol a1 = new NodoArbol<>(3);
        NodoArbol a2 = new NodoArbol<>(4);
        NodoArbol a3 = new NodoArbol<>(a1,a2,5);
        assertFalse(a3.esHoja());
        NodoArbol a6 = new NodoArbol<>(9);
        assertTrue(a6.esHoja());
    }
}