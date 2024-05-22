package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PozoTest {
    Pozo pozo = new Pozo(8, 1);

    @Test
    void getProbPozo() {
        assertEquals(1, pozo.getProbPozo());
    }

    @Test
    void setProbPozo() {
        pozo.setProbPozo(5);
        assertEquals(5, pozo.getProbPozo());
        Pozo p = new Pozo();
        p.setProbPozo(5);
        assertEquals(5, p.getProbPozo());
        Pozo p1 = new Pozo(89);
        p1.setProbPozo(5);
        assertEquals(5, p1.getProbPozo());

    }
    @Test
    void testtoString(){
        Pozo p = new Pozo(3,3,3,3,33);
        String a = "Pozo, {probPozo=33, turnosRestantes=3, posN=3, posM=3, probNuevoRecurso=3, }";
        assertEquals(a,p.toString());
    }
}