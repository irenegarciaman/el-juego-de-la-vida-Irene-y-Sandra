package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDoblementeEnlazadaTest {
    ElementoLDE elemento1 = new ElementoLDE<>("primer elemento");
    ElementoLDE elemento9 = new ElementoLDE<>("ultimo elemento");
    ListaDoblementeEnlazada lista1 = new ListaDoblementeEnlazada<>(elemento1);

    @Test
    void isVacia() {
        ElementoLDE elemento1 = new ElementoLDE<>("primer elemento");
        assertFalse(lista1.isVacia());
    }

    @Test
    void vaciar() {
        ElementoLDE elemento1 = new ElementoLDE<>("primer elemeto");
        ElementoLDE elemento9 = new ElementoLDE<>("ultimo elemeto");
        lista1.vaciar();
        assertTrue(lista1.isVacia());

    }

    @Test
    void add() {
        lista1.delete(0);
        lista1.add(elemento1.getData());
        lista1.add(elemento1.getData());
        assertEquals("primer elemento", lista1.getPrimero().getData());
    }

    @Test
    void testAdd() {
        Object c = "c";
        lista1.add(c);
        assertEquals("c", lista1.getPrimero().getData());
    }

    @Test
    void testInsert() {
    }

    @Test
    void insert() {
        lista1.delete(0);
        lista1.insert(elemento9.getData(), 0);
        lista1.add(elemento9.getData());
        lista1.insert("ultimo elemento", 1);
        assertEquals("ultimo elemento", lista1.getPrimero().getData());
        assertEquals("ultimo elemento", lista1.getElemento(1).getData());
    }

    @Test
    void delete() {
        lista1.add(elemento9.getData());
        lista1.insert(elemento1.getData(), 1);
        lista1.delete(0);
        assertEquals("primer elemento", lista1.getPrimero().getData());
    }

    @Test
    void getNumeroElementos() {
        lista1.delete(0);
        assertEquals(0, lista1.getNumeroElementos());
        lista1.add("a");
        lista1.add("a");
        lista1.add("a");
        lista1.add("a");
        lista1.add("a");
        assertEquals(5, lista1.getNumeroElementos());
    }

    @Test
    void getPosicion() {
        lista1.delete(0);
        assertEquals(-1, lista1.getPosicion(elemento1));
        lista1.add(elemento1.getData());
        lista1.add("a");
        lista1.add("c");
        assertEquals(2, lista1.getPosicion(elemento1));
    }

    @Test
    void getPrimero() {
        assertEquals("primer elemento", lista1.getPrimero().getData());
    }

    @Test
    void getUltimo() {
        assertEquals("primer elemento", lista1.getUltimo().getData());

    }

    @Test
    void getSiguiente() {
        ElementoLDE a = new ElementoLDE<>("a");
        ElementoLDE b = new ElementoLDE<>("b");
        ElementoLDE c = new ElementoLDE<>("c");
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada<>();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        assertEquals("a", lista.getSiguiente(b).getData());
        assertEquals("b", lista.getSiguiente(c).getData());
        assertNull(lista.getSiguiente(a));
    }

    @Test
    void getAnterior() {
        ElementoLDE a = new ElementoLDE<>("a");
        ElementoLDE b = new ElementoLDE<>("b");
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada<>();
        lista.add("a");
        lista.add("b");
        assertEquals("b", lista.getAnterior(a).getData());

    }


    @Test
    void getElemento() {
        lista1.add("a");
        lista1.add("b");
        lista1.add("c");
        lista1.add("e");
        assertEquals("e", lista1.getElemento(0).getData(), "los elementos no son iguales");
        assertEquals("c", lista1.getElemento(1).getData(), "los elementos no son iguales");
        assertEquals("b", lista1.getElemento(2).getData(), "los elementos no son iguales");
        assertEquals("a", lista1.getElemento(3).getData(), "los elementos no son iguales");
        assertEquals("primer elemento", lista1.getElemento(4).getData(), "los elementos no son iguales");

        ElementoLDE d = new ElementoLDE<>("d");
        lista1.insert(d.getData(), 2);
        assertEquals("e", lista1.getElemento(0).getData(), "los elementos no son iguales");
        assertEquals("c", lista1.getElemento(1).getData(), "los elementos no son iguales");
        assertEquals("d", lista1.getElemento(2).getData(), "los elementos no son iguales");
        assertEquals("b", lista1.getElemento(3).getData(), "los elementos no son iguales");
        assertEquals("a", lista1.getElemento(4).getData(), "los elementos no son iguales");
        assertEquals("primer elemento", lista1.getElemento(5).getData(), "los elementos no son iguales");
        lista1.delete(3);
        assertEquals("e", lista1.getElemento(0).getData(), "los elementos no son iguales");
        assertEquals("c", lista1.getElemento(1).getData(), "los elementos no son iguales");
        assertEquals("d", lista1.getElemento(2).getData(), "los elementos no son iguales");
        assertEquals("a", lista1.getElemento(3).getData(), "los elementos no son iguales");
        assertEquals("primer elemento", lista1.getElemento(4).getData(), "los elementos no son iguales");
    }


}