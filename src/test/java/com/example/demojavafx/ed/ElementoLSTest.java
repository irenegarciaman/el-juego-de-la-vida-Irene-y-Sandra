package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoLSTest {

    @Test
    void getData() {
        ElementoLS d= new ElementoLS(89);
        assertDoesNotThrow(()->d.getData());
    }

    @Test
    void setData() {
        Object newDato = "nuevo";
        ElementoLS e= new ElementoLS(67);
        assertDoesNotThrow(()->e.setData(newDato));
        assertEquals(newDato,e.getData());
    }
}