package com.example.demojavafx;

import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
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
        this.matriz = new Celda[fila][columna];
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
        for(int i=0;i<columna;i++){
            for(int j=0;j<fila;j++){
                for(int k=0;k<=matriz[j][i].getListaIndividuo().getNumeroElementos()-1 ;k++){
                    Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    individuo.setTurnosRestantes(individuo.getTurnosRestantes()-1);
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

    public void movimiento(){
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    individuo.moverse(columna, fila, matriz);
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
                    if (k==2){
                        Random rand = new Random();
                        int random =rand.nextInt(101);
                        Individuo ind1 = matriz[j][i].getListaIndividuo().getElemento(0).getData();
                        Individuo ind2 = matriz[j][i].getListaIndividuo().getElemento(1).getData();
                        if (random<ind1.getProbReproduccion() && random<ind2.getProbReproduccion()) {
                            if (ind1.getClass() == IndAvanzado.class || ind2.getClass() == IndAvanzado.class) {
                                IndAvanzado ind3 = new IndAvanzado(ind1.getId() + 1, turno);
                                matriz[j][i].addIndividuo();
                            } else if (ind1.getClass() == IndNormal.class || ind2.getClass() == IndNormal.class) {
                                IndNormal ind3 = new IndNormal(ind1.getId(), turno);
                                matriz[j][i].addIndividuo();
                            } else {
                                IndBasico ind3 = new IndBasico(ind1.getId() + 1, turno);
                                matriz[j][i].addIndividuo();
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
                        matriz[j][i].addIndividuo();
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
}
