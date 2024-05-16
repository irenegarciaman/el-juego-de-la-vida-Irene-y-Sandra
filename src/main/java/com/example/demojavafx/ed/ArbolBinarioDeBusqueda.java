package com.example.demojavafx.ed;

import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.Individuo;
import net.sourceforge.plantuml.*;
import net.sourceforge.plantuml.api.ImageDataComplex;
import net.sourceforge.plantuml.api.ImageDataSimple;
import net.sourceforge.plantuml.core.Diagram;
import net.sourceforge.plantuml.core.DiagramDescription;
import net.sourceforge.plantuml.core.ImageData;

import java.io.*;

public class ArbolBinarioDeBusqueda<TipoDeDatos> {
    public NodoArbol<TipoDeDatos> raiz;

    public ArbolBinarioDeBusqueda(NodoArbol<TipoDeDatos> raiz, NodoArbol<TipoDeDatos> derecha, NodoArbol<TipoDeDatos> izquierda) {
        this.raiz = raiz;
        this.raiz.setDerecha(derecha);
        this.raiz.setIzquierda(izquierda);
    }

    public ArbolBinarioDeBusqueda(NodoArbol<TipoDeDatos> raiz) {
        this.raiz = raiz;
    }

    public ArbolBinarioDeBusqueda() {
        NodoArbol<TipoDeDatos> nodo = new NodoArbol<>(null);
        this.raiz = nodo;
    }

    public ArbolBinarioDeBusqueda(TipoDeDatos dato) {
        this.raiz = new NodoArbol<>(dato);
    }

    public boolean isVacia() {
        return this.raiz.dato == null;
    }

    public void add(TipoDeDatos a1, NodoArbol<TipoDeDatos> raiz) {
        NodoArbol<TipoDeDatos> n1 = new NodoArbol<>(a1);
        Comparable c = (Comparable) raiz.getDato();
        if (isVacia()) {
            this.raiz.setDato(a1);
            this.raiz.setDerecha(null);
            this.raiz.setIzquierda(null);
        } else {
            if (c.compareTo(a1) <= 0) {
                if (raiz.getDerecha() == null) {
                    raiz.setDerecha(n1);
                } else {
                    add(a1, raiz.getDerecha());
                }
            } else {
                if (raiz.getIzquierda() == null) {
                    raiz.setIzquierda(n1);
                } else {
                    add(a1, raiz.getIzquierda());
                }
            }
        }
    }

    public void add(TipoDeDatos a1) {
        add(a1, this.raiz);
    }

    public int getGrado(NodoArbol<TipoDeDatos> n, int result) {
        if (result < n.gradoNodo()) {
            result = n.gradoNodo();
        }
        if (n.getIzquierda() != null) {
            getGrado(n.getIzquierda(), result);
        }
        if (n.getDerecha() != null) {
            getGrado(n.getDerecha(), result);
        }
        return result;
    }

    public ListaEnlazada<TipoDeDatos> getCamino(NodoArbol<TipoDeDatos> n, NodoArbol<TipoDeDatos> raiz, ListaEnlazada<TipoDeDatos> lista) {
        Comparable c = (Comparable) n.getDato();
        lista.add(raiz.getDato());
        if (c.compareTo(raiz.getDato()) < 0) {
            getCamino(n, raiz.getIzquierda(), lista);
        } else if (c.compareTo(raiz.getDato()) > 0) {
            getCamino(n, raiz.getDerecha(), lista);
        }
        return lista;
    }

    public ListaEnlazada<TipoDeDatos> getCamino(NodoArbol<TipoDeDatos> n) {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        ListaEnlazada<TipoDeDatos> lista1 = getCamino(n, this.raiz, lista);
        return lista1.invertir();
    }

    public int getLongitud(NodoArbol<TipoDeDatos> nodo) {
        return (getCamino(nodo).getNumeroElementos() - 1);
    }

    public ArbolBinarioDeBusqueda<TipoDeDatos> getSubArbolDcha() {
        ArbolBinarioDeBusqueda<TipoDeDatos> subArbol = new ArbolBinarioDeBusqueda<>(this.raiz.getDerecha());
        return subArbol;
    }

