package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursosTest {
    Recursos recursos = new Recursos(4, 5, 6, 7);
    Recursos recursos2 = new Recursos(4);
    Recursos recursos3 = new Recursos(4, 3, 4);

    @Test
    void getTurnosRestantes() {
        assertEquals(4, recursos.getTurnosRestantes());
    }

    @Test
    void setTurnosRestantes() {
        recursos.setTurnosRestantes(3);
        assertEquals(3, recursos.getTurnosRestantes());
    }

    @Test
    void getPosN() {
        assertEquals(5, recursos.getPosN());
    }

    @Test
    void setPosN() {
        recursos3.setPosN(3);
        assertEquals(3, recursos3.getPosN());
    }

    @Test
    void getPosM() {
        assertEquals(6, recursos.getPosM());
    }

    @Test
    void setPosM() {
        recursos3.setPosM(3);
        assertEquals(3, recursos3.getPosM());
    }

    @Test
    void getProbNuevoRecurso() {
        assertEquals(7, recursos.getProbNuevoRecurso());
    }

    @Test
    void setProbNuevoRecurso() {
        recursos.setProbNuevoRecurso(8);
        assertEquals(8, recursos.getProbNuevoRecurso());
    }

    @Test
    void testToString() {
        assertEquals("Recursos{turnosRestantes=4, posN=5, posM=6}", recursos.toString());
    }
}