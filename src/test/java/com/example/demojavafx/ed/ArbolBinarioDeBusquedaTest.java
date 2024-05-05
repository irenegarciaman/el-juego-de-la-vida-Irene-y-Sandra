package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {
    NodoArbol<Integer> uno = new NodoArbol<>(1);
    NodoArbol<Integer> dos = new NodoArbol<>(2);
    NodoArbol<Integer> tres = new NodoArbol<>(3);
    NodoArbol<Integer> cuatro = new NodoArbol<>(4);
    NodoArbol<Integer> cinco = new NodoArbol<>(5);
    ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>(dos);
    ArbolBinarioDeBusqueda<Integer> arbol1 = new ArbolBinarioDeBusqueda<>(cinco);
    NodoArbol<String> e = new NodoArbol<>("e");
    ArbolBinarioDeBusqueda<String> arbol2 = new ArbolBinarioDeBusqueda<>(e);
    @Test
    void isVacia() {
        ArbolBinarioDeBusqueda<Integer> arbolNulo = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbolNulo.isVacia());
        arbolNulo.add(5);
        arbolNulo.preorden();

    }

    @Test
    void add() {
        arbol.add(1,arbol.raiz);
        arbol.add(3,arbol.raiz);
        arbol.add(4,arbol.raiz);
        assertEquals(2,arbol.getCamino(uno).getPrimero().getData());
        assertEquals(1,arbol.getCamino(uno).getUltimo().getData());
        assertEquals(2,arbol.getCamino(tres).getPrimero().getData());
        assertEquals(3,arbol.getCamino(tres).getUltimo().getData());
        assertEquals(4,arbol.getCamino(cuatro).getUltimo().getData());
    }

    @Test
    void getGrado() {
        arbol.add(1,arbol.raiz);
        assertEquals(1,arbol.getGrado(dos,0));
        arbol.add(3,arbol.raiz);
        arbol.add(4,arbol.raiz);
        assertEquals(2,arbol.getGrado(dos,0));
    }

    @Test
    void getCamino() {
        arbol.add(1,arbol.raiz);
        arbol.add(3,arbol.raiz);
        arbol.add(4,arbol.raiz);
        assertEquals(2,arbol.getCamino(uno).getPrimero().getData());
        assertEquals(1,arbol.getCamino(uno).getUltimo().getData());
        assertEquals(2,arbol.getCamino(tres).getPrimero().getData());
        assertEquals(3,arbol.getCamino(tres).getUltimo().getData());
        assertEquals(4,arbol.getCamino(cuatro).getUltimo().getData());
        assertEquals(3,arbol.getCamino(cuatro).getNumeroElementos());
        arbol1.add(7,cinco);
        arbol1.add(3,cinco);
        arbol1.add(2,cinco);
        arbol1.add(4,cinco);
        arbol1.add(8,cinco);
        arbol1.add(6,cinco);
        System.out.println(arbol1.getCamino(dos).getNumeroElementos());
        System.out.println(arbol1.getCamino(dos).getPrimero().getData());
        System.out.println(arbol1.getCamino(dos).getUltimo().getData());

    }

    @Test
    void getSubArbolDcha() {
        arbol1.add(7,cinco);
        arbol1.add(3,cinco);
        arbol1.add(2,cinco);
        arbol1.add(4,cinco);
        arbol1.add(8,cinco);
        arbol1.add(6,cinco);
        ListaEnlazada<Integer> lista = arbol1.getSubArbolDcha().preorden();
        assertEquals(7,lista.getElemento(0).getData());
        assertEquals(6,lista.getElemento(1).getData());
        assertEquals(8,lista.getElemento(2).getData());
    }

    @Test
    void getSubArbolIzq() {
        arbol1.add(7,cinco);
        arbol1.add(3,cinco);
        arbol1.add(2,cinco);
        arbol1.add(4,cinco);
        arbol1.add(8,cinco);
        arbol1.add(6,cinco);
        ListaEnlazada<Integer> lista = arbol1.getSubArbolIzq().preorden();
        assertEquals(3,lista.getElemento(0).getData());
        assertEquals(2,lista.getElemento(1).getData());
        assertEquals(4,lista.getElemento(2).getData());
    }

    @Test
    void preorden() {
        arbol1.add(7,cinco);
        arbol1.add(3,cinco);
        arbol1.add(2,cinco);
        arbol1.add(4,cinco);
        arbol1.add(8,cinco);
        arbol1.add(6,cinco);
        ListaEnlazada<Integer> lista = arbol1.preorden();
        assertEquals(5,lista.getElemento(0).getData());
        assertEquals(3,lista.getElemento(1).getData());
        assertEquals(2,lista.getElemento(2).getData());
        assertEquals(4,lista.getElemento(3).getData());
        assertEquals(7,lista.getElemento(4).getData());
        assertEquals(6,lista.getElemento(5).getData());
        assertEquals(8,lista.getElemento(6).getData());
         }

    @Test
    void ordenCentral() {
        arbol1.add(7,cinco);
        arbol1.add(3,cinco);
        arbol1.add(2,cinco);
        arbol1.add(4,cinco);
        arbol1.add(8,cinco);
        arbol1.add(6,cinco);
        ListaEnlazada<Integer> lista1 = arbol1.ordenCentral();
        assertEquals(2,lista1.getElemento(0).getData());
        assertEquals(3,lista1.getElemento(1).getData());
        assertEquals(4,lista1.getElemento(2).getData());
        assertEquals(5,lista1.getElemento(3).getData());
        assertEquals(6,lista1.getElemento(4).getData());
        assertEquals(7,lista1.getElemento(5).getData());
        assertEquals(8,lista1.getElemento(6).getData());
    }

    @Test
    void postOrder() {
        arbol2.add("g");
        arbol2.add("c");
        arbol2.add("b");
        arbol2.add("d");
        arbol2.add("h");
        arbol2.add("f");
        ListaEnlazada<String> lista = arbol2.postOrder();
        assertEquals("b",lista.getElemento(0).getData());
        assertEquals("d",lista.getElemento(1).getData());
        assertEquals("c",lista.getElemento(2).getData());
        assertEquals("f",lista.getElemento(3).getData());
        assertEquals("h",lista.getElemento(4).getData());
        assertEquals("g",lista.getElemento(5).getData());
        assertEquals("e",lista.getElemento(6).getData());
    }

    @Test
    void getAltura() {
        arbol1.add(7);
        arbol1.add(3);
        arbol1.add(2);
        assertEquals(3,arbol1.getAltura());
        arbol1.add(4);
        arbol1.add(8);
        arbol1.add(6);
        assertEquals(3,arbol1.getAltura());
        ArbolBinarioDeBusqueda <Integer> a1 = new ArbolBinarioDeBusqueda<>();
        a1.add(7);
        a1.add(8);
        a1.add(6);

        assertEquals(2,a1.getAltura());

    }

    @Test
    void isArbolHomogeneo(){
        arbol1.add(7);
        arbol1.add(3);
        arbol1.add(2);
        arbol1.add(4);
        arbol1.add(8);
        assertFalse(arbol1.isArbolHomogeneo());
        arbol1.add(6);
        assertTrue(arbol1.isArbolHomogeneo());

    }

    @Test
    void isArbolCompleto() {
        arbol1.add(7);
        arbol1.add(3);
        arbol1.add(2);
        arbol1.add(4);
        assertFalse(arbol1.isArbolCompleto());
        arbol1.add(8);
        arbol1.add(6);
        assertTrue(arbol1.isArbolCompleto());
    }

    @Test
    void getListaDatosNivel() {
        arbol1.add(7);
        arbol1.add(3);
        arbol1.add(2);
        arbol1.add(4);
        arbol1.add(8);
        arbol1.add(6);
        assertEquals(3,arbol1.getListaDatosNivel(2).getElemento(0).getData());
        assertEquals(7,arbol1.getListaDatosNivel(2).getElemento(1).getData());
        assertEquals(2,arbol1.getListaDatosNivel(3).getElemento(0).getData());
        assertEquals(4,arbol1.getListaDatosNivel(3).getElemento(1).getData());
        assertEquals(6,arbol1.getListaDatosNivel(3).getElemento(2).getData());
        assertEquals(8,arbol1.getListaDatosNivel(3).getElemento(3).getData());
    }

    @Test
    void isArbolCasiCompleto() {
        arbol1.add(7);
        arbol1.add(3);
        assertFalse(arbol1.isArbolCasiCompleto());
        arbol1.add(2);
        arbol1.add(4);
        assertTrue(arbol1.isArbolCasiCompleto());
        arbol1.add(8);
        arbol1.add(6);
    }

    @Test
    void getLongitud(){
        NodoArbol<Integer> n1 = new NodoArbol<>(7);
        NodoArbol<Integer> n2 = new NodoArbol<>(3);
        NodoArbol<Integer> n3 = new NodoArbol<>(6);
        ArbolBinarioDeBusqueda<Integer> arbol3 = new ArbolBinarioDeBusqueda<>(cinco,n1,n2);
        arbol3.add(2);
        arbol3.add(4);
        arbol3.add(8);
        arbol3.add(6);
        assertEquals(2,arbol3.getLongitud(n3));
        assertEquals(1,arbol3.getLongitud(n2));
        assertEquals(0,arbol3.getLongitud(cinco));
        ArbolBinarioDeBusqueda<Integer> a = new ArbolBinarioDeBusqueda<>(2);
        assertTrue(a.isArbolCompleto());
    }
    @Test
    void eliminado(){
        NodoArbol<Integer> n1 = new NodoArbol<>(10);

        ArbolBinarioDeBusqueda<Integer> a1 = new ArbolBinarioDeBusqueda<>();
        a1.add(10);
        a1.add(5);
        a1.add(3);
        a1.add(1);
        a1.add(4);
        a1.add(30);
        a1.add(20);
        a1.add(15);
        a1.add(25);

        a1.eliminar(5);
        ListaEnlazada<Integer> lista = a1.preorden();
        assertEquals(10,lista.getElemento(0).getData());
        assertEquals(3,lista.getElemento(1).getData());
        assertEquals(1,lista.getElemento(2).getData());
        assertEquals(4,lista.getElemento(3).getData());
        assertEquals(30,lista.getElemento(4).getData());
        assertEquals(20,lista.getElemento(5).getData());
        assertEquals(15,lista.getElemento(6).getData());
        assertEquals(25,lista.getElemento(7).getData());

        a1.eliminar(15);
        ListaEnlazada<Integer> lista2 = a1.preorden();
        assertEquals(10,lista2.getElemento(0).getData());
        assertEquals(3,lista2.getElemento(1).getData());
        assertEquals(1,lista2.getElemento(2).getData());
        assertEquals(4,lista2.getElemento(3).getData());
        assertEquals(30,lista2.getElemento(4).getData());
        assertEquals(20,lista2.getElemento(5).getData());
        assertEquals(25,lista2.getElemento(6).getData());

        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(5);
        arbol.add(7);
        arbol.add(3);
        arbol.add(4);
        arbol.add(2);
        arbol.add(8);
        arbol.add(6);
        arbol.eliminar(5);
        ListaEnlazada<Integer> lista3 = arbol.preorden();
        assertEquals(6,lista3.getElemento(0).getData());
        assertEquals(3,lista3.getElemento(1).getData());
        assertEquals(2,lista3.getElemento(2).getData());
        assertEquals(4,lista3.getElemento(3).getData());
        assertEquals(7,lista3.getElemento(4).getData());
        assertEquals(8,lista3.getElemento(5).getData());

        ArbolBinarioDeBusqueda<Integer> a = new ArbolBinarioDeBusqueda<>();
        a.add(30);
        a.add(20);
        a.add(40);
        a.add(10);
        a.add(26);
        a.add(24);
        a.add(25);
        a.add(27);
        a.eliminar(20);
        ListaEnlazada<Integer> lista5 = a.preorden();
        assertEquals(30,lista5.getElemento(0).getData());
        assertEquals(24,lista5.getElemento(1).getData());
        assertEquals(10,lista5.getElemento(2).getData());
        assertEquals(26,lista5.getElemento(3).getData());
        assertEquals(25,lista5.getElemento(4).getData());
        assertEquals(27,lista5.getElemento(5).getData());
        assertEquals(40,lista5.getElemento(6).getData());

        a.add(38);
        a.eliminar(40);
        ListaEnlazada<Integer> lista4 = a.preorden();
        assertEquals(30,lista4.getElemento(0).getData());
        assertEquals(24,lista4.getElemento(1).getData());
        assertEquals(10,lista4.getElemento(2).getData());
        assertEquals(26,lista4.getElemento(3).getData());
        assertEquals(25,lista4.getElemento(4).getData());
        assertEquals(27,lista4.getElemento(5).getData());
        assertEquals(38,lista4.getElemento(6).getData());
//
    }
}