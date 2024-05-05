package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColaTest {

    @Test
    void isVacia() {
        Cola c = new Cola();
        assertTrue(c.isVacia());
        ElementoLDE d = new ElementoLDE<>("er");
        Cola v = new Cola(d,d);
        assertFalse(v.isVacia());
    }

    @Test
    void push() {
        Cola c = new Cola();
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        c.push(d);
        c.push(r);
        c.push(t);
        assertEquals(3,c.getNumeroElementos());
    }

    @Test
    void pop() {
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        Cola c = new Cola();
        c.push(d);
        c.push(r);
        c.push(t);
        assertEquals(3, c.getNumeroElementos());
        assertEquals(d.getData(),c.pop().getData());
        assertEquals(r.getData(),c.pop().getData());
        assertEquals(t.getData(),c.pop().getData());
        c.pop();
    }
    @Test
    void getPosicion(){
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        Cola c = new Cola();
        c.push(d);
        c.push(r);
        c.push(t);
        assertEquals(0, c.getPosicion(d));
        assertEquals(1, c.getPosicion(r));
        assertEquals(2, c.getPosicion(t));
    }

    @Test
    void getElemento(){
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        Cola c = new Cola();
        c.push(d);
        c.push(r);
        c.push(t);
        assertEquals(r.getData(),c.getElemento(1).getData());
    }
    @Test
    void machacar(){
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        ElementoLDE m = new ElementoLDE<>("jj");
        Cola c = new Cola();
        c.push(d);
        c.push(r);
        c.push(t);
        c.machacar(m,1);
        assertEquals(3, c.getNumeroElementos());
        assertEquals(0, c.getPosicion(d));
        assertEquals(1, c.getPosicion(m));
        assertEquals(2, c.getPosicion(r));

    }


    @Test
    void pop2(){
        ElementoLDE d = new ElementoLDE<>("er");
        ElementoLDE r = new ElementoLDE<>("po");
        ElementoLDE t = new ElementoLDE<>("uy");
        ElementoLDE m = new ElementoLDE<>("jj");
        Cola c = new Cola();
        c.push(d);
        c.push(r);
        c.push(t);
        c.pop2(t);
        assertEquals(3, c.getNumeroElementos());
        assertEquals(0, c.getPosicion(d));
        assertEquals(1, c.getPosicion(r));


    }

}