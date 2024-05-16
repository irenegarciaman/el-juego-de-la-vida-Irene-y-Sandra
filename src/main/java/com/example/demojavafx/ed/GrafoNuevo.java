package com.example.demojavafx.ed;

import java.util.*;

public class GrafoNuevo<TipoDelDato> {
    private ListaSimple<NodoGrafoNuevo> listaVertices;
    private ListaSimple<ArcoGrafoNuevo> listaArcos;

    public GrafoNuevo(ListaSimple<NodoGrafoNuevo> listaVertices, ListaSimple<ArcoGrafoNuevo> listaArcos) {
        this.listaVertices = listaVertices;
        this.listaArcos = listaArcos;
    }

    public void addNodo(NodoGrafoNuevo nodo) {
        listaVertices.add(nodo);
    }

    public void addArco(ArcoGrafoNuevo arco) {
        if (arco.origen != null && arco.destino != null) {
            NodoGrafoNuevo n1 = arco.origen;
            NodoGrafoNuevo n2 = arco.destino;
            n1.listaSalida.add(arco);
            n2.listaEntrada.add(arco);
            listaArcos.add(arco);
        } else {
            System.out.println("el arco no se ha añadido");
        }

    }

    public void borrarArco(ArcoGrafoNuevo arco) {
        if (arco.origen != null && arco.destino != null) {
            NodoGrafoNuevo n1 = arco.origen;
            NodoGrafoNuevo n2 = arco.destino;
            ElementoLS arco1 = new ElementoLS<>(arco);
            int posArcoLS = n1.listaSalida.getPosicion(arco1);
            n1.listaSalida.del(posArcoLS);
            int posArcoLE = n2.listaEntrada.getPosicion(arco1);
            n2.listaEntrada.del(posArcoLE);
            int posArco = listaArcos.getPosicion(arco1);
            listaArcos.del(posArco);
        }
    }

    public void borrarNodo(NodoGrafoNuevo nodo) {
        ElementoLS nodo1 = new ElementoLS<>(nodo);
        ListaSimple<NodoGrafoNuevo> le = nodo.listaEntrada;
        ListaSimple<NodoGrafoNuevo> ls = nodo.listaSalida;
        if (le.isVacia() && ls.isVacia()) {
            int posNodo = listaVertices.getPosicion(nodo1);
            listaVertices.del(posNodo);
        } else {
            System.out.println("antes de eliminar el nodo debes eliminar sus arcos");
        }
    }

    public boolean recuperarNodo(NodoGrafoNuevo<TipoDelDato> nodo) {
        boolean recuperarNodo;
        ElementoLS<NodoGrafoNuevo> nodo1 = new ElementoLS<>(nodo);
        int posicionNodo = listaVertices.getPosicion(nodo1);
        if (posicionNodo == -1) {
            recuperarNodo = false;
        } else {
            recuperarNodo = true;
        }
        return recuperarNodo;
    }

    public boolean recuperarArco(ArcoGrafoNuevo<TipoDelDato> arco) {
        boolean recuperarArco;
        ElementoLS<ArcoGrafoNuevo> arco1 = new ElementoLS<>(arco);
        int posicionNodo = listaArcos.getPosicion(arco1);
        if (posicionNodo == -1) {
            recuperarArco = false;
        } else {
            recuperarArco = true;
        }
        return recuperarArco;
    }

    public Cola<Camino<TipoDelDato>> dijkstra(NodoGrafoNuevo<TipoDelDato> origen) {
        Cola<Double> distancias = new Cola<>();
        Cola<NodoGrafoNuevo<TipoDelDato>> colaPendientes = new Cola<>();
        Cola<NodoGrafoNuevo<TipoDelDato>> nodosAnteriores = new Cola<>();


        this.dijkstra_init(origen, distancias, colaPendientes, nodosAnteriores);
        this.dijkstra_calcula(distancias, colaPendientes, nodosAnteriores);
        return this.dijkstra_procesaResultados(distancias, nodosAnteriores, origen);
    }

    protected void dijkstra_init(NodoGrafoNuevo<TipoDelDato> origen, Cola<Double> distancias, Cola<NodoGrafoNuevo<TipoDelDato>> colaPendientes, Cola<NodoGrafoNuevo<TipoDelDato>> nodosAnteriores) {
        for (int i = 0; i < listaVertices.getNumeroElementos(); i++) {
            distancias.push(new ElementoLDE(Double.MAX_VALUE));
            nodosAnteriores.push(new ElementoLDE<>(origen));
        }
        int posicionOriginal = listaVertices.getPosicion(new ElementoLS<>(origen));
        distancias.machacar(new ElementoLDE<>(0.0), posicionOriginal);
        colaPendientes.push(new ElementoLDE<>(origen));
    }

