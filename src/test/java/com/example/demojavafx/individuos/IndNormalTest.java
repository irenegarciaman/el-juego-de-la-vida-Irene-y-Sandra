package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.ed.Cola;
import com.example.demojavafx.ed.NodoArbol;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.recursos.Agua;
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
        Recursos recursos3 = new Recursos();
        Recursos recursos4 = new Recursos();
        IndNormal ind2 = new IndNormal(3,3,3);
        IndNormal ind3 = new IndNormal(6,6,6,6,6,6);
        IndNormal ind4 = new IndNormal(4,4,4,4,4,4,0,2);
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[0][0].addIndividuo(ind2);
        matriz1.matriz[1][2].addIndividuo(ind3);
        matriz1.matriz[0][2].addIndividuo(ind4);
        matriz1.matriz[0][0].addRecurso(recurso1);
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[1][1].addRecurso(recurso1);
        matriz1.matriz[0][0].addRecurso(recurso2);
        matriz1.matriz[0][1].addRecurso(recursos3);
        matriz1.matriz[2][2].addRecurso(recursos4);
        ind1.setPosN(1);
        ind1.setPosM(1);
        ind2.setPosN(0);
        ind2.setPosM(0);
        ind3.setPosN(1);
        ind3.setPosM(2);
        ind4.setPosN(0);
        ind4.setPosM(2);
        recurso1.setPosN(1);
        recurso1.setPosM(1);
        recurso2.setPosN(0);
        recurso2.setPosM(0);
        recursos3.setPosN(0);
        recursos3.setPosM(1);
        recursos4.setPosN(2);
        recursos4.setPosM(2);
        recurso1.setTurnosRestantes(5);
        recurso2.setTurnosRestantes(5);

        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(1, ind1.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind2.moverse(3, 3, matriz1.matriz));
        assertEquals(1, ind2.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind3.moverse(3, 3, matriz1.matriz));
        assertEquals(1, ind3.getColaOperaciones().getNumeroElementos());
        assertDoesNotThrow(() -> ind4.moverse(3, 3, matriz1.matriz));
        assertEquals(1, ind4.getColaOperaciones().getNumeroElementos());


    }

    @Test
    void testToString() {
        IndNormal a = new IndNormal(333);
        ArbolBinarioDeBusqueda b = new ArbolBinarioDeBusqueda<>(new NodoArbol<>(a));
        IndNormal ind1 = new IndNormal(222, 3, 45, 34, 44, 6, 0, 0,b,new Cola<>(),0,0,0,0);

        String textoSalida = "IndNormal, {posM=0, posN=0, probMuerte=6, probClonacion=44, probReproduccion=34, turnosRestantes=45, generacion=3, id=222, arbolGenealogico=IND NORMAL=[ posM=0; posN=0; probMuerte=0; probClonacion=0; probReproduccion=0; turnosRestantes=0; generacion=0; id=333 ], }";
        assertEquals(textoSalida, ind1.toString());
        String textoSalida2 = "IND NORMAL=[ posM=0; posN=0; probMuerte=0; probClonacion=0; probReproduccion=0; turnosRestantes=0; generacion=0; id=333 ]";
        assertEquals(textoSalida2, ind1.toStringArbol());

    }
}