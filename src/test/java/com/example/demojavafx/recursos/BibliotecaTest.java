package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    Biblioteca biblioteca = new Biblioteca(4, 5);
    Biblioteca biblioteca2 = new Biblioteca(4, 5.0F);

    @Test
    void getAumentoDePorcenClon() {
        assertEquals(5, biblioteca.getAumentoDePorcenClon());
    }

    @Test
    void setAumentoDePorcenClon() {
        biblioteca.setAumentoDePorcenClon(4);
        assertEquals(4, biblioteca.getAumentoDePorcenClon());
    }

    @Test
    void getProbBiblioteca() {
        assertEquals(5.0f, biblioteca2.getProbBiblioteca());
    }

    @Test
    void setProbBiblioteca() {
        biblioteca2.setProbBiblioteca(6.0F);
        assertEquals(6.0f, biblioteca2.getProbBiblioteca());
    }
}