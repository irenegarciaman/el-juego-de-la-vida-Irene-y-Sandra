package com.example.demojavafx;

import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CeldaTest {
    Celda celda = new Celda();
    Individuo individuo = new Individuo(0,3,3,3,3,3);
    Recursos recurso = new Recursos(1,2,3,4.0f);
    @Test
    void addIndividuo() {
        assertDoesNotThrow(()->celda.addIndividuo(individuo));
        assertDoesNotThrow(()->celda.addIndividuo(individuo));
        assertDoesNotThrow(()->celda.addIndividuo(individuo));
        assertThrows(Superar3Individuos.class,()->celda.addIndividuo(individuo));
        assertEquals(3,celda.getListaIndividuo().getEl().getData().getTurnosRestantes());
    }

    @Test
    void addRecurso() {
        assertDoesNotThrow(()->celda.addRecurso(recurso));
        assertDoesNotThrow(()->celda.addRecurso(recurso));
        assertDoesNotThrow(()->celda.addRecurso(recurso));
        assertThrows(Superar3Recursos.class,()->celda.addRecurso(recurso));
        assertEquals(1,celda.getListaRecurso().getElemento(0).getData().getTurnosRestantes());
    }
}