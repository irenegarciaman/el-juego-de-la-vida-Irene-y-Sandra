package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TesoroTest {
    Tesoro tesoro = new Tesoro(3, 4);
    Tesoro tesoro2 = new Tesoro(3, 4.0f);

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
        assertEquals(4.0f, tesoro2.getProbTesoro());
    }

    @Test
    void setProbTesoro() {
        tesoro.setProbTesoro(5.0f);
        assertEquals(5.0f, tesoro.getProbTesoro());
    }
}