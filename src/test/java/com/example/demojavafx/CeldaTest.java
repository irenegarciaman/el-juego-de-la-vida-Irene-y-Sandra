package com.example.demojavafx;

import com.example.demojavafx.excepciones.Superar3Elementos;
import com.example.demojavafx.individuos.Individuo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CeldaTest {
    Celda celda = new Celda();
    Individuo individuo = new Individuo(0,3,3,3,3,3);
    @Test
    void addIndividuo() {
        assertDoesNotThrow(()->celda.addIndividuo(individuo));
        assertDoesNotThrow(()->celda.addIndividuo(individuo));
        assertDoesNotThrow(()->celda.addIndividuo(individuo));

    }

    @Test
    void addRecurso() {

    }
}