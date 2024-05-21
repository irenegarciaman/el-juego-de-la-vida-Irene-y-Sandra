package com.example.demojavafx.matriz;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrizTest {
    Matriz matriz = new Matriz(0, 0);



    @Test
    void getColumna() {
        assertEquals(0,matriz.getColumna());
    }

    @Test
    void setColumna() {
        matriz.setColumna(4);
        assertEquals(4,matriz.getColumna());
    }

    @Test
    void getFila() {
        assertEquals(0,matriz.getFila());
    }

    @Test
    void setFila() {
        matriz.setFila(4);
        assertEquals(4,matriz.getFila());
    }
}