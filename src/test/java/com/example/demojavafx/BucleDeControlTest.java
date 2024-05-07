package com.example.demojavafx;

import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.matriz.Matriz;
import com.example.demojavafx.recursos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucleDeControlTest {

    @Test
    void getColumna() {
        int columna = 3;
        int fila = 2;
        int newcolumna = 5;
        BucleDeControl b = new BucleDeControl(fila,columna);
        assertDoesNotThrow(()->b.setColumna(newcolumna));
        assertEquals(5, b.getColumna());
    }

    @Test
    void setColumna() {
        int columna = 3;
        int fila = 2;
        int newcolumna = 5;
        BucleDeControl b = new BucleDeControl(fila,columna);
        assertDoesNotThrow(()->b.setColumna(newcolumna));

    }

    @Test
    void getFila() {
        int columna = 3;
        int fila = 2;
        int newfila = 5;
        BucleDeControl b = new BucleDeControl(fila,columna);
        assertDoesNotThrow(()->b.setFila(newfila));
        assertEquals(5, b.getFila());
    }

    @Test
    void setFila() {
        int columna = 3;
        int fila = 2;
        int newfila = 5;
        BucleDeControl b = new BucleDeControl(fila,columna);
        assertDoesNotThrow(()->b.setFila(newfila));
    }

    @Test
    void actualizarIndividuo() throws Superar3Individuos {
        int columna = 3;
        int fila = 2;
        BucleDeControl matriz = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,1);
        ind1.setProbReproduccion(90);
        ind1.setProbClonacion(45);
        ind2.setProbReproduccion(87);
        ind2.setProbClonacion(34);
        ind3.setProbReproduccion(76);
        ind3.setProbClonacion(21);
        matriz.matriz[1][1].addIndividuo(ind3);
        matriz.matriz[0][0].addIndividuo(ind1);
        matriz.matriz[0][2].addIndividuo(ind2);
        matriz.actualizarIndividuo();
        assertEquals(5, ind1.getTurnosRestantes(), "Los turnos restantes no son iguales");
        assertEquals(6, ind2.getTurnosRestantes(), "Los turnos restantes no son iguales");
        assertEquals(0, ind3.getTurnosRestantes(), "Los turnos restantes no son iguales");
        assertEquals(80, ind1.getProbReproduccion());
        assertEquals(35, ind1.getProbClonacion());
        assertEquals(77, ind2.getProbReproduccion());
        assertEquals(24, ind2.getProbClonacion());
        assertEquals(66, ind3.getProbReproduccion());
        assertEquals(11, ind3.getProbClonacion());
    }

    @Test
    void actualizarRecursos() throws Superar3Recursos {
        int columna = 3;
        int fila = 2;
        BucleDeControl matriz = new BucleDeControl(fila,columna);
        Agua agua = new Agua(3,4);
        Montana montana = new Montana(4,5);
        matriz.matriz[0][2].addRecurso(agua);
        matriz.matriz[1][0].addRecurso(montana);
        matriz.actualizarRecursos();
        assertEquals(2, agua.getTurnosRestantes());
        assertEquals(3, montana.getTurnosRestantes());
    }

    @Test
    void movimiento() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 2;
        BucleDeControl matriz = new BucleDeControl(fila,columna);
        IndAvanzado ind1 = new IndAvanzado(222,4,6,"montaña");
        IndAvanzado ind2 = new IndAvanzado(333,6,7,"agua");
        IndAvanzado ind3 = new IndAvanzado(444, 9,1,"pozo");
        Agua agua = new Agua(3,4);
        Comida comida = new Comida(2,3);
        Montana montana = new Montana(4,5);
        Biblioteca biblioteca = new Biblioteca(3,45);
        Tesoro tesoro = new Tesoro(3,32);
        Pozo pozo = new Pozo(6);
        matriz.matriz[0][2].addRecurso(agua);
        matriz.matriz[0][2].addRecurso(tesoro);
        matriz.matriz[0][2].addRecurso(biblioteca);
        matriz.matriz[1][0].addRecurso(comida);
        matriz.matriz[1][2].addRecurso(montana);
        matriz.matriz[1][1].addRecurso(pozo);
        matriz.matriz[0][2].addIndividuo(ind1);
        matriz.matriz[1][0].addIndividuo(ind2);
        matriz.matriz[1][2].addIndividuo(ind3);
        ind1.setPosN(0);
        ind1.setPosM(2);
        ind2.setPosN(1);
        ind2.setPosM(0);
        ind3.setPosN(1);
        ind3.setPosM(2);
        agua.setPosN(0);
        agua.setPosM(2);
        tesoro.setPosN(0);
        tesoro.setPosM(2);
        biblioteca.setPosN(0);
        biblioteca.setPosM(2);
        comida.setPosN(1);
        comida.setPosM(0);
        montana.setPosN(1);
        montana.setPosM(2);
        pozo.setPosN(1);
        pozo.setPosM(1);
        assertDoesNotThrow(()->matriz.movimiento());
    }

    @Test
    void mejorasRecursos() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 2;
        BucleDeControl matriz = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,9);
        IndAvanzado ind4 = new IndAvanzado(444, 9,9);
        Agua agua = new Agua(3,4);
        Comida comida = new Comida(2,3);
        Montana montana = new Montana(4,5);
        Biblioteca biblioteca = new Biblioteca(3,45);
        Tesoro tesoro = new Tesoro(3,32);
        Pozo pozo = new Pozo(6);
        matriz.matriz[0][2].addRecurso(agua);
        matriz.matriz[0][2].addRecurso(tesoro);
        matriz.matriz[0][2].addRecurso(biblioteca);
        matriz.matriz[1][0].addRecurso(comida);
        matriz.matriz[1][2].addRecurso(montana);
        matriz.matriz[1][1].addRecurso(pozo);
        matriz.matriz[0][2].addIndividuo(ind1);
        matriz.matriz[1][0].addIndividuo(ind2);
        matriz.matriz[1][2].addIndividuo(ind3);
        matriz.matriz[1][1].addIndividuo(ind4);
        matriz.mejorasRecursos();
        assertEquals(10, ind1.getTurnosRestantes());
        assertEquals(45, ind1.getProbClonacion());
        assertEquals(32, ind1.getProbReproduccion());
        assertEquals(10, ind2.getTurnosRestantes());
        assertEquals(4, ind3.getTurnosRestantes());
        assertNull(matriz.matriz[1][1].getListaIndividuo().getElemento(0));
    }

    @Test
    void reproducion() throws Superar3Individuos {
        int columna = 3;
        int fila = 3;
        BucleDeControl matriz = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,1);
        IndBasico ind4 = new IndBasico(555,4,6);
        IndNormal ind5 = new IndNormal(666,6,7);
        IndNormal ind6 = new IndNormal(777,6,7);
        ind1.setProbReproduccion(65);
        ind2.setProbReproduccion(67);
        ind3.setProbReproduccion(72);
        ind4.setProbReproduccion(89);
        ind5.setProbReproduccion(92);
        ind6.setProbReproduccion(75);
        matriz.matriz[0][2].addIndividuo(ind1);
        matriz.matriz[1][0].addIndividuo(ind2);
        matriz.matriz[1][2].addIndividuo(ind3);
        matriz.matriz[0][2].addIndividuo(ind4);
        matriz.matriz[1][0].addIndividuo(ind5);
        matriz.matriz[1][2].addIndividuo(ind6);
        assertDoesNotThrow(()->matriz.reproducion());
    }

    @Test
    void clonacion() throws Superar3Individuos {
        int columna = 3;
        int fila = 2;

        BucleDeControl matriz = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,1);
        ind1.setProbClonacion(89);
        ind2.setProbClonacion(90);
        ind3.setProbClonacion(70);
        matriz.matriz[0][2].addIndividuo(ind1);
        matriz.matriz[1][0].addIndividuo(ind2);
        matriz.matriz[1][2].addIndividuo(ind3);
        assertDoesNotThrow(()->matriz.clonacion());
    }

    @Test
    void nuevoRecurso() throws Superar3Recursos {
        int columna = 8;
        int fila = 5;

        BucleDeControl b = new BucleDeControl(fila,columna);
        Agua agua = new Agua(3,4);
        Comida comida = new Comida(2,3);
        Montana montana = new Montana(4,5);
        Biblioteca biblioteca = new Biblioteca(3,45);
        Tesoro tesoro = new Tesoro(3,32);
        Pozo pozo = new Pozo(6);
        b.matriz[0][2].addRecurso(agua);
        b.matriz[0][2].addRecurso(tesoro);
        b.matriz[0][2].addRecurso(biblioteca);
        b.matriz[1][0].addRecurso(comida);
        b.matriz[1][2].addRecurso(montana);
        b.matriz[1][1].addRecurso(pozo);
        assertDoesNotThrow(()->b.nuevoRecurso());
    }

    @Test
    void condicionFinalizacion() throws Superar3Individuos {
        int columna = 3;
        int fila = 2;

        BucleDeControl b = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,1);
        b.matriz[0][2].addIndividuo(ind1);
        b.matriz[1][0].addIndividuo(ind2);
        b.matriz[1][2].addIndividuo(ind3);
        assertFalse(b.condicionFinalizacion());

        int columna2 = 8;
        int fila2 = 4;

        BucleDeControl b1 = new BucleDeControl(fila2,columna2);
        IndBasico ind4 = new IndBasico(222,4,6);
        b1.matriz[0][2].addIndividuo(ind4);
        assertTrue(b1.condicionFinalizacion());
    }

    @Test
    void bucleEntero() throws Superar3Recursos, Superar3Individuos {
        int columna = 3;
        int fila = 2;
        BucleDeControl b = new BucleDeControl(fila,columna);
        IndBasico ind1 = new IndBasico(222,0,6);
        IndNormal ind2 = new IndNormal(333,0,7);
        IndAvanzado ind3 = new IndAvanzado(444, 0,9);
        IndAvanzado ind4 = new IndAvanzado(444, 0,9);
        Agua agua = new Agua(3,4);
        Comida comida = new Comida(2,3);
        Montana montana = new Montana(4,5);
        Biblioteca biblioteca = new Biblioteca(3,45);
        Tesoro tesoro = new Tesoro(3,32);
        Pozo pozo = new Pozo(6);
        b.matriz[0][2].addRecurso(agua);
        b.matriz[0][2].addRecurso(tesoro);
        b.matriz[0][2].addRecurso(biblioteca);
        b.matriz[1][0].addRecurso(comida);
        b.matriz[1][2].addRecurso(montana);
        b.matriz[1][1].addRecurso(pozo);
        b.matriz[0][2].addIndividuo(ind1);
        b.matriz[1][0].addIndividuo(ind2);
        b.matriz[1][2].addIndividuo(ind3);
        b.matriz[1][1].addIndividuo(ind4);
        assertDoesNotThrow(()->b.bucleEntero());
    }
}