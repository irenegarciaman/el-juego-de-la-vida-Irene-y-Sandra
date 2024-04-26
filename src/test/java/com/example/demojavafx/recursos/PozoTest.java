package com.example.demojavafx.recursos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PozoTest {
    Pozo pozo = new Pozo(8, 1.0f);

    @Test
    void getProbPozo() {
        assertEquals(1.0f, pozo.getProbPozo());
    }

    @Test
    void setProbPozo() {
        pozo.setProbPozo(5.0f);
        assertEquals(5.0f, pozo.getProbPozo());
    }
}