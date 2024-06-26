package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.HelloApplication;
import com.example.demojavafx.ed.*;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class IndAvanzado extends Individuo {
    private static final Logger log = LogManager.getLogger(IndAvanzado.class);
    NodoGrafoNuevo nodoIndividuo;
    ListaSimple<NodoGrafoNuevo> listaMovimiento = new ListaSimple<>();



    public IndAvanzado(int id) {
        super(id);
    }
//
    public IndAvanzado(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
    }

    public IndAvanzado(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
    }

    public IndAvanzado(int id, int gerenacion, int turnosRestantes) {
        super(id, gerenacion, turnosRestantes);
    }


    public IndAvanzado(int id, int generacion, int turnosRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM, ArbolBinarioDeBusqueda<Individuo> arbolGenealogico, Cola colaOperaciones, int contadorReproduccion, int contadorClonacion, int contadorAgua, int contadorIndividuoLongevo) {
        super(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM, arbolGenealogico, colaOperaciones, contadorReproduccion, contadorClonacion, contadorAgua, contadorIndividuoLongevo);
    }

    public ListaSimple<NodoGrafoNuevo> creacionListaMovimiento (int maxFilas, int maxColumnas, Celda[][] matriz){
         ListaSimple<NodoGrafoNuevo> listaNodos = new ListaSimple<>();
         ListaSimple<ArcoGrafoNuevo> listaArcos = new ListaSimple<>();
         GrafoNuevo<Celda> grafo = new GrafoNuevo<>(listaNodos,listaArcos);
         Cola <NodoGrafoNuevo> colaCeldasConRecurso = new Cola<>();
         for (int i = 0; i <= maxFilas-1; i++) {
            for (int j = 0; j <= maxColumnas-1; j++) {
                Celda c = matriz[i][j];
                NodoGrafoNuevo nodo = new NodoGrafoNuevo<>(c,i,j);
                grafo.addNodo(nodo);
                if (i==this.posN && j==this.posM){
                    nodoIndividuo = nodo;
                }
                if (!c.getListaRecurso().isVacia()){
                    if (i!=this.posN || j!=this.posM) {
                        colaCeldasConRecurso.push(new ElementoLDE<>(nodo));
                    }
                }
            }
         }
         //Enlaces de filas de forma ascendente
         for (int r = 0; r<= grafo.getListaVertices().getNumeroElementos()-2;r++) {
             if (((r+1)%(maxColumnas))!=0) {
                 NodoGrafoNuevo nodo1 = grafo.getListaVertices().getElemento(r).getData();
                 NodoGrafoNuevo nodo2 = grafo.getListaVertices().getElemento(r + 1).getData();
                 Double pesoArco = 1.0;
                 if (!matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().isVacia()) {
                     String relacion = "";
                     for (int m = 0; m <= matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getNumeroElementos() - 1; m++) {

                         Recursos recurso = matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getElemento(m).getData();
                         if (Agua.class == recurso.getClass()) {
                             pesoArco += 4.0;
                             relacion= "Agua";
                         } else if (Comida.class == recurso.getClass()) {
                             pesoArco += 3.0;
                             relacion= "Comida";
                         } else if (Montana.class == recurso.getClass()) {
                             pesoArco += 10.0;
                             relacion = "Montaña";
                         } else if (Tesoro.class == recurso.getClass()) {
                             pesoArco += 5.0;
                             relacion = "Tesoro";
                         } else if (Biblioteca.class == recurso.getClass()) {
                             pesoArco += 7.0;
                             relacion = "Biblioteca";
                         } else if (Pozo.class == recurso.getClass()) {
                             pesoArco += 20.0;
                             relacion = "Pozo";
                         }
                     }
                     ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>(relacion, nodo1, nodo2, pesoArco);
                     grafo.addArco(arco1);
                 }else {
                     ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>("arco sin recurso", nodo1, nodo2, pesoArco);
                     grafo.addArco(arco1);
                 }
             }

         }
         // Enlaces de filas de forma descente
        for (int z = grafo.getListaVertices().getNumeroElementos()-2; z>= 0;z--) {
            if (((z+1)%(maxColumnas))!=0) {
                NodoGrafoNuevo nodo1 = grafo.getListaVertices().getElemento(z).getData();
                NodoGrafoNuevo nodo2 = grafo.getListaVertices().getElemento(z + 1).getData();
                Double pesoArco = 1.0;
                if (!matriz[nodo1.getPosN()][nodo1.getPosM()].getListaRecurso().isVacia()) {
                    String relacion="";
                    for (int k = 0; k <= matriz[nodo1.getPosN()][nodo1.getPosM()].getListaRecurso().getNumeroElementos() - 1; k++) {

                        Recursos recurso = matriz[nodo1.getPosN()][nodo1.getPosM()].getListaRecurso().getElemento(k).getData();
                        if (Agua.class == recurso.getClass()) {
                            pesoArco += 4.0;
                            relacion= "Agua";
                        } else if (Comida.class == recurso.getClass()) {
                            pesoArco += 3.0;
                            relacion= "Comida";
                        } else if (Montana.class == recurso.getClass()) {
                            pesoArco += 10.0;
                            relacion = "Montaña";
                        } else if (Tesoro.class == recurso.getClass()) {
                            pesoArco += 5.0;
                            relacion = "Tesoro";
                        } else if (Biblioteca.class == recurso.getClass()) {
                            pesoArco += 7.0;
                            relacion = "Biblioteca";
                        } else if (Pozo.class == recurso.getClass()) {
                            pesoArco += 20.0;
                            relacion = "Pozo";
                        }

                    }
                    ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>(relacion, nodo2, nodo1, pesoArco);
                    grafo.addArco(arco1);
                }else {
                    ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>("arco sin recurso", nodo2, nodo1, pesoArco);
                    grafo.addArco(arco1);
                }
            }

        }
        //Enlaces de columnas de forma ascendente
        for (int l = 0; l<= grafo.getListaVertices().getNumeroElementos()-1-maxColumnas;l++) {
            //if (((l+1)%(maxFilas))==0) {
            NodoGrafoNuevo nodo1 = grafo.getListaVertices().getElemento(l).getData();
            NodoGrafoNuevo nodo2 = grafo.getListaVertices().getElemento(l + maxFilas).getData();
            Double pesoArco = 1.0;
            if (!matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().isVacia()) {
                String relacion="";
                for (int u = 0; u <= matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getNumeroElementos() - 1; u++) {

                    Recursos recurso = matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getElemento(u).getData();
                    if (Agua.class == recurso.getClass()) {
                        pesoArco += 4.0;
                        relacion= "Agua";
                    } else if (Comida.class == recurso.getClass()) {
                        pesoArco += 3.0;
                        relacion= "Comida";
                    } else if (Montana.class == recurso.getClass()) {
                        pesoArco += 10.0;
                        relacion = "Montaña";
                    } else if (Tesoro.class == recurso.getClass()) {
                        pesoArco += 5.0;
                        relacion = "Tesoro";
                    } else if (Biblioteca.class == recurso.getClass()) {
                        pesoArco += 7.0;
                        relacion = "Biblioteca";
                    } else if (Pozo.class == recurso.getClass()) {
                        pesoArco += 20.0;
                        relacion = "Pozo";
                    }
                }
                ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>(relacion, nodo1, nodo2, pesoArco);
                grafo.addArco(arco1);
            } else {
                ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>("arco sin recurso", nodo1, nodo2, pesoArco);
                grafo.addArco(arco1);
            }


        }
        // Enlaces de columnas de forma descente
        for (int s = grafo.getListaVertices().getNumeroElementos() - 1; s >= maxColumnas; s--) {
            //if (((s+1)%(maxColumnas))!=0) {
            NodoGrafoNuevo nodo1 = grafo.getListaVertices().getElemento(s).getData();
            NodoGrafoNuevo nodo2 = grafo.getListaVertices().getElemento(s - maxFilas).getData();
            Double pesoArco = 1.0;
            if (!matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().isVacia()) {
                String relacion = "";
                for (int p = 0; p <= matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getNumeroElementos() - 1; p++) {

                    Recursos recurso = matriz[nodo2.getPosN()][nodo2.getPosM()].getListaRecurso().getElemento(p).getData();
                    if (Agua.class == recurso.getClass()) {
                        pesoArco += 4.0;
                        relacion= "Agua";
                    } else if (Comida.class == recurso.getClass()) {
                        pesoArco += 3.0;
                        relacion= "Comida";
                    } else if (Montana.class == recurso.getClass()) {
                        pesoArco += 10.0;
                        relacion = "Montaña";
                    } else if (Tesoro.class == recurso.getClass()) {
                        pesoArco += 5.0;
                        relacion = "Tesoro";
                    } else if (Biblioteca.class == recurso.getClass()) {
                        pesoArco += 7.0;
                        relacion = "Biblioteca";
                    } else if (Pozo.class == recurso.getClass()) {
                        pesoArco += 20.0;
                        relacion = "Pozo";
                    }
                }
                ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>(relacion, nodo1, nodo2, pesoArco);
                grafo.addArco(arco1);
            } else {
                ArcoGrafoNuevo arco1 = new ArcoGrafoNuevo<>("arco sin recurso", nodo1, nodo2, pesoArco);
                grafo.addArco(arco1);

            }

        }


        nodoIndividuo.setDato("NodoIndividuoInicio");


        ListaSimple<NodoGrafoNuevo> listaNodosHastaRecursos = new ListaSimple<>();
        Double pesoCamino = Double.MAX_VALUE;
        while (!colaCeldasConRecurso.isVacia()) {
            Cola<Camino<String>> caminos = grafo.dijkstra(nodoIndividuo);
            NodoGrafoNuevo nodoConRecurso = colaCeldasConRecurso.pop().getData();
            int posicionNodoConRecurso = grafo.getListaVertices().getPosicion(new ElementoLS<>(nodoConRecurso));
            ElementoLDE<Camino> caminoHastaRecurso = caminos.getElemento(posicionNodoConRecurso);
            if (caminoHastaRecurso.getData().coste < pesoCamino) {
                listaNodosHastaRecursos = caminoHastaRecurso.getData().getCamino();
                pesoCamino = caminoHastaRecurso.getData().coste;
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Creacion lista movimiento individuo avanzado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return listaNodosHastaRecursos;

    }


    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        int posNGuardado = this.posN;
        int posMGuardado = this.posM;

        if (listaMovimiento.isVacia()){
            listaMovimiento = creacionListaMovimiento (maxFilas,maxColumnas,matriz);
            if (listaMovimiento.getNumeroElementos()>1) {
                listaMovimiento.del(0);
            }
        }
        matriz[posNGuardado][posMGuardado].eliminarIndividuo(this);
        NodoGrafoNuevo nodoMovimiento = listaMovimiento.getElemento(0).getData();

        int posNNueva = nodoMovimiento.getPosN();
        int posMNueva = nodoMovimiento.getPosM();

        this.setPosN(posNNueva);
        this.setPosM(posMNueva);
        int posNodoAEliminar = listaMovimiento.getPosicion(new ElementoLS<>(nodoMovimiento));
        listaMovimiento.del(posNodoAEliminar);
        matriz[this.posN][this.posM].addIndividuo(this);
        colaOperaciones.push(new ElementoLDE<>("movimiento"));

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Movimiento individuo avanzado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

    }

    public String toStringArbol(NodoArbol<Individuo> n) {
        String res = "";
        res += "IND AVANZADO=[ posM=" + n.getDato().posM + "; posN=" + n.getDato().posN +
                "; probMuerte=" + n.getDato().probMuerte +
                "; probClonacion=" + n.getDato().probClonacion +
                "; probReproduccion=" + n.getDato().probReproduccion +
                "; turnosRestantes=" + n.getDato().turnosRestantes +
                "; generacion=" + n.getDato().generacion +
                "; id=" + n.getDato().id + " ]";
        if (n.getIzquierda() != null) {
            res += ":";
            res += toStringArbol(n.getIzquierda());
        }

        if (n.getDerecha() != null) {
            res += ":";
            res += toStringArbol(n.getDerecha());
        }

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() individuo avanzado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return res;
    }

    public String toStringArbol() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() individuo avanzado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return toStringArbol(this.arbolGenealogico.raiz);
    }

    @Override
    public String toString() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() individuo avanzado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return "IndAvanzado, {" +
                "posM=" + posM +
                ", posN=" + posN +
                ", probMuerte=" + probMuerte +
                ", probClonacion=" + probClonacion +
                ", probReproduccion=" + probReproduccion +
                ", turnosRestantes=" + turnosRestantes +
                ", generacion=" + generacion +
                ", id=" + id +
                ", arbolGenealogico=" + toStringArbol() +
                ", }";
    }
}
