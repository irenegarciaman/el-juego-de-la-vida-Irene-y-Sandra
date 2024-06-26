package com.example.demojavafx.ed;


import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ListaDoblementeEnlazada<TipoDelDato> {

    private static final Logger log = LogManager.getLogger(ListaDoblementeEnlazada.class);
    private ElementoLDE primero;
    private ElementoLDE ultimo;

    public ListaDoblementeEnlazada() {
    }

    public ListaDoblementeEnlazada(ElementoLDE el) {
        this.primero = el;
        this.ultimo = el;
    }

    public boolean isVacia() {
        return this.primero == null;
    }

    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
    }

    private void add(ElementoLDE el) {
        if (isVacia()) {
            this.primero = el;
            this.ultimo = el;
        } else {
            ElementoLDE nuevo = new ElementoLDE<>(this.primero.getAnterior(), this.primero, el.getData());
            this.primero.setAnterior(el);
            this.primero = nuevo;

        }
    }

    public void add(String s) {
        ElementoLDE a = new ElementoLDE<>(s);
        add(a);
    }

    public void add(Object o) {
        ElementoLDE a = new ElementoLDE<>(o);
        add(a);
    }

    public void insert(ElementoLDE el, int posicion) {
        if (primero == null) {
            primero = new ElementoLDE(el);
            ultimo = new ElementoLDE(el);
        } else {
            int contador;
            ElementoLDE temporal = primero;
            for (contador = 0; contador < posicion - 1; contador++) {
                temporal = temporal.getSiguiente();

            }
            el.setAnterior(temporal);
            el.setSiguiente(temporal.getSiguiente());
            if (posicion >= 1) {
                temporal.getSiguiente().setAnterior(el);
            }
            temporal.setSiguiente(el);
        }


    }

    public void insert(Object o, int posicion) {
        ElementoLDE a = new ElementoLDE<Object>(o);
        insert(a, posicion);
    }

    public void delete(int pos) {
        if (pos == 0) {
            primero = primero.getSiguiente();
        } else {
            int contador = 0;
            ElementoLDE temporal = primero;
            while (contador < pos - 1) {
                temporal = temporal.getSiguiente();
                contador++;
            }
            temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
            temporal.getSiguiente().getSiguiente().setAnterior(temporal);
        }
    }

    public int getNumeroElementos() {
        ElementoLDE cabeza = this.primero;
        if (this.primero == null) {
            return 0;
        } else {
            int contador = 0;
            while (cabeza != null) {
                cabeza = cabeza.getSiguiente();
                contador++;
            }
            return contador;
        }
    }

    public int getPosicion(ElementoLDE el) {
        if (isVacia() == false) {
            ElementoLDE cabeza = this.primero;
            int contador = 0;
            while (cabeza != el && contador < getNumeroElementos() - 1) {
                cabeza = cabeza.getSiguiente();
                contador++;
            }
            return contador;
        } else {
            return -1;
        }

    }

    public ElementoLDE getPrimero() {
        return primero;
    }

    public ElementoLDE getUltimo() {
        return ultimo;
    }

    public ElementoLDE getSiguiente(ElementoLDE el) {
        ElementoLDE aux = this.primero;
        while (aux.data != el.data && aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        return aux.getSiguiente();
    }

    public ElementoLDE getAnterior(ElementoLDE el) {
        ElementoLDE aux = this.primero;
        while (aux.data != el.data && aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        return aux.getAnterior();
    }

    public ElementoLDE getElemento(int posicion) {
        ElementoLDE cabeza = this.primero;
        int contador = 0;
        if (this.primero != null) {
            while (contador < posicion) {
                cabeza = cabeza.getSiguiente();
                contador++;
            }
        }
        return cabeza;
    }

    public void guardarLDE() {
        String rutaArchivo = "listaLDE.json";
        Gson1.guardarObjetoEnArchivo(rutaArchivo, this);
        ListaDoblementeEnlazada listaDE = Gson1.cargarObjetoDesdeArchivo(rutaArchivo, ListaDoblementeEnlazada.class);
        if (listaDE != null) {
            System.out.println("Arbol Cargado");
        }
    }


}
