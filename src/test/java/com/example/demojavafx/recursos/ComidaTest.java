package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComidaTest {
    Comida comida = new Comida(8, 7);
    Comida comida2 = new Comida(7);

    @Test
    void getAumentoDeVida() {
        assertEquals(7, comida.getAumentoDeVida());
    }

    @Test
    void setAumentoDeVida() {
        comida.setAumentoDeVida(3);
        assertEquals(3, comida.getAumentoDeVida());
    }

    @Test
    void getProbComida() {
        assertEquals(7, comida2.getProbComida());
    }

    @Test
    void setProbComida() {
        comida2.setProbComida(3);
        assertEquals(3, comida2.getProbComida());
    }
}