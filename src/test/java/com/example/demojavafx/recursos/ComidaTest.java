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
        Comida c = new Comida();
        c.setProbComida(3);
        assertEquals(3, c.getProbComida());
        Comida n = new Comida(2,2,2);
        n.setProbComida(3);
        assertEquals(3, n.getProbComida());
        Comida b = new Comida(7,7,7,7,7);
        b.setProbComida(3);
        assertEquals(3, b.getProbComida());
    }
    @Test
    void testtoString(){
        Comida n = new Comida(3,3,3,3,3,3);
        String a = "Comida, {aumentoDeVida=3, probComida=3, turnosRestantes=3, posN=3, posM=3, probNuevoRecurso=3, }";
        assertEquals(a,n.toString());
    }
}