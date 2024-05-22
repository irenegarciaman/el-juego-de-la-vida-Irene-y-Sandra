package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AguaTest {
    Agua agua = new Agua(3, 4);
    Agua agua1 = new Agua(3);

    @Test
    void getAumentoDeVida() {
        assertEquals(4, agua.getAumentoDeVida());
    }

    @Test
    void setAumentoDeVida() {
        Agua a = new Agua();
        a.setAumentoDeVida(5);
        assertEquals(5, a.getAumentoDeVida());
        agua.setAumentoDeVida(5);
        assertEquals(5, agua.getAumentoDeVida());
        Agua i = new Agua(4,4,4,4,4,4);
        i.setAumentoDeVida(5);
        assertEquals(5, i.getAumentoDeVida());
    }

    @Test
    void getProbAgua() {
        assertEquals(3, agua1.getProbAgua());
    }

    @Test
    void setProbAgua() {
        agua1.setProbAgua(6);
        assertEquals(6, agua1.getProbAgua());
    }

    @Test
    void testtoString(){
        String a = "Agua, {aumentoDeVida=0, probAgua=3, turnosRestantes=0, posN=0, posM=0, probNuevoRecurso=0, }";
        assertEquals(a,agua1.toString());
    }
}