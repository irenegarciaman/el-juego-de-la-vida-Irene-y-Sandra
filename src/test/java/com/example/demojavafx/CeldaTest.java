package com.example.demojavafx;

import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeldaTest {
    Celda celda = new Celda();
    IndBasico individuo = new IndBasico(0, 3, 3);
    Recursos recurso = new Recursos(1, 2, 3, 4);

    @Test
    void addIndividuo() {
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));

        assertEquals(3, celda.getListaIndividuo().getNumeroElementos());
    }

    @Test
    void addRecurso() {
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(() -> celda.addRecurso(recurso));

        assertEquals(3, celda.getListaRecurso().getNumeroElementos());
    }
    @Test
    void getListaIndividuos(){
        ListaEnlazada<Individuo> l = new ListaEnlazada<>();
        ListaEnlazada<Recursos> v = new ListaEnlazada<>();
        Celda n = new Celda(l,v);
        assertEquals(l,n.getListaIndividuo());
    }
    @Test
    void setListaIndividuos(){
        ListaEnlazada<Individuo> l = new ListaEnlazada<>();
        ListaEnlazada<Individuo> l2 = new ListaEnlazada<>();
        ListaEnlazada<Recursos> v = new ListaEnlazada<>();
        Celda n = new Celda(l,v);
        n.setListaIndividuo(l2);
        assertEquals(l2,n.getListaIndividuo());
    }

    @Test
    void getListaRecursos(){
        ListaEnlazada<Individuo> l = new ListaEnlazada<>();
        ListaEnlazada<Recursos> v = new ListaEnlazada<>();
        Celda n = new Celda(l,v);
        assertEquals(v,n.getListaRecurso());
    }
    @Test
    void setListaRecursos(){
        ListaEnlazada<Individuo> l = new ListaEnlazada<>();
        ListaEnlazada<Recursos> l2 = new ListaEnlazada<>();
        ListaEnlazada<Recursos> v = new ListaEnlazada<>();
        Celda n = new Celda(l,v);
        n.setListaRecurso(l2);
        assertEquals(l2,n.getListaRecurso());
    }

    @Test
    void eliminarRecurso(){
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(() -> celda.addRecurso(recurso));
        assertDoesNotThrow(()->celda.eliminarRecurso(recurso));
        assertEquals(2, celda.getListaRecurso().getNumeroElementos());
    }
    @Test
    void eliminarIndividuo(){
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.addIndividuo(individuo));
        assertDoesNotThrow(() -> celda.eliminarIndividuo(individuo));

        assertEquals(2, celda.getListaIndividuo().getNumeroElementos());
    }






}