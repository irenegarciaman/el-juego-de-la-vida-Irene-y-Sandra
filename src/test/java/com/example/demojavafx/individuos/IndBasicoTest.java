package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.ed.Cola;
import com.example.demojavafx.ed.NodoArbol;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.recursos.Agua;
import com.example.demojavafx.recursos.Recursos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndBasicoTest {

    @Test
    void moverse() throws Superar3Individuos, Superar3Recursos {
        int columna = 3;
        int fila = 3;

        BucleDeControl matriz1 = new BucleDeControl(fila, columna);
        IndBasico ind1 = new IndBasico(555);
        IndBasico ind2 = new IndBasico(3,3,3);
        IndBasico ind3 = new IndBasico(6,6,6,6,6,6);
        IndBasico ind4 = new IndBasico(4,4,4,4,4,4,0,2);
        Agua recurso1 = new Agua();
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[0][0].addIndividuo(ind2);
        matriz1.matriz[1][2].addIndividuo(ind3);
        matriz1.matriz[0][2].addIndividuo(ind4);
        matriz1.matriz[0][0].addRecurso(recurso1);
        ind1.setPosN(1);
        ind1.setPosM(1);
        recurso1.setPosN(0);
        recurso1.setPosM(0);
        recurso1.setTurnosRestantes(5);

        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(1,ind1.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind2.moverse(3, 3, matriz1.matriz));
        assertEquals(1,ind2.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind3.moverse(3, 3, matriz1.matriz));
        assertEquals(1,ind3.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind4.moverse(3, 3, matriz1.matriz));
        assertEquals(1,ind4.getColaOperaciones().getNumeroElementos());



    }

    @Test
    void testToString() {
        IndBasico a = new IndBasico(333);
        ArbolBinarioDeBusqueda b = new ArbolBinarioDeBusqueda<>(new NodoArbol<>(a));
        IndBasico ind1 = new IndBasico(222, 3, 45, 34, 44, 6, 0, 0,b,new Cola<>(),0,0,0,0);

        String textoSalida = "IND BÁSICO=[ posM=0; posN=0; probMuerte=0; probClonacion=0; probReproduccion=0; turnosRestantes=0; generacion=0; id=333 ]";
        assertEquals(textoSalida, ind1.toStringArbol());
        String textoSalida2 = "IndBasico, {posM=0, posN=0, probMuerte=6, probClonacion=44, probReproduccion=34, turnosRestantes=45, generacion=3, id=222, arbolGenealogico=IND BÁSICO=[ posM=0; posN=0; probMuerte=0; probClonacion=0; probReproduccion=0; turnosRestantes=0; generacion=0; id=333 ], }";
        assertEquals(textoSalida2, ind1.toString());
    }
}