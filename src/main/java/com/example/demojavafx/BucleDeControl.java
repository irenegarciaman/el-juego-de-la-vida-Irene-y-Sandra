package com.example.demojavafx;

import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.ed.NodoArbol;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.*;

import java.util.Random;

public class BucleDeControl {
    private int columna;
    private int fila;
    public Celda matriz[][];
    int turno=0;


    /**
     * Constructor
     **/
    public BucleDeControl(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        this.matriz = new Celda[fila][columna];
       for (int i= 0; i<fila; i++){
            for (int j= 0; j<columna;j++){
                Celda n = new Celda();
                this.matriz[i][j]=n;
            }
        }

    }
    public void addCosas() throws Superar3Recursos, Superar3Individuos {
        IndBasico ind1 = new IndBasico(222,4,6);
        IndNormal ind2 = new IndNormal(333,6,7);
        IndAvanzado ind3 = new IndAvanzado(444, 9,1);
        Agua agua = new Agua(3,4);
        Comida comida = new Comida(2,3);
        Montana montana = new Montana(4,5);
        Biblioteca biblioteca = new Biblioteca(3,45);
        Tesoro tesoro = new Tesoro(3,32);
        Pozo pozo = new Pozo(6);
        matriz[0][2].addRecurso(agua);
        //matriz[0][2].addRecurso(tesoro);
        //matriz[0][2].addRecurso(biblioteca);
        matriz[1][0].addRecurso(comida);
        matriz[1][2].addRecurso(montana);
        matriz[1][1].addRecurso(pozo);
        matriz[0][2].addIndividuo(ind1);
        matriz[1][0].addIndividuo(ind2);
        matriz[1][2].addIndividuo(ind3);


    }




    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }



    public void actualizarIndividuo(){
        for(int i=0;i<=columna-1;i++){
            for(int j=0;j<=fila-1;j++){
                for(int k=0;k<=matriz[j][i].getListaIndividuo().getNumeroElementos()-1 ;k++){
                    Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    individuo.setTurnosRestantes(individuo.getTurnosRestantes()-1);
                    individuo.setProbReproduccion(individuo.getProbReproduccion()-10);
                    individuo.setProbClonacion(individuo.getProbClonacion()-10);
                    if(individuo.getTurnosRestantes()==0){
                        matriz[j][i].eliminarIndividuo(individuo);
                    }
                }
            }
        }
    }
    public void actualizarRecursos(){
        for(int i=0;i<columna;i++){
            for(int j=0;j<fila;j++){
                for(int k=0;k<=matriz[j][i].getListaRecurso().getNumeroElementos()-1 ;k++){
                    Recursos recurso = matriz[j][i].getListaRecurso().getElemento(k).getData();
                    recurso.setTurnosRestantes(recurso.getTurnosRestantes()-1);
                    if(recurso.getTurnosRestantes()==0){
                        matriz[j][i].eliminarRecurso(recurso);
                    }
                }
            }
        }
    }

    public void movimiento() throws Superar3Individuos {
        ListaEnlazada<Integer> listaId = new ListaEnlazada<>();
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    int id = matriz[j][i].getListaIndividuo().getElemento(k).getData().getId();
                    listaId.add(id);
                }
            }
        }
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                        int id2 = matriz[j][i].getListaIndividuo().getElemento(k).getData().getId();
                        ElementoLE<Integer> elem = new ElementoLE<>(id2);
                        if (listaId.getPosicion(elem) != -1) {
                            Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                            individuo.moverse(columna, fila, matriz);
                            int pos = listaId.getPosicion(new ElementoLE<>(id2));
                            listaId.delete(pos);
                            if (listaId.isVacia()){
                                break;
                            }
                        }

                }
            }
        }
    }

    public void mejorasRecursos (){
        for(int i=0;i<columna;i++){
            for(int j=0;j<fila;j++){
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    for(int h=0;h<= matriz[j][i].getListaRecurso().getNumeroElementos()-1 ;h++){
                        Recursos recurso = matriz[j][i].getListaRecurso().getElemento(h).getData();
                        Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                        if (recurso.getClass() == Agua.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()+((Agua) recurso).getAumentoDeVida());
                        }else if(recurso.getClass() == Comida.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()+((Comida) recurso).getAumentoDeVida());
                        }else if (recurso.getClass() == Montana.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()-((Montana) recurso).getDisminucionDeVida());
                        }else if (recurso.getClass() == Tesoro.class){
                            individuo.setProbReproduccion(individuo.getProbReproduccion()+((Tesoro) recurso).getAumentoDePorcenRep());
                        }else if (recurso.getClass() == Biblioteca.class){
                            individuo.setProbClonacion(individuo.getProbClonacion()+((Biblioteca)recurso).getAumentoDePorcenClon());
                        }else if (recurso.getClass() == Pozo.class){
                            matriz[j][i].eliminarIndividuo(individuo);
                        }
                    }
                }
            }

        }

    }

    public void reproducion() throws Superar3Individuos {
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    if (k==1){
                        Random rand = new Random();
                        int random =rand.nextInt(101);
                        Individuo ind1 = matriz[j][i].getListaIndividuo().getElemento(0).getData();
                        Individuo ind2 = matriz[j][i].getListaIndividuo().getElemento(1).getData();
                        if (random<ind1.getProbReproduccion() && random<ind2.getProbReproduccion()) {
                            if (ind1.getClass() == IndAvanzado.class || ind2.getClass() == IndAvanzado.class) {
                                IndAvanzado ind3 = new IndAvanzado(ind1.getId() + 1, turno, ind1.getTurnosRestantes()+2);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                                matriz[j][i].addIndividuo(ind3);
                            } else if (ind1.getClass() == IndNormal.class || ind2.getClass() == IndNormal.class) {
                                IndNormal ind3 = new IndNormal(ind1.getId() + 1, turno, ind1.getTurnosRestantes()+2);
                                matriz[j][i].addIndividuo(ind3);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                            } else {
                                IndBasico ind3 = new IndBasico(ind1.getId() + 1, turno, ind1.getTurnosRestantes()+2);
                                matriz[j][i].addIndividuo(ind3);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                            }

                        }else {
                            matriz[j][i].eliminarIndividuo(ind1);
                            matriz[j][i].eliminarIndividuo(ind2);
                        }
                    }
                }
            }
        }
    }

    public void clonacion() throws Superar3Individuos {
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo ind1 = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    Random rand = new Random();
                    int random =rand.nextInt(101);
                    if (random<ind1.getProbClonacion()){
                        Individuo clonado = ind1;
                        NodoArbol<Individuo> nodoNuevo = new NodoArbol<>(clonado);
                        nodoNuevo.setDerecha(ind1.getArbolGenealogico().raiz);
                        nodoNuevo.setIzquierda(null);
                        clonado.getArbolGenealogico().raiz = nodoNuevo;
                        matriz[j][i].addIndividuo(clonado);
                        break;//Para que solo clone el individuo una vez
                    }
                }
            }
        }
    }

    public void nuevoRecurso() throws Superar3Recursos {
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for(int k=0;k<=matriz[j][i].getListaRecurso().getNumeroElementos()-1 ;k++){
                    if (matriz[j][i].getListaRecurso().getNumeroElementos()<3){
                        Random rand = new Random();
                        int random = rand.nextInt(101);
                        Recursos recurso = matriz[j][i].getListaRecurso().getElemento(k).getData();
                        if (random>recurso.getProbNuevoRecurso()){
                            Agua agua = new Agua();
                            Comida comida = new Comida();
                            Biblioteca biblioteca = new Biblioteca();
                            Tesoro tesoro = new Tesoro();
                            Pozo pozo = new Pozo();
                            Montana montana = new Montana();
                            int probTotal = (agua.getProbAgua() + comida.getProbComida() + biblioteca.getProbBiblioteca() + tesoro.getProbTesoro() + pozo.getProbPozo() + montana.getProbMontana());
                            Random rand2 = new Random();
                            int random2 = rand2.nextInt(probTotal+1);
                            if (random2<agua.getProbAgua()){
                                matriz[j][i].addRecurso(agua);
                            }else if (random2<comida.getProbComida()){
                                matriz[j][i].addRecurso(comida);
                            }else if (random2<biblioteca.getProbBiblioteca()){
                                matriz[j][i].addRecurso(biblioteca);
                            }else if (random2<tesoro.getProbTesoro()){
                                matriz[j][i].addRecurso(tesoro);
                            } else if (random2<pozo.getProbPozo()) {
                                matriz[j][i].addRecurso(pozo);
                            } else if (random2<montana.getProbMontana()) {
                                matriz[j][i].addRecurso(montana);
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean condicionFinalizacion(){
        ListaEnlazada<Individuo> lista = new ListaEnlazada<>();
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    lista.add(new ElementoLE<>(matriz[j][i].getListaIndividuo().getElemento(k).getData()));
                }
            }
        }
        return lista.getNumeroElementos() == 1;
    }

    public void bucleEntero() throws Superar3Individuos, Superar3Recursos {
        actualizarIndividuo();
        actualizarRecursos();
        movimiento();
        mejorasRecursos();
        reproducion();
        clonacion();
        nuevoRecurso();
        if (!condicionFinalizacion()){
            turno++;
            bucleEntero();
        }//else, funcion finalizar juego

    }
}
