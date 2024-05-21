package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.ed.Cola;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.recursos.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndAvanzadoTest {

    @Test
    void creacionListaMovimiento() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 3;

        BucleDeControl matriz1 = new BucleDeControl(fila, columna);
        IndAvanzado ind1 = new IndAvanzado(555);
        Agua recurso1 = new Agua();
        Comida recurso2 = new Comida();
        Montana m = new Montana();
        Pozo p = new Pozo();
        Tesoro t = new Tesoro();
        Biblioteca b = new Biblioteca();
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[1][1].addRecurso(recurso1);
        matriz1.matriz[0][0].addRecurso(recurso2);
        matriz1.matriz[1][1].addRecurso(p);
        matriz1.matriz[2][1].addRecurso(m);
        matriz1.matriz[1][1].addRecurso(t);
        matriz1.matriz[0][0].addRecurso(b);
        ind1.setPosN(1);
        ind1.setPosM(1);
        recurso1.setPosN(1);
        recurso1.setPosM(1);
        recurso2.setPosN(0);
        recurso2.setPosM(0);
        recurso1.setTurnosRestantes(5);
        recurso2.setTurnosRestantes(5);

        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(2, ind1.getPosN());
        assertEquals(1, ind1.getPosM());

    }

    @Test
    void moverse() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 3;

        BucleDeControl matriz1 = new BucleDeControl(fila, columna);
        IndAvanzado ind1 = new IndAvanzado(555);
        IndAvanzado ind2 = new IndAvanzado(333,3,4);
        IndAvanzado ind3 = new IndAvanzado(2,2,2,2,2,2);
        IndAvanzado ind4 = new IndAvanzado(2,2,2,2,2,2,2,2,new ArbolBinarioDeBusqueda<>(),new Cola<>(),0,0,0,0);
        Recursos recurso1 = new Recursos();
        Recursos recurso2 = new Recursos();
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[1][1].addIndividuo(ind2);
        matriz1.matriz[1][1].addIndividuo(ind3);
        matriz1.matriz[2][2].addIndividuo(ind4);
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
        assertEquals(1, ind1.getPosN());
        assertEquals(0, ind1.getPosM());
        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(0, ind1.getPosN());
        assertEquals(0, ind1.getPosM());

    }

    @Test
    void testToString() {
        IndAvanzado ind1 = new IndAvanzado(666,7,8,9,9,9,9,9);

        String a = "IndAvanzado, {posM=9, posN=9, probMuerte=9, probClonacion=9, probReproduccion=9, turnosRestantes=8, generacion=7, id=666, arbolGenealogico=IND AVANZADO=[ posM=9; posN=9; probMuerte=9; probClonacion=9; probReproduccion=9; turnosRestantes=8; generacion=7; id=666 ], }";
        assertEquals(a,ind1.toString());


    }
}