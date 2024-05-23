package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.HelloApplication;
import com.example.demojavafx.ed.*;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.Recursos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class IndNormal extends Individuo {

    private static final Logger log = LogManager.getLogger(IndNormal.class);

    Recursos recursoDeseado = null;
    int posNDeseado;
    int posMDeseado;
    ListaEnlazada<Integer> listaMovimiento = new ListaEnlazada<>();


    public IndNormal(int id) {
        super(id);
    }

    public IndNormal(int id, int gerenacion, int turnsRestantes) {
        super(id, gerenacion, turnsRestantes);
    }

    public IndNormal(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
    }

    public IndNormal(int id, int generacion, int turnosRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM, ArbolBinarioDeBusqueda<Individuo> arbolGenealogico, Cola colaOperaciones, int contadorReproduccion, int contadorClonacion, int contadorAgua, int contadorIndividuoLongevo) {
        super(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM, arbolGenealogico, colaOperaciones, contadorReproduccion, contadorClonacion, contadorAgua, contadorIndividuoLongevo);
    }

    public ListaEnlazada<Integer> creacionListaMovimiento(int posNDeseado, int posMDeseado, int posN, int posM, Celda[][] matriz) {
        if (posN == posNDeseado && posM == posMDeseado) {
            return listaMovimiento.invertir();
        } else {
            int n = posN - posNDeseado;
            int m = posM - posMDeseado;
            if (m >= 0 && n >= 0) {
                if (m > n) {
                    listaMovimiento.add(this.posM - 1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM - 1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM - 1, matriz);
                } else {
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN - 1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN - 1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN - 1, posM, matriz);
                }
            } else if (m <= 0 && n <= 0) {
                n = n * (-1);
                m = m * (-1);
                if (m > n) {
                    listaMovimiento.add(this.posM + 1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM + 1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM + 1, matriz);
                } else {
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN + 1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN + 1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN + 1, posM, matriz);
                }
            } else if (m >= 0 && n <= 0) {
                n = n * (-1);
                if (m > n) {
                    listaMovimiento.add(this.posM - 1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM - 1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM - 1, matriz);
                } else {
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN + 1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN + 1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN + 1, posM, matriz);
                }
            } else {
                m = m * (-1);
                if (m > n) {
                    listaMovimiento.add(this.posM + 1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM + 1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM + 1, matriz);
                } else {
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN - 1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN - 1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN - 1, posM, matriz);
                }
            }
        }

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Creacion lista movimiento individuo normal");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        return listaMovimiento.invertir();


    }

    public IndNormal(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
    }

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        int posNGuardado = this.posN;
        int posMGuardado = this.posM;
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        if (recursoDeseado == null) {
            //Se pueden recorrer filas y columnas a la vez
            for (int i = 0; i < maxFilas; i++) {
                for (int j = 0; j < maxColumnas; j++) {
                    for (int h = 0; h < matriz[i][j].getListaRecurso().getNumeroElementos(); h++) {
                        Recursos recurso = matriz[i][j].getListaRecurso().getElemento(h).getData();
                        if (this.posN != i || this.posM != j) {
                            listaOpciones.add(recurso);
                        }
                    }
                }
            }
            Random rand = new Random();
            int random = rand.nextInt(listaOpciones.getNumeroElementos());
            recursoDeseado = listaOpciones.getElemento(random).getData();
            posNDeseado = listaOpciones.getElemento(random).getData().getPosN();
            posMDeseado = listaOpciones.getElemento(random).getData().getPosM();
            ListaEnlazada<Integer> listaMovimiento1 = new ListaEnlazada<>();
            listaMovimiento = creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM, matriz);


        }
        if (!listaMovimiento.isVacia()) {
            matriz[posNGuardado][posMGuardado].eliminarIndividuo(this);
            ElementoLDE celdaRecorrida = new ElementoLDE<>(matriz[posNGuardado][posMGuardado]);
            int posMNueva = listaMovimiento.getElemento(0).getData();
            int posNNueva = listaMovimiento.getElemento(1).getData();
            this.setPosN(posNNueva);
            this.setPosM(posMNueva);
            int posNAEliminar = listaMovimiento.getPosicion(new ElementoLE<>(posNNueva));
            int posMAEliminar = listaMovimiento.getPosicion(new ElementoLE<>(posMNueva));
            listaMovimiento.delete(posNAEliminar);
            listaMovimiento.delete(posMAEliminar);
            matriz[this.posN][this.posM].addIndividuo(this);
            colaOperaciones.push(new ElementoLDE<>("movimiento"));
        } else {
            recursoDeseado = null;
            moverse(maxColumnas, maxFilas, matriz);
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Movimiento individuo normal");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public String toStringArbol(NodoArbol<Individuo> n) {
        String res = "";
        res += "IND NORMAL=[ posM=" + n.getDato().posM + "; posN=" + n.getDato().posN +
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
        log.info("Funcion toString() del individuo normal");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        return res;
    }

    public String toStringArbol() {

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() del individuo normal");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        return toStringArbol(this.arbolGenealogico.raiz);
    }

    @Override
    public String toString() {

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion toString() del individuo normal");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

        return "IndNormal, {" +
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
