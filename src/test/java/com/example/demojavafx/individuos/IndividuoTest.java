package com.example.demojavafx.individuos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {
    IndBasico individuo = new IndBasico(3);

    IndBasico individuo2 = new IndBasico(3, 3,3);

    IndAvanzado individuo3 = new IndAvanzado(3, 3, 3,
            4, 5, 6);

    IndAvanzado individuo4 = new IndAvanzado(3, 3, 3,
            4, 5, 6, 7, 7);

    @Test
    void getId() {
        assertEquals(3, individuo.getId());
    }

    @Test
    void setId() {
        individuo.setId(5);
        assertEquals(5, individuo.getId());
    }

    @Test
    void getGeneracion() {
        assertEquals(3, individuo3.getGeneracion());
    }

    @Test
    void setGeneracion() {
        individuo3.setGeneracion(5);
        assertEquals(5, individuo3.getGeneracion());
    }

    @Test
    void getTurnosRestantes() {
        assertEquals(3, individuo2.getTurnosRestantes());

    }

    @Test
    void setTurnosRestantes() {
        individuo2.setTurnosRestantes(4);
        assertEquals(4, individuo2.getTurnosRestantes());
    }

    @Test
    void getProbReproduccion() {
        assertEquals(4, individuo4.getProbReproduccion());
    }

    @Test
    void setProbReproduccion() {
        individuo4.setProbReproduccion(1);
        assertEquals(1, individuo4.getProbReproduccion());
    }

    @Test
    void getProbClonacion() {
        assertEquals(5, individuo4.getProbClonacion());
    }

    @Test
    void setProbClonacion() {
        individuo4.setProbClonacion(4);
        assertEquals(4, individuo4.getProbClonacion());
    }

    @Test
    void getProbMuerte() {
        assertEquals(6, individuo4.getProbMuerte());
    }

    @Test
    void setProbMuerte() {
        individuo4.setProbMuerte(3);
        assertEquals(3, individuo4.getProbMuerte());
    }

    @Test
    void getPosM() {
        assertEquals(7, individuo4.getPosM());
    }

    @Test
    void setPosM() {
        individuo4.setPosM(3);
        assertEquals(3, individuo4.getPosM());
    }

    @Test
    void getPosN() {
        assertEquals(7, individuo4.getPosN());
    }

    @Test
    void setPosN() {
        individuo4.setPosN(3);
        assertEquals(3, individuo4.getPosN());
    }

    @Test
    void testToString() {
        assertEquals("Individuo{id=3, generacion=0, turnoVidaRestantes=3, probReproduccion=0, probClonacion=0, probMuerte=0}", individuo2.toString());
    }
}