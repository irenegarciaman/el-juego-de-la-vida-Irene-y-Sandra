package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLDETest {
    ElementoLDE e1 = new ElementoLDE<>("a");
    ElementoLDE e2 = new ElementoLDE<>("b");

    @Test
    void insertameEn() {
        e1.setAnterior(e1);
        e1.insertameEn(e2);
        assertEquals("a",e2.getSiguiente().getData());
    }

    @Test
    void getAnterior() {
        ElementoLDE e3 = new ElementoLDE(e2);
        assertEquals("b",e3.getAnterior().getData());
        e2.setAnterior(e1);
        assertEquals("a",e2.getAnterior().getData());
    }

    @Test
    void getSiguiente() {
        ElementoLDE e4 = new ElementoLDE<>(e1,e2,"d");
        assertEquals("b",e4.getSiguiente().getData());
        e1.setSiguiente(e2);
        assertEquals("b",e1.getSiguiente().getData());
    }

    @Test
    void getData() {
        assertEquals("a",e1.getData());
    }

    @Test
    void setData() {
        e1.setData("z");
        assertEquals("z",e1.getData());
    }

    @Test
    void setAnterior() {
        e2.setAnterior(e1);
        assertEquals("a",e2.getAnterior().getData());
    }

    @Test
    void setSiguiente() {
        e1.setSiguiente(e2);
        assertEquals("b",e1.getSiguiente().getData());
    }
}