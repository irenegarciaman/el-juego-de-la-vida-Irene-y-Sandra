package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
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
        Recursos recurso1 = new Recursos();
        matriz1.matriz[1][1].addIndividuo(ind1);
        matriz1.matriz[1][1].addRecurso(recurso1);
        ind1.setPosN(1);
        ind1.setPosM(1);
        recurso1.setPosN(1);
        recurso1.setPosM(1);
        recurso1.setTurnosRestantes(5);

        assertDoesNotThrow(() -> ind1.moverse(3, 3, matriz1.matriz));
        assertEquals(matriz1.matriz[1][1], ind1.colaOperaciones.getElemento(0).getData());
        assertEquals(recurso1, ind1.colaOperaciones.getElemento(1).getData());


    }

    @Test
    void testToString() {
        IndBasico ind1 = new IndBasico(222, 3, 45, 34, 44, 6, 7, 2);
        ArbolBinarioDeBusqueda<Individuo> a = new ArbolBinarioDeBusqueda<>();
        ind1.setArbolGenealogico(a);
        String textoSalida = "IndBasico, {arbolGenealogico=com.example.demojavafx.ed.ArbolBinarioDeBusqueda@78ffe6dc, posM=2, posN=7, probMuerte=6, probClonacion=44, probReproduccion=34, turnosRestantes=45, generacion=3, id=222, }";
        assertEquals(textoSalida, ind1.toString());
    }
}