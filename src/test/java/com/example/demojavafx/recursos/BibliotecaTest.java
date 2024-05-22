package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaTest {
    Biblioteca biblioteca = new Biblioteca(4, 5);
    Biblioteca biblioteca2 = new Biblioteca(5);

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
        assertEquals(5, biblioteca2.getProbBiblioteca());
    }

    @Test
    void setProbBiblioteca() {
        biblioteca2.setProbBiblioteca(6);
        assertEquals(6, biblioteca2.getProbBiblioteca());
        Biblioteca n = new Biblioteca(3,3,3);
        n.setProbBiblioteca(6);
        assertEquals(6, n.getProbBiblioteca());
        Biblioteca n2 = new Biblioteca(3,3,3,4,5);
        n2.setProbBiblioteca(6);
        assertEquals(6, n2.getProbBiblioteca());
        Biblioteca n3 = new Biblioteca();
        n3.setProbBiblioteca(6);
        assertEquals(6, n3.getProbBiblioteca());
    }

    @Test
    void testtoString(){
        Biblioteca b = new Biblioteca(4,4,4,4,4,4);
        String a = "Biblioteca, {aumentoDePorcenClon=4, probBiblioteca=4, turnosRestantes=4, posN=4, posM=4, probNuevoRecurso=4, }";
        assertEquals(a,b.toString());
    }
}