    public ArbolBinarioDeBusqueda<TipoDeDatos> getSubArbolIzq() {
        ArbolBinarioDeBusqueda<TipoDeDatos> subArbol = new ArbolBinarioDeBusqueda<>(this.raiz.getIzquierda());
        return subArbol;
    }

    public ArbolBinarioDeBusqueda<TipoDeDatos> getSubArbol(NodoArbol<TipoDeDatos> n) {
        ArbolBinarioDeBusqueda<TipoDeDatos> subArbol = new ArbolBinarioDeBusqueda<>(n);
        return subArbol;
    }

    public ListaEnlazada<TipoDeDatos> preorden(NodoArbol<TipoDeDatos> n, ListaEnlazada<TipoDeDatos> lista) {
        lista.add(n.dato);
        if (n.getIzquierda() != null) {
            preorden(n.getIzquierda(), lista);
        }
        if (n.getDerecha() != null) {
            preorden(n.getDerecha(), lista);
        }
        return lista;
    }

    public ListaEnlazada<TipoDeDatos> preorden() {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        return preorden(this.raiz, lista).invertir();
    }

    public ListaEnlazada<TipoDeDatos> ordenCentral(NodoArbol<TipoDeDatos> n, ListaEnlazada<TipoDeDatos> lista) {
        if (n.getIzquierda() != null) {
            ordenCentral(n.getIzquierda(), lista);
        }
        lista.add(n.dato);
        if (n.getDerecha() != null) {
            ordenCentral(n.derecha, lista);
        }
        return lista;
    }

    public ListaEnlazada<TipoDeDatos> ordenCentral() {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        return ordenCentral(this.raiz, lista).invertir();
    }

    public ListaEnlazada<TipoDeDatos> postOrder(NodoArbol<TipoDeDatos> n, ListaEnlazada<TipoDeDatos> lista) {
        if (n.getIzquierda() != null) {
            postOrder(n.getIzquierda(), lista);
        }
        if (n.getDerecha() != null) {
            postOrder(n.getDerecha(), lista);
        }
        lista.add(n.dato);
        return lista;
    }

    public ListaEnlazada<TipoDeDatos> postOrder() {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        return postOrder(this.raiz, lista).invertir();
    }

    public int getAltura(NodoArbol<TipoDeDatos> n, int p) {
        int x = 0;
        int y = 0;
        if (n.getDerecha() != null) {
            y = getAltura(n.getDerecha(), p + 1);
        }
        if (n.getIzquierda() != null) {
            x = getAltura(n.getIzquierda(), p + 1);
        }
        if (x >= y && x > p) {
            return x;
        } else if (x < y && y > p) {
            return y;
        }
        return p;
    }

    public int getAltura() {
        return getAltura(this.raiz, 1);
    }

    boolean aux = true;
    boolean aux2 = true;

    public boolean isArbolCompleto(NodoArbol<TipoDeDatos> n, int numero) {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        if (n.getIzquierda() == null && n.getDerecha() == null) {
            lista = getCamino(n, this.raiz, lista);
            int num = lista.getNumeroElementos();
            if (num != numero) {
                aux = false;
            }
        }
        if (n.getIzquierda() != null) {
            isArbolCompleto(n.getIzquierda(), numero);
        }
        if (n.getDerecha() != null) {
            isArbolCompleto(n.getDerecha(), numero);
        }
        return aux;
    }

    public boolean isArbolCompleto() {
        aux = true;
        int num = 1;
        NodoArbol<TipoDeDatos> nodo = this.raiz;
        while (nodo.getIzquierda() != null) {
            num++;
            nodo = nodo.getIzquierda();
        }
        return isArbolCompleto(this.raiz, num);
    }

    public boolean isArbolHomogeneo(NodoArbol<TipoDeDatos> n) {
        int num = n.gradoNodo();
        if (num != 2 && num != 0) {
            aux = false;
        }
        if (n.getIzquierda() != null) {
            isArbolHomogeneo(n.getIzquierda());
        }
        if (n.getDerecha() != null) {
            isArbolHomogeneo(n.getDerecha());
        }
        return aux;
    }

    public boolean isArbolHomogeneo() {
        aux = true;
        return isArbolHomogeneo(this.raiz);
    }

