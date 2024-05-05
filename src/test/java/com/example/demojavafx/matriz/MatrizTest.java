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
    Matriz matriz = new Matriz(2,3);
    Individuo individuo1 = new IndBasico(1);
    Individuo individuo2 = new IndNormal(2);
    Individuo individuo3 = new IndNormal(3);
    Individuo individuo4 = new IndNormal(4);
    Individuo individuo5 = new IndNormal(5);
    Individuo individuo6 = new IndNormal(6);
    ListaEnlazada< Individuo > listaIndividuo = new ListaEnlazada<>();
    ListaEnlazada<Recursos> listaRecursos = new ListaEnlazada<>();
    Celda celda = new Celda(listaIndividuo,listaRecursos);

    @Test
    void getColumna() {
        listaIndividuo.add(individuo1);
        listaIndividuo.add(individuo2);
    }

    @Test
    void setColumna() {
    }

    @Test
    void getFila() {
    }

    @Test
    void setFila() {
    }
}