package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MontanaTest {
    Montana montana = new Montana(5, 6);
    Montana montana2 = new Montana(5, 6.0f);

    @Test
    void getDisminucionDeVida() {
        assertEquals(6, montana.getDisminucionDeVida());
    }

    @Test
    void setDisminucionDeVida() {
        montana.setDisminucionDeVida(7);
        assertEquals(7, montana.getDisminucionDeVida());
    }

    @Test
    void getProbMontana() {
        assertEquals(6.0f, montana2.getProbMontana());
    }

    @Test
    void setProbMontana() {
        montana2.setProbMontana(5.0f);
        assertEquals(5.0f, montana2.getProbMontana());
    }
}