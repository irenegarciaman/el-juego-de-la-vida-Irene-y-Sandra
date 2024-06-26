package com.example.demojavafx.ed;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class
ListaEnlazada<TipoDelDato> {
    private static final Logger log = LogManager.getLogger(ListaEnlazada.class);
    private ElementoLE<TipoDelDato> primero;

    public ElementoLE<TipoDelDato> getEl() {
        return primero;
    }

    public ListaEnlazada(ElementoLE<TipoDelDato> primero) {
        this.primero = primero;
    }

    public ListaEnlazada() {
        this.primero = null;
    }


    public boolean isVacia() {
        return this.primero == null;
    }

    public void vaciar() {
        this.primero = null;
    }

    private void add(ElementoLE<TipoDelDato> el) {
        if (isVacia()) {
            this.primero = el;
        } else {
            this.primero = new ElementoLE<>(el.getData(), this.primero);
        }

    }


    public void add(String s) {
        TipoDelDato o = (TipoDelDato) s;
        ElementoLE<TipoDelDato> a = new ElementoLE<>(o);
        add(a);
    }

    public void add(Object o) {
        TipoDelDato a = (TipoDelDato) o;
        ElementoLE<TipoDelDato> e = new ElementoLE<>(a);
        add(e);
    }

    private void insert(ElementoLE<TipoDelDato> el, int posicion) {
        if (primero == null) {
            add(el.getData());
        } else {
            int contador;
            ElementoLE<TipoDelDato> temporal = primero;
            for (contador = 0; contador < posicion - 1; contador++) {
                temporal = temporal.getSiguiente();
            }
            el.setSiguiente(temporal.getSiguiente());
            temporal.setSiguiente(el);
        }
    }

    public void insert(String s, int posicion) {
        TipoDelDato aux = (TipoDelDato) s;
        ElementoLE<TipoDelDato> a = new ElementoLE<>(aux);
        insert(a, posicion);
    }

    public void insert(Object o, int posicion) {
        TipoDelDato aux = (TipoDelDato) o;
        ElementoLE<TipoDelDato> a = new ElementoLE<>(aux);
        insert(a, posicion);
    }

    public void delete(int posicion) {

        if (posicion == 0) {
            primero = primero.getSiguiente();
        } else {
            int contador = 0;
            if (!isVacia()) {
                ElementoLE<TipoDelDato> temporal = primero;
                while (contador < posicion - 1) {
                    temporal = temporal.getSiguiente();
                    contador++;
                }
                if (temporal.getSiguiente().getSiguiente() != null) {
                    temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
                } else {
                    temporal.setSiguiente(null);
                }
            }
        }

    }

    public int getNumeroElementos() {
        int contador = 0;
        if (!isVacia()) {
            ElementoLE<TipoDelDato> cabeza = this.primero;
            while (cabeza.getSiguiente() != null) {
                cabeza = cabeza.getSiguiente();
                contador++;
            }
            contador++;
        }
        return contador;
    }

    public int getPosicion(ElementoLE<TipoDelDato> el) {
        int contador = -1;
        boolean encontrado = false;
        if (!this.isVacia()) {
            ElementoLE cabeza = this.primero;
            while (cabeza != null && el != null && encontrado == false) {
                if (el.getData().equals(cabeza.getData())) {
                    encontrado = true;
                    contador++;
                } else {
                    cabeza = cabeza.getSiguiente();
                    contador++;
                }
            }

        }else{
            return -1;
        }
        if (encontrado != true) {
            contador = -1;
        }
        return contador;

    }

    public ElementoLE<TipoDelDato> getPrimero() {
        return this.primero;
    }

    public ElementoLE<TipoDelDato> getUltimo() {
        ElementoLE<TipoDelDato> cabeza = this.primero;
        if (!isVacia()) {
            int contador = 0;
            while (contador < getNumeroElementos() - 1) {
                cabeza = cabeza.getSiguiente();
                contador++;
            }
        }
        return cabeza;
    }

    public ElementoLE<TipoDelDato> getSiguiente(ElementoLE<TipoDelDato> el) {
        if (el.getData() != null) {
            int posicion = getPosicion(el);
            return getElemento(posicion + 1);
        } else {
            return null;
        }
    }

    public ElementoLE<TipoDelDato> getElemento(int pos) {
        ElementoLE<TipoDelDato> cabeza;
        int contador = 0;
        if (this.primero != null) {
            cabeza = this.primero;
            while (contador < pos) {
                cabeza = cabeza.getSiguiente();
                contador++;
                if (cabeza == null) {
                    return null;
                }
            }
            return cabeza;
        } else {
            return null;
        }

    }

    public ListaEnlazada<TipoDelDato> invertir(ElementoLE<TipoDelDato> aux, ListaEnlazada<TipoDelDato> lista) {
        lista.add(aux.getData());
        if (aux.getSiguiente() != null) {
            invertir(aux.getSiguiente(), lista);
        }
        return lista;
    }

    public ListaEnlazada<TipoDelDato> invertir() {
        ListaEnlazada<TipoDelDato> lista = new ListaEnlazada<>();
        return this.invertir(this.primero, lista);
    }

    public int suma(ElementoLE<Integer> el) {
        int res = el.getData();
        if (el.getSiguiente() == null) {
            return res;
        } else {
            return el.getData() + suma(el.getSiguiente());
        }
    }

    public int suma() {
        ElementoLE<Integer> el = (ElementoLE<Integer>) this.primero;
        return suma(el);
    }

    public void guardarLE() {
        String rutaArchivo = "listaLE.json";
        Gson1.guardarObjetoEnArchivo(rutaArchivo, this);
        ListaEnlazada listaE = Gson1.cargarObjetoDesdeArchivo(rutaArchivo, ListaEnlazada.class);
        if (listaE != null) {
            System.out.println("Arbol Cargado");
        }
    }

    @Override
    public String toString() {
        String res = "";
        int aux = 0;
        while (aux < this.getNumeroElementos()) {
            res += getElemento(aux).getData().toString() + "\n ";
            aux++;
        }
        return res;
    }

}