    protected void dijkstra_calcula(Cola<Double> distancias, Cola<NodoGrafoNuevo<TipoDelDato>> colaPendientes, Cola<NodoGrafoNuevo<TipoDelDato>> nodosAnteriores) {
        while (!colaPendientes.isVacia()) {
            ElementoLDE<NodoGrafoNuevo<TipoDelDato>> elementoActual = colaPendientes.pop();
            NodoGrafoNuevo<TipoDelDato> nodoActual = elementoActual.getData();
            for (int i = 0; i < nodoActual.listaSalida.getNumeroElementos(); i++) {

                ArcoGrafoNuevo<TipoDelDato> arco = (ArcoGrafoNuevo<TipoDelDato>) nodoActual.listaSalida.getElemento(i).getData();
                NodoGrafoNuevo<TipoDelDato> nodoVecino = arco.destino;
                int posicionOrigen = listaVertices.getPosicion(new ElementoLS<>(nodoActual));
                ElementoLDE<Double> distancia = distancias.getElemento(posicionOrigen);

                double nuevaDistancia = (double) distancia.getData() + arco.peso;
                ElementoLDE<Double> nuevadistancia1 = new ElementoLDE<>(nuevaDistancia);
                int posicionVecino = listaVertices.getPosicion(new ElementoLS<>(nodoVecino));
                ElementoLDE<Double> distanciaVecino = distancias.getElemento(posicionVecino);
                double distanciaVecino1 = distanciaVecino.getData();

                if (nuevaDistancia < distanciaVecino1) {
                    distancias.machacar(nuevadistancia1, posicionVecino);
                    nodosAnteriores.machacar(new ElementoLDE<>(nodoActual), posicionVecino);
                    colaPendientes.push(new ElementoLDE<>(nodoVecino));
                }
            }
        }
    }

    protected Cola<Camino<TipoDelDato>> dijkstra_procesaResultados(Cola<Double> distancias, Cola<NodoGrafoNuevo<TipoDelDato>> nodosAnteriores, NodoGrafoNuevo<TipoDelDato> origen) {
        Cola<Camino<TipoDelDato>> caminos = new Cola<>();
        int i = listaVertices.getPosicion(new ElementoLS<>(origen));
        ListaSimple<NodoGrafoNuevo<TipoDelDato>> list = new ListaSimple<>();
        for (; i < nodosAnteriores.getNumeroElementos(); i++) {
            list.add(nodosAnteriores.getElemento(i));
        }
        int l = listaVertices.getPosicion(new ElementoLS<>(origen));
        if (l != 0) {
            for (int j = 0; j < l; j++) {
                list.add(nodosAnteriores.getElemento(j));
            }
        }
        for (int p = 0; p < list.getNumeroElementos(); p++) {
            ListaSimple<NodoGrafoNuevo<TipoDelDato>> caminoCalculado = new ListaSimple<>();
            NodoGrafoNuevo<TipoDelDato> nodoDestino = (NodoGrafoNuevo<TipoDelDato>) listaVertices.getElemento(p).getData();
            caminoCalculado.add(nodoDestino);

            NodoGrafoNuevo<TipoDelDato> nodoAnterior = (NodoGrafoNuevo<TipoDelDato>) nodosAnteriores.getElemento(p).getData();

            NodoGrafoNuevo<TipoDelDato> nodoAnterior2 = nodoAnterior;

            while (nodoAnterior2 != null) {
                caminoCalculado.add(nodoAnterior2);
                int posicionNodoAnterior2 = listaVertices.getPosicion(new ElementoLS<>(nodoAnterior2));
                if (nodoAnterior2 != origen) {
                    nodoAnterior2 = (NodoGrafoNuevo<TipoDelDato>) nodosAnteriores.getElemento(posicionNodoAnterior2).getData();
                } else {
                    nodoAnterior2 = null;
                }
            }

            int posicionNodoDestino = listaVertices.getPosicion(new ElementoLS<>(nodoDestino));
            ElementoLDE<Double> nuevaDistancia = distancias.getElemento(posicionNodoDestino);

            ArrayList<ElementoLS<TipoDelDato>> invertir = new ArrayList<>();
            for (int k = caminoCalculado.getNumeroElementos() - 1; k >= 0; k--) {
                invertir.add((ElementoLS<TipoDelDato>) caminoCalculado.getElemento(k));
            }
            ListaSimple<NodoGrafoNuevo<TipoDelDato>> caminoCalculadoInvertido = new ListaSimple<>();

            for (int j = 0; j < invertir.size(); j++) {
                ElementoLS<TipoDelDato> elementoInvertido = invertir.get(j);
                caminoCalculadoInvertido.add(elementoInvertido.getData());
            }
            Camino<TipoDelDato> camino = new Camino<>(caminoCalculadoInvertido, nuevaDistancia.getData());
            caminos.push(new ElementoLDE<>(camino));
        }
        return caminos;
    }

    public void guardarGrafo() {
        String rutaArchivo = "grafo.json";
        Gson1.guardarObjetoEnArchivo(rutaArchivo, this);
        GrafoNuevo grafo = Gson1.cargarObjetoDesdeArchivo(rutaArchivo, GrafoNuevo.class);
        if (grafo != null) {
            System.out.println("Arbol Cargado");
        }
    }

    public ListaSimple<NodoGrafoNuevo> getListaVertices() {
        return listaVertices;
    }

    public ListaSimple<ArcoGrafoNuevo> getListaArcos() {
        return listaArcos;
    }
}