    public ListaEnlazada<TipoDeDatos> getListaDatosNivel(int nivel, NodoArbol<TipoDeDatos> n, ListaEnlazada<TipoDeDatos> lista) {
        int num = this.getCamino(n).getNumeroElementos();
        if (num == nivel) {
            lista.add(n.dato);
        }
        if (n.getIzquierda() != null) {
            getListaDatosNivel(nivel, n.getIzquierda(), lista);
        }
        if (n.getDerecha() != null) {
            getListaDatosNivel(nivel, n.getDerecha(), lista);
        }
        return lista;
    }

    public ListaEnlazada<TipoDeDatos> getListaDatosNivel(int nivel) {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        return getListaDatosNivel(nivel, this.raiz, lista).invertir();
    }

    public boolean isArbolCasiCompleto(NodoArbol<TipoDeDatos> n, int numero) {
        ListaEnlazada<TipoDeDatos> lista = new ListaEnlazada<>();
        if (n.getIzquierda() == null && n.getDerecha() == null) {
            lista = getCamino(n, this.raiz, lista);
            int num = lista.getNumeroElementos();
            if (num == numero - 1) {
                aux = false;
            } else if (num <= numero - 1) {
                aux2 = false;
            }
            if (!aux) {
                if (num != numero - 1) {
                    aux2 = false;
                }
            }
        }
        if (n.getIzquierda() != null) {
            isArbolCasiCompleto(n.getIzquierda(), numero);
        }
        if (n.getDerecha() != null) {
            isArbolCasiCompleto(n.getDerecha(), numero);
        }
        return aux2;
    }

    public boolean isArbolCasiCompleto() {
        int num = 1;
        NodoArbol<TipoDeDatos> nodo = this.raiz;
        while (nodo.getIzquierda() != null) {
            num++;
            nodo = nodo.getIzquierda();
        }
        if (isArbolCompleto()) {
            aux = true;
            aux2 = true;
            return false;
        } else {
            aux = true;
            aux2 = true;
            return isArbolCasiCompleto(this.raiz, num);
        }
    }
    /***
     public int getNivel(int nivel, NodoArbol<TipoDeDatos> n,NodoArbol<TipoDeDatos> aBuscar) {
     if (n.getIzquierda() != null) {
     getNivel(nivel+1, n.getIzquierda(),aBuscar);
     }
     if (n.getDerecha() != null) {
     getNivel(nivel+1, n.getDerecha(),aBuscar);
     }
     return nivel;
     }
     public int getNivel(NodoArbol<TipoDeDatos> n) {
     return getNivel(0,this.raiz,n);
     }*/

    /**
     * public void borrado(TipoDeDatos valor, NodoArbol n){
     * NodoArbol<TipoDeDatos> padre = new NodoArbol<>();
     * Comparable c = (Comparable) n.getDato();
     * int rdo = c.compareTo(valor);
     * if (rdo > 0) {
     * if (n.izquierda != null) {
     * n = n.izquierda;
     * }
     * } else if (rdo < 0) {
     * if (n.derecha != null) {
     * n = n.derecha;
     * }
     * }
     * if (rdo == 0) {
     * if (padre.izquierda == n) {
     * n = null;
     * } else if(padre.derecha == n){
     * n = null;
     * }
     * <p>
     * } else {
     * borrado(valor,n);
     * }
     * <p>
     * <p>
     * }
     * <p>
     * public void borrar(TipoDeDatos valor){
     * Comparable c = (Comparable) raiz.dato;
     * if(raiz!=null){
     * if(c.compareTo(valor)==0){
     * borrarRaiz();
     * }else{
     * raiz.borradoHoja(valor);
     * }
     * }
     * }
     * <p>
     * public void borrarRaiz(){
     * if(this.getGrado(raiz,(int)raiz.dato)==0){
     * this.raiz = null;
     * }else if(this.getGrado(raiz,(int)raiz.dato)==1){
     * NodoArbol<TipoDeDatos> n = this.raiz.izquierda;
     * if (n==null){
     * n=this.raiz.derecha;
     * }
     * this.raiz=n;
     * }else{
     * NodoArbol<TipoDeDatos> n = this.raiz.NodoPadreIzq(raiz.derecha);
     * NodoArbol<TipoDeDatos> nodoASustituir = n.izquierda;
     * if(this.getGrado(raiz,(int)raiz.dato)==0){
     * this.raiz.setDato(nodoASustituir.getDato());
     * n.izquierda = null;
     * }else{
     * this.raiz.setDato(nodoASustituir.getDato());
     * n.izquierda=nodoASustituir.derecha;
     * }
     * }
     * }
     */

