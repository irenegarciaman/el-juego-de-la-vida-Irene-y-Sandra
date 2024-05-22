package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {
    Tesoro tesoro = new Tesoro(3, 4);
    Tesoro tesoro2 = new Tesoro(4);

    @Test
    void getAumentoDePorcenRep() {
        assertEquals(4, tesoro.getAumentoDePorcenRep());
    }

    @Test
    void setAumentoDePorcenRep() {
        tesoro.setAumentoDePorcenRep(5);
        assertEquals(5, tesoro.getAumentoDePorcenRep());
    }

    @Test
    void getProbTesoro() {
        assertEquals(4, tesoro2.getProbTesoro());
    }

    @Test
    void setProbTesoro() {
        tesoro.setProbTesoro(5);
        assertEquals(5, tesoro.getProbTesoro());
        Tesoro s = new Tesoro();
        s.setProbTesoro(5);
        assertEquals(5, s.getProbTesoro());
    }
    @Test
    void testToString(){
        Tesoro t = new Tesoro(4,4,4,4,4,4);
        String a = "Tesoro, {aumentoDePorcenRep=4, probTesoro=4, turnosRestantes=4, posN=4, posM=4, probNuevoRecurso=4, }";
        assertEquals(a, t.toString());
    }
}