package com.example.demojavafx.ed;

import com.example.demojavafx.HelloApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NodoArbol<TipoDelDato> {

    private static final Logger log = LogManager.getLogger(NodoArbol.class);
    NodoArbol<TipoDelDato> derecha;
    NodoArbol<TipoDelDato> izquierda;
    TipoDelDato dato;


    public NodoArbol(NodoArbol<TipoDelDato> derecha, NodoArbol<TipoDelDato> izquierda, TipoDelDato dato) {
        this.derecha = derecha;
        this.izquierda = izquierda;
        this.dato = dato;
    }


    public NodoArbol(TipoDelDato dato) {
        this.dato = dato;
    }

    public NodoArbol<TipoDelDato> getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoArbol<TipoDelDato> derecha) {
        this.derecha = derecha;
    }

    public NodoArbol<TipoDelDato> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoArbol<TipoDelDato> izquierda) {
        this.izquierda = izquierda;
    }

    public TipoDelDato getDato() {
        return dato;
    }

    public void setDato(TipoDelDato dato) {
        this.dato = dato;
    }

    public int gradoNodo() {
        NodoArbol<TipoDelDato> n = this;
        int contador = 0;
        if (n.getIzquierda() != null) {
            contador++;
        }
        if (n.getDerecha() != null) {
            contador++;
        }
        return contador;
    }

    public boolean esHoja() {
        NodoArbol<TipoDelDato> n = this;
        return n.getDerecha() == null && n.getIzquierda() == null;
    }

    public NodoArbol() {
    }
/**
 public void borradoHoja(TipoDelDato valor,NodoArbol n) {// Borrado de una hoja
 NodoArbol<TipoDelDato> padre = new NodoArbol<>();
 padre = n;
 Comparable c = (Comparable) this.getDato();
 int rdo = c.compareTo(valor);
 if (rdo > 0) {
 if (this.izquierda != null) {
 n = this.izquierda;
 }
 } else if (rdo < 0) {
 if (this.derecha != null) {
 n = this.derecha;
 }
 }
 if (rdo == 0) {
 if (padre == n.izquierda) {
 this.izquierda = null;
 } else {
 this.derecha = null;
 }

 } else {
 n.borradoHoja(valor,n);
 }
 }




 public void borrado1hijo(TipoDelDato valor) {
 NodoArbol<TipoDelDato> n = new NodoArbol();
 NodoArbol<TipoDelDato> padre = new NodoArbol<>();
 padre = n;
 Comparable c = (Comparable) n.dato;
 int rdo = c.compareTo(valor);
 if (rdo > 0) {
 if (this.izquierda != null) {
 n = this.izquierda;
 }
 } else if (rdo < 0) {
 if (this.derecha != null) {
 n = this.derecha;
 }
 }
 if (rdo == 0) {
 if (n.izquierda != null) {
 padre.izquierda = n.izquierda;
 } else if (n.derecha != null) {
 padre.derecha = n.derecha;
 }
 } else {
 n.borrado1hijo(valor);
 }
 }

 public void borrado2hijos(TipoDelDato valor) {
 NodoArbol<TipoDelDato> n = new NodoArbol<>();
 NodoArbol<TipoDelDato> padre = new NodoArbol<>();
 padre = n;
 Comparable c = (Comparable) n.dato;
 int rdo = c.compareTo(valor);
 if (rdo > 0) {
 if (this.izquierda != null) {
 n = this.izquierda;
 }
 } else if (rdo < 0) {
 if (this.derecha != null) {
 n = this.derecha;
 }
 }
 if (rdo == 0) {
 if (n.izquierda.izquierda != null) {
 padre.derecha = n.izquierda.izquierda;
 } else if (n.derecha.derecha != null) {
 padre.izquierda = n.derecha.derecha;
 }
 } else {
 n.borrado2hijos(valor);
 }
 }

 public NodoArbol NodoPadreIzq(NodoArbol nodo){
 NodoArbol<TipoDelDato> n = new NodoArbol();
 if (nodo.izquierda.izquierda==null){
 n=nodo;
 }else{
 NodoPadreIzq(nodo.izquierda);
 }
 return n;
 }*/
}
