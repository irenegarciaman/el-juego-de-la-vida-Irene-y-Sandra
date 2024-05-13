package com.example.demojavafx.ed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoNuevoTest {

    @Test
    void addNodo() {
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);

        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        assertEquals(n1, lv.getElemento(0).getData());
        assertEquals(n2, lv.getElemento(1).getData());
    }

    @Test
    void addArco() {
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);


        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        ArcoGrafoNuevo<String> a1 = new ArcoGrafoNuevo<>("d",n2,n1,4.0);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        g.addArco(a1);
        assertEquals(a1, n1.listaEntrada.getElemento(0).getData());
        assertEquals(a1, n2.listaSalida.getElemento(0).getData());
        assertEquals(n1, lv.getElemento(0).getData());
        assertEquals(n2, lv.getElemento(1).getData());
        assertEquals(a1, la.getElemento(0).getData());
    }

    @Test
    void borrarArco() {
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);
        ElementoLS<Integer> e3 = new ElementoLS<>(3);


        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        NodoGrafoNuevo<ElementoLS<Integer>> n3 = new NodoGrafoNuevo<>(e3);
        ArcoGrafoNuevo<String> a1 = new ArcoGrafoNuevo<>("d",n2,n1,4.0);
        ArcoGrafoNuevo<String> a2 = new ArcoGrafoNuevo<>("nuevo",n3,n1,5.0);
        ArcoGrafoNuevo<String> a3 = new ArcoGrafoNuevo<>("nuevoço",n2,n1,58.0);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        g.addNodo(n3);
        g.addArco(a1);
        g.addArco(a2);
        assertEquals(a1, n1.listaEntrada.getElemento(0).getData());
        assertEquals(a2, n1.listaEntrada.getElemento(1).getData());
        assertEquals(a1, n2.listaSalida.getElemento(0).getData());
        assertEquals(a2, n3.listaSalida.getElemento(0).getData());
        assertEquals(n1, lv.getElemento(0).getData());
        assertEquals(n2, lv.getElemento(1).getData());
        assertEquals(n3, lv.getElemento(2).getData());
        assertEquals(a1, la.getElemento(0).getData());
        assertEquals(a2, la.getElemento(1).getData());


    }
    @Test
    void borrarNodo(){
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);
        ElementoLS<Integer> e3 = new ElementoLS<>(3);


        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        NodoGrafoNuevo<ElementoLS<Integer>> n3 = new NodoGrafoNuevo<>(e3);
        ArcoGrafoNuevo<String> a1 = new ArcoGrafoNuevo<>("d",n2,n1,4.0);
        ArcoGrafoNuevo<String> a2 = new ArcoGrafoNuevo<>("nuevo",n3,n1,5.0);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        g.addNodo(n3);
        g.addArco(a1);
        g.addArco(a2);
        assertEquals(a1, n1.listaEntrada.getElemento(0).getData());
        assertEquals(a2, n1.listaEntrada.getElemento(1).getData());
        assertEquals(a1, n2.listaSalida.getElemento(0).getData());
        assertEquals(a2, n3.listaSalida.getElemento(0).getData());
        assertEquals(n1, lv.getElemento(0).getData());
        assertEquals(n2, lv.getElemento(1).getData());
        assertEquals(n3, lv.getElemento(2).getData());
        assertEquals(a1, la.getElemento(0).getData());
        assertEquals(a2, la.getElemento(1).getData());

        g.borrarArco(a1);
        g.borrarNodo(n2);
        assertEquals(a2, n1.listaEntrada.getElemento(0).getData());
        assertEquals(a2, n3.listaSalida.getElemento(0).getData());
        assertEquals(n1, lv.getElemento(0).getData());
        assertEquals(n3, lv.getElemento(1).getData());
        assertEquals(a2, la.getElemento(0).getData());
        g.addNodo(n1);
    }

    @Test
    void recuperarNodo(){
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);
        ElementoLS<Integer> e3 = new ElementoLS<>(3);
        ElementoLS<Integer> e4 = new ElementoLS<>(4);


        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        NodoGrafoNuevo<ElementoLS<Integer>> n3 = new NodoGrafoNuevo<>(e3);
        NodoGrafoNuevo<ElementoLS<Integer>> n4 = new NodoGrafoNuevo<>(e4);
        ArcoGrafoNuevo<String> a1 = new ArcoGrafoNuevo<>("d",n2,n1,4.0);
        ArcoGrafoNuevo<String> a2 = new ArcoGrafoNuevo<>("nuevo",n3,n1,5.0);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        g.addNodo(n3);
        g.addArco(a1);
        g.addArco(a2);
        assertTrue(g.recuperarNodo(n1));
        assertFalse(g.recuperarNodo(n4));

    }

    @Test
    void recuperarArco(){
        ElementoLS<Integer> e5 = new ElementoLS<>(5);
        ElementoLS<Integer> e6 = new ElementoLS<>(6);
        ElementoLS<Integer> e3 = new ElementoLS<>(3);


        NodoGrafoNuevo<ElementoLS<Integer>> n1 = new NodoGrafoNuevo<>(e5);
        NodoGrafoNuevo<ElementoLS<Integer>> n2 = new NodoGrafoNuevo<>(e6);
        NodoGrafoNuevo<ElementoLS<Integer>> n3 = new NodoGrafoNuevo<>(e3);
        ArcoGrafoNuevo<String> a1 = new ArcoGrafoNuevo<>("d",n2,n1,4.0);
        ArcoGrafoNuevo<String> a2 = new ArcoGrafoNuevo<>("nuevo",n3,n1,5.0);
        ArcoGrafoNuevo<String> a3 = new ArcoGrafoNuevo<>("nuevoço",n2,n1,58.0);
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();

        GrafoNuevo g = new GrafoNuevo(lv,la);
        g.addNodo(n1);
        g.addNodo(n2);
        g.addNodo(n3);
        g.addArco(a1);
        g.addArco(a2);
        assertTrue(g.recuperarArco(a1));
        assertFalse(g.recuperarArco(a3));

    }
   /** @Test
    void dikjstra(){
        ListaSimple<NodoGrafoNuevo> lv = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> la = new ListaSimple<>();
        GrafoNuevo<String> graph = new GrafoNuevo<>(lv,la);
        NodoGrafoNuevo<String> v1 = new NodoGrafoNuevo<>("A");
        NodoGrafoNuevo<String> v2 = new NodoGrafoNuevo<>("B");
        NodoGrafoNuevo<String> v3 = new NodoGrafoNuevo<>("C");
        NodoGrafoNuevo<String> v4 = new NodoGrafoNuevo<>("D");
        NodoGrafoNuevo<String> v5 = new NodoGrafoNuevo<>("E");
        NodoGrafoNuevo<String> v6 = new NodoGrafoNuevo<>("F");
        NodoGrafoNuevo<String> v7 = new NodoGrafoNuevo<>("G");
        NodoGrafoNuevo<String> v8 = new NodoGrafoNuevo<>("H");

        graph.addNodo(v1);
        graph.addNodo(v2);
        graph.addNodo(v3);
        graph.addNodo(v4);
        graph.addNodo(v5);
        graph.addNodo(v6);
        graph.addNodo(v7);
        graph.addNodo(v8);

        graph.addArco(new ArcoGrafoNuevo("1",v1, v2, 1.0));
        graph.addArco(new ArcoGrafoNuevo("2",v2, v3, 1.5));
        graph.addArco(new ArcoGrafoNuevo("3",v3, v4, 2.0));
        graph.addArco(new ArcoGrafoNuevo("4",v4, v5, 1.0));
        graph.addArco(new ArcoGrafoNuevo("5",v5, v6, 0.5));
        graph.addArco(new ArcoGrafoNuevo("6",v6, v7, 1.0));
        graph.addArco(new ArcoGrafoNuevo("7",v7, v8, 1.5));
        graph.addArco(new ArcoGrafoNuevo("8",v8, v1, 2.5));
        graph.addArco(new ArcoGrafoNuevo("9",v1, v3, 1.8));
        graph.addArco(new ArcoGrafoNuevo("10",v2, v4, 2.2));
        graph.addArco(new ArcoGrafoNuevo("11",v3, v5, 0.9));
        graph.addArco(new ArcoGrafoNuevo("12",v4, v6, 1.1));
        graph.addArco(new ArcoGrafoNuevo("13",v5, v7, 2.0));
        graph.addArco(new ArcoGrafoNuevo("14",v6, v8, 1.7));
        Cola<Camino<String>> caminos = graph.dijkstra(v1);
        mostrar_todos_los_caminos(caminos);
        int pos = caminos.getPosicion(new ElementoLDE(v8));
        ElementoLDE <Camino<String>> caminoV8 = caminos.getElemento(pos);
        ListaSimple<NodoGrafoNuevo<String>> caminoHastaH = caminoV8.getData().getCamino();

        System.out.println("El camino de v1 a v8 es:");
        for (int i = 0; i <caminoHastaH.getNumeroElementos();i++){
            NodoGrafoNuevo<String> nodo = (NodoGrafoNuevo<String>) caminoHastaH.getElemento(i).getData();
            System.out.println(nodo.getDato());
        }
        System.out.println("El coste de dicho camino es:" + caminoV8.getData().coste);

        assertEquals(v1, caminoHastaH.getElemento(0).getData());
        assertEquals(v3, caminoHastaH.getElemento(1).getData());
        assertEquals(v5, caminoHastaH.getElemento(2).getData());
        assertEquals(v6, caminoHastaH.getElemento(3).getData());
        assertEquals(v8, caminoHastaH.getElemento(4).getData());
        assertEquals(4.9,caminoV8.getData().coste);

    }

    private static void mostrar_todos_los_caminos(Cola<Camino<String>> todosloscaminos) {
        for(int i = 0; i<todosloscaminos.getNumeroElementos()-1;i++){
            ElementoLDE<Camino<String>> mi = todosloscaminos.getElemento(i);
            Camino<String> c = mi.getData();
            System.out.println(c.toString());
        }
    }*/
}