    public int getNivel(NodoArbol<TipoDeDatos> n, NodoArbol<TipoDeDatos> raiz) {
        Comparable c = (Comparable) n.getDato();
        if (c.compareTo(raiz.getDato()) < 0) {
            return 1 + getNivel(n, raiz.getIzquierda());
        } else if (c.compareTo(raiz.getDato()) > 0) {
            return 1 + getNivel(n, raiz.getDerecha());
        } else {
            return 1;
        }
    }

    public int getNivel(NodoArbol<TipoDeDatos> n) {
        return getNivel(n, this.raiz);
    }

    public boolean eliminar(TipoDeDatos valor) {
        NodoArbol<TipoDeDatos> temporal = raiz;
        NodoArbol<TipoDeDatos> padre = raiz;
        //  Comparable c = (Comparable) temporal.dato;
        // int rdo = c.compareTo(valor);
        boolean esHijoIzquierda = true;
        while (temporal.dato != valor) {
            Comparable c = (Comparable) temporal.dato;
            int rdo = c.compareTo(valor);
            padre = temporal;
            if (rdo > 0) {
                esHijoIzquierda = true;
                temporal = temporal.izquierda;
            }
            if (rdo < 0) {
                esHijoIzquierda = false;
                temporal = temporal.derecha;
            } else if (temporal == null) {
                return false;
            }
        }//Fin while
        if (temporal.izquierda == null && temporal.derecha == null) {
            if (temporal == raiz) {
                raiz = null;
            } else if (esHijoIzquierda) {
                padre.izquierda = null;
            } else {
                padre.derecha = null;
            }
        } else if (temporal.derecha == null) {
            if (temporal == raiz) {
                raiz = temporal.izquierda;
            } else if (esHijoIzquierda) {
                padre.izquierda = temporal.izquierda;
            } else {
                padre.derecha = temporal.izquierda;
            }
        } else if (temporal.izquierda == null) {
            if (temporal == raiz) {
                raiz = temporal.derecha;
            } else if (esHijoIzquierda) {
                padre.izquierda = temporal.derecha;
            } else {
                padre.derecha = temporal.derecha;
            }
        } else {
            NodoArbol<TipoDeDatos> nodoASustituir = obtenerNodoASustituir(temporal);
            if (temporal == raiz) {
                if (nodoASustituir != this.raiz.izquierda) {
                    nodoASustituir.izquierda = this.raiz.izquierda;
                }
                if (nodoASustituir != this.raiz.derecha) {
                    nodoASustituir.derecha = this.raiz.derecha;
                }
                raiz = nodoASustituir;
            } else if (esHijoIzquierda) {
                nodoASustituir.izquierda = padre.izquierda.izquierda;
                nodoASustituir.derecha = padre.izquierda.derecha;
                padre.izquierda = nodoASustituir;
            } else {
                nodoASustituir.izquierda = padre.derecha.izquierda;
                nodoASustituir.derecha = padre.derecha.derecha;
                padre.derecha = nodoASustituir;
            }
        }
        return true;
    }

    public NodoArbol obtenerNodoASustituir(NodoArbol nodoASustituir) {
        NodoArbol<TipoDeDatos> sustituirPadre = nodoASustituir;
        NodoArbol<TipoDeDatos> sustituir = nodoASustituir;
        NodoArbol<TipoDeDatos> temporal = nodoASustituir.derecha;
        while (temporal != null) {
            sustituirPadre = sustituir;
            sustituir = temporal;
            temporal = temporal.izquierda;
        }
        if (sustituir != nodoASustituir.derecha) {
            sustituirPadre.izquierda = sustituir.derecha;
            sustituir.derecha = null;
        }
        return sustituir;
    }

