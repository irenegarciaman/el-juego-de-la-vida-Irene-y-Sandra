package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLETest {
    ElementoLE e1 = new ElementoLE<>("a");
    ElementoLE e2 = new ElementoLE<>("b", e1);

    @Test
    void insertarmeEn() {
        e1.insertarmeEn(e2);
        assertEquals("b", e1.getSiguiente().getData());
    }

    @Test
    void getSiguiente() {
        e1.insertarmeEn(e2);
        assertEquals("b", e1.getSiguiente().getData());
    }

    @Test
    void setData() {
        e2.setData("z");
        assertEquals("z", e2.getData());
    }

    @Test
    void getData() {
        assertEquals("a", e1.getData());

    }

    @Test
    void setSiguiente() {
        e1.setSiguiente(e1);
        assertEquals("a", e1.getSiguiente().getData());

    }
}