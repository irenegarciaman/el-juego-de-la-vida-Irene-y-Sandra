package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.ed.Cola;
import com.example.demojavafx.ed.ElementoLDE;
import com.example.demojavafx.ed.NodoArbol;
import com.example.demojavafx.excepciones.Superar3Individuos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {
    IndBasico individuo = new IndBasico(3);

    IndBasico individuo2 = new IndBasico(3, 3, 3);

    IndAvanzado individuo3 = new IndAvanzado(3, 3, 3,
            4, 5, 6);

    IndAvanzado individuo4 = new IndAvanzado(3, 3, 3,
            4, 5, 6, 7, 7);

    ArbolBinarioDeBusqueda a = new ArbolBinarioDeBusqueda<>(33);
    Cola c = new Cola<>(new ElementoLDE<>(3),new ElementoLDE<>(6));

    IndNormal indNormal = new IndNormal(2,2,2,2,2,2,2,2,a,c,0,0,0,0);
    @Test
    void getId() {
        assertEquals(3, individuo.getId());
    }

    @Test
    void setId() {
        individuo.setId(5);
        assertEquals(5, individuo.getId());
    }

    @Test
    void getGeneracion() {
        assertEquals(3, individuo3.getGeneracion());
    }

    @Test
    void setGeneracion() {
        individuo3.setGeneracion(5);
        assertEquals(5, individuo3.getGeneracion());
    }

    @Test
    void getTurnosRestantes() {
        assertEquals(3, individuo2.getTurnosRestantes());

    }

    @Test
    void setTurnosRestantes() {
        individuo2.setTurnosRestantes(4);
        assertEquals(4, individuo2.getTurnosRestantes());
    }

    @Test
    void getProbReproduccion() {
        assertEquals(4, individuo4.getProbReproduccion());
    }

    @Test
    void setProbReproduccion() {
        individuo4.setProbReproduccion(1);
        assertEquals(1, individuo4.getProbReproduccion());
        individuo4.setProbReproduccion(109);
        assertEquals(100, individuo4.getProbReproduccion());
        individuo4.setProbReproduccion(-1);
        assertEquals(0, individuo4.getProbReproduccion());
    }

    @Test
    void getProbClonacion() {
        assertEquals(5, individuo4.getProbClonacion());
    }

    @Test
    void setProbClonacion() {
        individuo4.setProbClonacion(4);
        assertEquals(4, individuo4.getProbClonacion());
        individuo4.setProbClonacion(904);
        assertEquals(100, individuo4.getProbClonacion());
        individuo4.setProbClonacion(-4);
        assertEquals(0, individuo4.getProbClonacion());
    }

    @Test
    void getProbMuerte() {
        assertEquals(6, individuo4.getProbMuerte());
    }

    @Test
    void setProbMuerte() {
        individuo4.setProbMuerte(3);
        assertEquals(3, individuo4.getProbMuerte());
    }

    @Test
    void getPosM() {
        assertEquals(7, individuo4.getPosM());
    }

    @Test
    void setPosM() {
        individuo4.setPosM(3);
        assertEquals(3, individuo4.getPosM());
    }

    @Test
    void getPosN() {
        assertEquals(7, individuo4.getPosN());
    }

    @Test
    void setPosN() {
        individuo4.setPosN(3);
        assertEquals(3, individuo4.getPosN());
    }

    @Test
    void testToString() {
        assertEquals("IndBasico, {posM=0, posN=0, probMuerte=0, probClonacion=0, probReproduccion=0, turnosRestantes=3, generacion=3, id=3, arbolGenealogico=IND BÁSICO=[ posM=0; posN=0; probMuerte=0; probClonacion=0; probReproduccion=0; turnosRestantes=3; generacion=3; id=3 ], }", individuo2.toString());
    }

    @Test
    void getContadorReproducciones() {
        assertEquals(0, indNormal.getContadorReproduccion());
    }

    @Test
    void setContadorReproducciones() {
        indNormal.setContadorReproduccion(3);
        assertEquals(3, indNormal.getContadorReproduccion());
    }

    @Test
    void getContadorClonaciones() {
        assertEquals(0, indNormal.getContadorClonacion());
    }

    @Test
    void setContadorClonaciones() {
        indNormal.setContadorClonacion(3);
        assertEquals(3, indNormal.getContadorClonacion());
    }

    @Test
    void getContadorAgua() {
        assertEquals(0, indNormal.getContadorAgua());
    }

    @Test
    void setContadorAgua() {
        indNormal.setContadorAgua(3);
        assertEquals(3, indNormal.getContadorAgua());
    }

    @Test
    void getContadorIndividuoLongevo() {
        assertEquals(0, indNormal.getContadorIndividuoLongevo());
    }

    @Test
    void setContadorIndividuoLongero() {
        indNormal.setContadorIndividuoLongevo(3);
        assertEquals(3, indNormal.getContadorIndividuoLongevo());
    }

    @Test
    void getArbolGenealogico() {
        assertEquals(a, indNormal.getArbolGenealogico());
    }

    @Test
    void setArbolGenealogico() {
        ArbolBinarioDeBusqueda c = new ArbolBinarioDeBusqueda<>();
        indNormal.setArbolGenealogico(c);
        assertEquals(c, indNormal.getArbolGenealogico());
    }

    @Test
    void getColaOperaciones() {
        assertEquals(c, indNormal.getColaOperaciones());
    }

    @Test
    void setColaOperaciones() {
        Cola d = new Cola();
        indNormal.setColaOperaciones(d);
        assertEquals(d, indNormal.getColaOperaciones());
    }



}