    public NodoArbol<TipoDeDatos> getPadre(TipoDeDatos valor, NodoArbol<TipoDeDatos> temp, NodoArbol<TipoDeDatos> padre) {
        Comparable c = (Comparable) temp.dato;
        int rdo = c.compareTo(valor);
        if (rdo > 0) {
            if (temp.izquierda != null) {
                padre = temp;
                temp = temp.izquierda;
            }
        } else if (rdo < 0) {
            if (temp.derecha != null) {
                padre = temp;
                temp = temp.derecha;
            }
        }
        if (rdo == 0) {
            return padre;
        } else {
            return getPadre(valor, temp, padre);
        }

    }

    public NodoArbol<TipoDeDatos> getPadre(TipoDeDatos valor) {
        NodoArbol<TipoDeDatos> padre = new NodoArbol<>();
        return getPadre(valor, this.raiz, padre);
    }

    public void guardarArbol() {
        String rutaArchivo = "arbol.json";
        Gson1.guardarObjetoEnArchivo(rutaArchivo, this);
        ArbolBinarioDeBusqueda arbolCargado = Gson1.cargarObjetoDesdeArchivo(rutaArchivo, ArbolBinarioDeBusqueda.class);
        if (arbolCargado != null) {
            System.out.println("Arbol Cargado");
        }
    }

    public String showNode(NodoArbol<TipoDeDatos> n) {
        String res = "";
        if (n.getIzquierda() != null) {
            res += showNode(n.izquierda);
        }
        res += "\nNode " + n.dato;
        if (n.getDerecha() != null) {
            res += showNode(n.derecha);
        }

        return res;
    }

    public String showEnlaces(NodoArbol<TipoDeDatos> n) {
        String res = "";
        if (n.getIzquierda() != null) {
            res += "\n" + n.dato + "--" + n.izquierda.dato;
            res += showEnlaces(n.izquierda);
        }
        if (n.getDerecha() != null) {
            res += "\n" + n.dato + "--" + n.derecha.dato;
            res += showEnlaces(n.derecha);
        }

        return res;
    }

    public String show() {
        NodoArbol<TipoDeDatos> raiz = this.raiz;
        return showNode(raiz) + "\n" + showEnlaces(raiz);
    }


    public String toStringI(NodoArbol<Individuo> n) {
        String res = "";

        if (n.getIzquierda() != null) {
            res += ":";
            res += toStringI(n.izquierda);
        }

        if (n.getDerecha() != null) {
            res += ":";
            res += toStringI(n.derecha);
        }
        Individuo ind = n.dato;
        res += ind.toString();
        return res;
    }

    public void crearPNG(String diagramText) throws FileNotFoundException {

    }//tree view

    public static void main(String[] args) throws FileNotFoundException {
//        ArbolBinarioDeBusqueda<Integer > arbol2 = new ArbolBinarioDeBusqueda<>();
//        arbol2.add(30);
//        arbol2.add(40);
//        arbol2.add(20);
//        arbol2.add(10);
//        arbol2.add(25);
//        arbol2.add(35);
//        System.out.println(arbol2.toString());
        ArbolBinarioDeBusqueda<Individuo> arbol3 = new ArbolBinarioDeBusqueda<>();
        Individuo ind = new IndAvanzado(45);
//        System.out.println(ind.getArbolGenealogico().raiz.dato);
        Individuo ind2 = new IndAvanzado(50);
//        System.out.println(ind2.getArbolGenealogico().raiz.dato);
        System.out.println(ind.getArbolGenealogico().toStringI(ind.getArbolGenealogico().raiz));
        ind.getArbolGenealogico().raiz.setDerecha(ind2.getArbolGenealogico().raiz);
//        System.out.println("ind1 "+ind.getArbolGenealogico().toString());
        System.out.println("ind: " + ind);


        /***
         arbol3.add(ind);
         System.out.println(ind);
         System.out.println(arbol3.raiz.dato.toString());
         Individuo ind1 = new IndAvanzado(50);
         Individuo ind2 = new IndAvanzado(60);
         ArbolBinarioDeBusqueda<Individuo> arbol4 = new ArbolBinarioDeBusqueda<>(ind1);
         arbol4.raiz.derecha = arbol3.raiz;*/

//        System.out.println(arbol4.);

    }


}


