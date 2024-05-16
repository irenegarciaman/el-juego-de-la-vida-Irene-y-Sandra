package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void isVacia() {
        ListaSimple lista = new ListaSimple();
        assertTrue(lista.isVacia());
    }

    @Test
    void vaciar() {
        ListaSimple lista = new ListaSimple();
        lista.Vaciar();
        assertTrue(lista.isVacia());
    }

    @Test
    void testAdd() {
        ListaSimple lista1 = new ListaSimple();
        lista1.add("1");
        assertFalse(lista1.isVacia());
        ListaSimple lista2 = new ListaSimple();
        lista2.add("hola");
        assertFalse(lista2.isVacia());


    }


    @Test
    void getNumeroElementos() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        boolean bool = false;
        if (lista.getNumeroElementos() == 1) {
            bool = true;
        }
        assertTrue(bool);
        ListaSimple lista2 = new ListaSimple();
        ElementoLS a = new ElementoLS<>("a");
        assertEquals(0, lista2.getNumeroElementos());

    }

    @Test
    void getPosicion() {
        ListaSimple lista = new ListaSimple();
        ElementoLS c = new ElementoLS<>("a");
        ElementoLS b = new ElementoLS<>("fr");
        lista.add(c.getData());
        lista.add(b.getData());
        assertEquals(0, lista.getPosicion(c));
        assertEquals(1, lista.getPosicion(b));
        ElementoLS d = new ElementoLS<>("d");
        assertEquals(-1, lista.getPosicion(d));


    }

    @Test
    void getElemento() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        assertEquals("a", lista.getElemento(0).getData());
        assertEquals("b", lista.getElemento(1).getData());
        assertEquals("c", lista.getElemento(2).getData());
        assertEquals("d", lista.getElemento(3).getData());
        lista.insert("e", 2);
        assertEquals("a", lista.getElemento(0).getData());
        assertEquals("b", lista.getElemento(1).getData());
        assertEquals("e", lista.getElemento(2).getData());
        assertEquals("c", lista.getElemento(3).getData());
        assertEquals("d", lista.getElemento(4).getData());
        lista.del(4);
        assertEquals("a", lista.getElemento(0).getData());
        assertEquals("b", lista.getElemento(1).getData());
        assertEquals("e", lista.getElemento(2).getData());
        assertEquals("c", lista.getElemento(3).getData());
        lista.del(78);

        lista.insert(89, 4);
        lista.add("r");
        lista.add("s");
        lista.add("t");
        lista.add("u");
        assertEquals("a", lista.getElemento(0).getData());
        assertEquals("b", lista.getElemento(1).getData());
        assertEquals("e", lista.getElemento(2).getData());
        assertEquals("c", lista.getElemento(3).getData());
        assertEquals(89, lista.getElemento(4).getData());
        assertEquals("r", lista.getElemento(5).getData());
        assertEquals("s", lista.getElemento(6).getData());
        lista.insert("es", 6);
        lista.insert("dr", 89);

    }

    @Test
    void getSiguiente() {
        ListaSimple lista = new ListaSimple();
        ElementoLS a = new ElementoLS<>("a");
        ElementoLS b = new ElementoLS<>("b");
        lista.add(a.getData());
        lista.add(b.getData());
        assertEquals("b", lista.getSiguiente(a).getData(), "los elementos no son iguales");
    }

    @Test
    void getPrimero() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        assertEquals("a", lista.getPrimero().getData(), "los elementos no son iguales");

    }

    @Test
    void getUltimo() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        assertEquals("d", lista.getUltimo().getData(), "los elementos no son iguales");

    }

    @Test
    void del() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");
        lista.del(2);
        assertEquals(4, lista.getNumeroElementos());
        assertEquals("a", lista.getElemento(0).getData());
        assertEquals("b", lista.getElemento(1).getData());
        assertEquals("d", lista.getElemento(2).getData());
        assertEquals("e", lista.getElemento(3).getData());
    }

    @Test
    void invertir() {
        ListaSimple lista = new ListaSimple();
        lista.add("a");
        lista.add("b");
        lista.add("c");
        lista.add("d");
        lista.add("e");
        ListaSimple a = lista.invertir(lista);
        assertEquals(5, lista.getNumeroElementos());
        assertEquals("e", a.getElemento(0).getData());
        assertEquals("d", a.getElemento(1).getData());
        assertEquals("c", a.getElemento(2).getData());
        assertEquals("b", a.getElemento(3).getData());
        assertEquals("a", a.getElemento(4).getData());

    }
}