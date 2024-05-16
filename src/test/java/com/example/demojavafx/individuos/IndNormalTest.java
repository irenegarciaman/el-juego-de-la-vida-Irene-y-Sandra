package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndNormalTest {

    @Test
    void creacionListaMovimiento() {
    }

    @Test
    void moverse() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 3;

        BucleDeControl matriz1 = new BucleDeControl(fila, columna);
        IndNormal ind1 = new IndNormal(555);
        Recursos recurso1 = new Recursos();
        Recursos recurso2 = new Recursos();
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[1][1].addRecurso(recurso1);
        matriz1.matriz[0][0].addRecurso(recurso2);
        ind1.setPosN(1);
        ind1.setPosM(1);
        recurso1.setPosN(1);
        recurso1.setPosM(1);
        recurso2.setPosN(0);
        recurso2.setPosM(0);
        recurso1.setTurnosRestantes(5);
        recurso2.setTurnosRestantes(5);

        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(matriz1.matriz[1][1], ind1.colaOperaciones.getElemento(0).getData());
        assertEquals(recurso1, ind1.colaOperaciones.getElemento(1).getData());

    }

    @Test
    void testToString() {
    }
}