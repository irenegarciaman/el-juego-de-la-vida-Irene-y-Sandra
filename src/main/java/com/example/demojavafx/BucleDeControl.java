package com.example.demojavafx;

import com.example.demojavafx.ed.*;
import com.example.demojavafx.excepciones.PorcentajeValido;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Random;

import static com.example.demojavafx.individuos.Individuo.fromStringI;


public class BucleDeControl {
    private int columna;
    private int fila;
    public Celda[][] matriz;
    int turno = 0;

    int contadorReproduccionesTotales = 0;
    int contadorClonacionesTotales = 0;

    ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
    ListaEnlazada<Integer> listaIdIndividuos = new ListaEnlazada<>();

    ListaEnlazada<Integer> listaVidaMaxima = new ListaEnlazada<>();

    private static final Logger log = LogManager.getLogger(BucleDeControl.class);



    public BucleDeControl(int fila, int columna) {
        this.columna = columna;
        this.fila = fila;
        this.matriz = new Celda[fila][columna];
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                Celda n = new Celda();
                this.matriz[i][j] = n;
            }
        }

    }


    public int getColumna() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el numero de columnas de la matriz");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return columna;
    }

    public void setColumna(int columna) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el numero de columnas de la matriz");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.columna = columna;
    }

    public int getFila() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el numero de filas de la matriz");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return fila;
    }

    public void setFila(int fila) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el numero de filas de la matriz");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.fila = fila;
    }


    public void actualizarIndividuo() {
        for (int i = 0; i <= columna - 1; i++) {
            for (int j = 0; j <= fila - 1; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    individuo.setTurnosRestantes(individuo.getTurnosRestantes() - 1);
                    individuo.setProbReproduccion(individuo.getProbReproduccion() - 10);
                    individuo.setProbClonacion(individuo.getProbClonacion() - 10);
                    individuo.setContadorIndividuoLongevo(individuo.getContadorIndividuoLongevo()+1);
                    if (individuo.getTurnosRestantes() == 0) {
                        matriz[j][i].eliminarIndividuo(individuo);
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para actualizar ciertos parametros de los individuos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void actualizarRecursos() {
        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaRecurso().getNumeroElementos() - 1; k++) {
                    Recursos recurso = matriz[j][i].getListaRecurso().getElemento(k).getData();
                    recurso.setTurnosRestantes(recurso.getTurnosRestantes() - 1);
                    if (recurso.getTurnosRestantes() == 0) {
                        matriz[j][i].eliminarRecurso(recurso);
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para actualizar el numero de vida de los recursos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void movimiento() throws Superar3Individuos {
        ListaEnlazada<Integer> listaId = new ListaEnlazada<>();
        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    int id = matriz[j][i].getListaIndividuo().getElemento(k).getData().getId();
                    listaId.add(id);
                }
            }
        }
        for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                int k = 0;
                for (; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() -1;) {

                    int id2 = matriz[j][i].getListaIndividuo().getElemento(k).getData().getId();
                    ElementoLE elem = new ElementoLE<>(id2);
                    if (!listaId.isVacia()) {//Lo he añadido nuevo
                        if (listaId.getPosicion(elem) != -1) {
                            Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                            int pos = listaId.getPosicion(new ElementoLE<>(id2));
                            listaId.delete(pos);
                            individuo.moverse(columna, fila, matriz);
                            if (listaId.isVacia()) {
                                break;
                            }
                        }else{
                            k++;
                        }
                    }else{
                        k++;
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para realizazr el movimiento de los individuos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void mejorasRecursos (){
        for(int i=0;i<columna;i++){
            for(int j=0;j<fila;j++){
                for (int k = 0; k <= matriz[j][i].getListaRecurso().getNumeroElementos() - 1; k++) {
                    for(int h=0;h<= matriz[j][i].getListaIndividuo().getNumeroElementos()-1 ;h++){
                        Recursos recurso = matriz[j][i].getListaRecurso().getElemento(k).getData();
                        Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(h).getData();

                        if (recurso.getClass() == Agua.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()+((Agua) recurso).getAumentoDeVida());
                            individuo.getColaOperaciones().push(new ElementoLDE<>("recurso"));
                            individuo.getColaOperaciones().push(new ElementoLDE<>(recurso));
                            individuo.setContadorAgua(individuo.getContadorAgua()+1);
                        }else if(recurso.getClass() == Comida.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()+((Comida) recurso).getAumentoDeVida());
                            individuo.getColaOperaciones().push(new ElementoLDE<>("recurso"));
                            individuo.getColaOperaciones().push(new ElementoLDE<>(recurso));
                        }else if (recurso.getClass() == Montana.class){
                            individuo.setTurnosRestantes(individuo.getTurnosRestantes()-((Montana) recurso).getDisminucionDeVida());
                            individuo.getColaOperaciones().push(new ElementoLDE<>("recurso"));
                            individuo.getColaOperaciones().push(new ElementoLDE<>(recurso));
                        }else if (recurso.getClass() == Tesoro.class){
                            individuo.setProbReproduccion(individuo.getProbReproduccion()+((Tesoro) recurso).getAumentoDePorcenRep());
                            individuo.getColaOperaciones().push(new ElementoLDE<>("recurso"));
                            individuo.getColaOperaciones().push(new ElementoLDE<>(recurso));
                        }else if (recurso.getClass() == Biblioteca.class){
                            individuo.setProbClonacion(individuo.getProbClonacion()+((Biblioteca)recurso).getAumentoDePorcenClon());
                            individuo.getColaOperaciones().push(new ElementoLDE<>("recurso"));
                            individuo.getColaOperaciones().push(new ElementoLDE<>(recurso));
                        }else if (recurso.getClass() == Pozo.class){
                            matriz[j][i].eliminarIndividuo(individuo);
                            individuo.getColaOperaciones().push(new ElementoLDE<>("muerte"));
                        }
                        recurso.setPosN(j);
                        recurso.setPosM(i);
                    }
                }
            }

        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para realizar las mejoras de los recursos en cada uno de los individuos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

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
                            ind1.getColaOperaciones().push(new ElementoLDE<String>("reproduccion"));
                            ind1.getColaOperaciones().push(new ElementoLDE<String>("pareja"));
                            ind1.getColaOperaciones().push(new ElementoLDE<Individuo>(ind2));
                            ind1.setContadorReproduccion(ind1.getContadorReproduccion()+1);
                            ind2.getColaOperaciones().push(new ElementoLDE<String>("reproduccion"));
                            ind2.getColaOperaciones().push(new ElementoLDE<String>("pareja"));
                            ind2.getColaOperaciones().push(new ElementoLDE<Individuo>(ind1));
                            ind2.setContadorReproduccion(ind2.getContadorReproduccion()+1);
                            int idIndividuoHijo=-1;
                            while (idIndividuoHijo==-1) {
                                Random randt = new Random();
                                int randdom = randt.nextInt(1001);
                                int posRandom = conjuntoIdIndividuosTotales().getPosicion(new ElementoLE<>(randdom));
                                if (posRandom==-1) {
                                    idIndividuoHijo = randdom;
                                }
                            }
                            if (ind1.getClass() == IndAvanzado.class || ind2.getClass() == IndAvanzado.class) {
                                IndAvanzado ind3 = new IndAvanzado(idIndividuoHijo, turno, ind1.getTurnosRestantes()+2);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                                matriz[j][i].addIndividuo(ind3);
                                ind3.setPosN(j);
                                ind3.setPosM(i);
                                ind1.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind1.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                ind2.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind2.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                contadorReproduccionesTotales++;
                            } else if (ind1.getClass() == IndNormal.class || ind2.getClass() == IndNormal.class) {
                                IndNormal ind3 = new IndNormal(idIndividuoHijo, turno, ind1.getTurnosRestantes()+2);
                                matriz[j][i].addIndividuo(ind3);
                                ind3.setPosN(j);
                                ind3.setPosM(i);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                                ind1.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind1.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                ind2.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind2.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                contadorReproduccionesTotales++;
                            } else {
                                IndBasico ind3 = new IndBasico(idIndividuoHijo, turno, ind1.getTurnosRestantes()+2);
                                matriz[j][i].addIndividuo(ind3);
                                ind3.setPosN(j);
                                ind3.setPosM(i);
                                ind3.getArbolGenealogico().raiz.setIzquierda(new NodoArbol<>(ind1));
                                ind3.getArbolGenealogico().raiz.setDerecha(new NodoArbol<>(ind2));
                                ind1.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind1.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                ind2.getColaOperaciones().push(new ElementoLDE<String>("hijo"));
                                ind2.getColaOperaciones().push(new ElementoLDE<Individuo>(ind3));
                                contadorReproduccionesTotales++;
                            }


                        }else {
                            matriz[j][i].eliminarIndividuo(ind1);
                            matriz[j][i].eliminarIndividuo(ind2);
                            ind1.getColaOperaciones().push(new ElementoLDE<>("muerte"));
                            ind2.getColaOperaciones().push(new ElementoLDE<>("muerte"));
                        }
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para realizar la reproducion de los individuos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void clonacion() throws Superar3Individuos {
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo ind1 = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    Random rand = new Random();
                    int random =rand.nextInt(101);
                    if (random<ind1.getProbClonacion()){
                        int idIndividuoClonado=-1;
                        while (idIndividuoClonado==-1) {
                            Random randt = new Random();
                            int randdom = randt.nextInt(1001);
                            int posRandom = conjuntoIdIndividuosTotales().getPosicion(new ElementoLE<>(randdom));
                            if (posRandom==-1) {
                                idIndividuoClonado = randdom;
                            }
                        }
                        if (ind1.getClass() == IndBasico.class){
                            IndBasico clonado = new IndBasico(idIndividuoClonado,turno,ind1.getTurnosRestantes(), ind1.getProbReproduccion(), ind1.getProbClonacion(),ind1.getProbMuerte(),ind1.getPosN(), ind1.getPosM());
                            clonado.setContadorReproduccion(0);
                            clonado.setContadorClonacion(0);
                            Cola colaOperacionesNueva = new Cola<>();
                            clonado.setColaOperaciones(colaOperacionesNueva);
                            NodoArbol<Individuo> nodoNuevo = new NodoArbol<>(clonado);
                            nodoNuevo.setDerecha(ind1.getArbolGenealogico().raiz);
                            nodoNuevo.setIzquierda(null);
                            clonado.getArbolGenealogico().raiz = nodoNuevo;
                            matriz[j][i].addIndividuo(clonado);
                            ind1.getColaOperaciones().push(new ElementoLDE<>("clonacion"));
                            ind1.getColaOperaciones().push(new ElementoLDE<>(clonado));
                        }else if (ind1.getClass() == IndNormal.class){
                            IndNormal clonado = new IndNormal(idIndividuoClonado,turno,ind1.getTurnosRestantes(), ind1.getProbReproduccion(), ind1.getProbClonacion(),ind1.getProbMuerte(),ind1.getPosN(), ind1.getPosM());
                            clonado.setContadorReproduccion(0);
                            clonado.setContadorClonacion(0);
                            Cola colaOperacionesNueva = new Cola<>();
                            clonado.setColaOperaciones(colaOperacionesNueva);
                            NodoArbol<Individuo> nodoNuevo = new NodoArbol<>(clonado);
                            nodoNuevo.setDerecha(ind1.getArbolGenealogico().raiz);
                            nodoNuevo.setIzquierda(null);
                            clonado.getArbolGenealogico().raiz = nodoNuevo;
                            matriz[j][i].addIndividuo(clonado);
                            ind1.getColaOperaciones().push(new ElementoLDE<>("clonacion"));
                            ind1.getColaOperaciones().push(new ElementoLDE<>(clonado));
                        }else if (ind1.getClass() == IndAvanzado.class){
                            IndAvanzado clonado = new IndAvanzado(idIndividuoClonado,turno,ind1.getTurnosRestantes(), ind1.getProbReproduccion(), ind1.getProbClonacion(),ind1.getProbMuerte(),ind1.getPosN(), ind1.getPosM());
                            clonado.setContadorReproduccion(0);
                            clonado.setContadorClonacion(0);
                            Cola colaOperacionesNueva = new Cola<>();
                            clonado.setColaOperaciones(colaOperacionesNueva);
                            NodoArbol<Individuo> nodoNuevo = new NodoArbol<>(clonado);
                            nodoNuevo.setDerecha(ind1.getArbolGenealogico().raiz);
                            nodoNuevo.setIzquierda(null);
                            clonado.getArbolGenealogico().raiz = nodoNuevo;
                            matriz[j][i].addIndividuo(clonado);
                            ind1.getColaOperaciones().push(new ElementoLDE<>("clonacion"));
                            ind1.getColaOperaciones().push(new ElementoLDE<>(clonado));
                        }

                        ind1.setContadorClonacion(ind1.getContadorClonacion()+1);
                        contadorClonacionesTotales++;
                        break;//Para que solo clone el individuo una vez
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para realizar la clonacion de los individuos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void desaparecerIndividuos(){
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    if (individuo.getTurnosRestantes()==0){
                        matriz[j][i].eliminarIndividuo(individuo);
                        individuo.getColaOperaciones().push(new ElementoLDE<>("muerte"));
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para eliminar a los individuos que tienen cero vidas");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void nuevoRecurso() throws Superar3Recursos {
        for(int i=0;i<columna;i++) {
            for (int j = 0; j < fila; j++) {
                if (matriz[j][i].getListaRecurso().getNumeroElementos()<3){
                    Random rand = new Random();
                    int random = rand.nextInt(101);
                    Recursos recurso = new Recursos(2,2,2,60);
                    if (random>recurso.getProbNuevoRecurso()){
                        Agua agua = new Agua(6,1,1,34,4,5);
                        Comida comida = new Comida(3,2,3,2,2,4);
                        Biblioteca biblioteca = new Biblioteca(9,3,1,3,2,1);
                        Tesoro tesoro = new Tesoro(3,0,0,6,2,5);
                        Pozo pozo = new Pozo(3,1,0,8,3);
                        Montana montana = new Montana(5,0,1,8,3,7);
                        int probTotal = (agua.getProbAgua() + comida.getProbComida() + biblioteca.getProbBiblioteca() + tesoro.getProbTesoro() + pozo.getProbPozo() + montana.getProbMontana());
                        Random rand2 = new Random();
                        int random2 = rand2.nextInt(probTotal+1);
                        if (random2<agua.getProbAgua()){
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(agua))==-1) {
                                matriz[j][i].addRecurso(agua);
                                agua.setPosN(j);
                                agua.setPosM(i);
                            }
                        }else if (random2<comida.getProbComida()+agua.getProbAgua()){
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(comida))==-1) {
                                matriz[j][i].addRecurso(comida);
                                comida.setPosN(j);
                                comida.setPosM(i);
                            }
                        }else if (random2<biblioteca.getProbBiblioteca()+comida.getProbComida()+agua.getProbAgua()){
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(biblioteca))==-1) {
                                matriz[j][i].addRecurso(biblioteca);
                                biblioteca.setPosN(j);
                                biblioteca.setPosM(i);
                            }
                        }else if (random2<tesoro.getProbTesoro()+biblioteca.getProbBiblioteca()+comida.getProbComida()+agua.getProbAgua()){
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(tesoro))==-1) {
                                matriz[j][i].addRecurso(tesoro);
                                tesoro.setPosN(j);
                                tesoro.setPosM(i);
                            }
                        } else if (random2<pozo.getProbPozo()+tesoro.getProbTesoro()+biblioteca.getProbBiblioteca()+comida.getProbComida()+agua.getProbAgua()) {
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(pozo))==-1) {
                                matriz[j][i].addRecurso(pozo);
                                pozo.setPosN(j);
                                pozo.setPosM(i);
                            }
                        } else if (random2<montana.getProbMontana()+pozo.getProbPozo()+tesoro.getProbTesoro()+biblioteca.getProbBiblioteca()+comida.getProbComida()+agua.getProbAgua()) {
                            if (matriz[j][i].getListaRecurso().getPosicion(new ElementoLE<>(montana))==-1) {
                                matriz[j][i].addRecurso(montana);
                                montana.setPosN(j);
                                montana.setPosM(i);
                            }
                        }
                    }
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para establecer nuevos recursos en las celdas de la matriz");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
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
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Condicion de finalizacion del juego");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return lista.getNumeroElementos() == 1;
    }



    public void bucleEntero() throws Superar3Individuos, Superar3Recursos {

        actualizarIndividuo();
        actualizarRecursos();
        movimiento();
        mejorasRecursos();
        desaparecerIndividuos();
        reproducion();
        clonacion();
        nuevoRecurso();
        this.turno = this.turno + 1;
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion que permite establecer el juego");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");

    }

    //Funcion para intentar hacer el grafo con las colas de los individuos
    public GrafoNuevo grafoColaOperacionesIndividuos(){
        ListaSimple<NodoGrafoNuevo> listaNodos = new ListaSimple<>();
        ListaSimple<ArcoGrafoNuevo> listaAristas = new ListaSimple<>();
        GrafoNuevo grafoColaOperaciones = new GrafoNuevo<>(listaNodos,listaAristas);
       /** for (int i = 0; i < columna; i++) {
            for (int j = 0; j < fila; j++) {
                for (int k = 0; k <= matriz[j][i].getListaIndividuo().getNumeroElementos() - 1; k++) {*/
                for (int k = 0; k <= listaIndividuos.getNumeroElementos()-1; k++){
                   // Individuo individuo = matriz[j][i].getListaIndividuo().getElemento(k).getData();
                    Individuo individuo = listaIndividuos.getElemento(k).getData();

                    for (int r = 0; r<individuo.getColaOperaciones().getNumeroElementos()-1; r++){
                        if (individuo.getColaOperaciones().getElemento(r).getData() == "reproduccion"){
                            Individuo indPareja = (Individuo) individuo.getColaOperaciones().getElemento(r+2).getData();
                            Individuo indHijo = (Individuo) individuo.getColaOperaciones().getElemento(r+4).getData();

                            ListaEnlazada<Integer> listaIdIndividuosNodos = new ListaEnlazada<>();
                            ListaEnlazada<Integer> listaPosicionNodo = new ListaEnlazada<>();
                            for (int o = 0; o<=grafoColaOperaciones.getListaVertices().getNumeroElementos()-1;o++){
                                NodoGrafoNuevo nodoGrafo = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(o).getData();
                                if (nodoGrafo.getDato().getClass() == IndBasico.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }else if (nodoGrafo.getDato().getClass() == IndNormal.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }else if (nodoGrafo.getDato().getClass() == IndAvanzado.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }
                            }
                            int idIndPrincipal = individuo.getId();
                            int posIndPrincipal = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndPrincipal));
                            NodoGrafoNuevo indPrincipal;
                            if (posIndPrincipal==-1){
                                NodoGrafoNuevo<Individuo> indPrincipal1 = new NodoGrafoNuevo<>(individuo);
                                grafoColaOperaciones.addNodo(indPrincipal1);
                                indPrincipal = indPrincipal1;
                            }else{
                                int posOprincipal = listaPosicionNodo.getElemento(posIndPrincipal).getData();
                                NodoGrafoNuevo indPrincipal2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOprincipal).getData();
                                indPrincipal = indPrincipal2;
                            }
                            int idIndPareja = indPareja.getId();
                            int posIdIndPareja = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndPareja));
                            if (posIdIndPareja==-1){
                                NodoGrafoNuevo<Individuo> nodoPareja = new NodoGrafoNuevo<>(indPareja);
                                ArcoGrafoNuevo<String> arcoPareja = new ArcoGrafoNuevo<>("reproducion", indPrincipal,nodoPareja,10.0);
                                grafoColaOperaciones.addNodo(nodoPareja);
                                grafoColaOperaciones.addArco(arcoPareja);
                            }else {
                                int posOPareja = listaPosicionNodo.getElemento(posIdIndPareja).getData();
                                NodoGrafoNuevo nodoPareja2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOPareja).getData();
                                ArcoGrafoNuevo<String> arcoPareja = new ArcoGrafoNuevo<>("reproducion", indPrincipal,nodoPareja2,10.0);
                                grafoColaOperaciones.addArco(arcoPareja);
                            }
                            int idIndHijo = indHijo.getId();
                            int posIdIndHijo = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndHijo));
                            if (posIdIndHijo==-1){
                                NodoGrafoNuevo<Individuo> nodoHijo = new NodoGrafoNuevo<>(indHijo);
                                ArcoGrafoNuevo<String> arcoHijo = new ArcoGrafoNuevo<>("hijo", indPrincipal,nodoHijo,10.0);
                                grafoColaOperaciones.addNodo(nodoHijo);
                                grafoColaOperaciones.addArco(arcoHijo);
                            }else {
                                int posOHijo = listaPosicionNodo.getElemento(posIdIndHijo).getData();
                                NodoGrafoNuevo nodoHijo2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOHijo).getData();
                                ArcoGrafoNuevo<String> arcoHijo = new ArcoGrafoNuevo<>("hijo", indPrincipal,nodoHijo2,10.0);
                                grafoColaOperaciones.addArco(arcoHijo);
                            }

                        }else if (individuo.getColaOperaciones().getElemento(r).getData() == "clonacion"){
                            Individuo indClonado = (Individuo) individuo.getColaOperaciones().getElemento(r+1).getData();
                            ListaEnlazada<Integer> listaIdIndividuosNodos = new ListaEnlazada<>();
                            ListaEnlazada<Integer> listaPosicionNodo = new ListaEnlazada<>();
                            for (int o = 0; o<=grafoColaOperaciones.getListaVertices().getNumeroElementos()-1;o++) {
                                NodoGrafoNuevo nodoGrafo = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(o).getData();
                                if (nodoGrafo.getDato().getClass() == IndBasico.class) {
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                } else if (nodoGrafo.getDato().getClass() == IndNormal.class) {
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                } else if (nodoGrafo.getDato().getClass() == IndAvanzado.class) {
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }
                            }
                            int idIndPrincipal = individuo.getId();
                            int posIndPrincipal = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndPrincipal));
                            NodoGrafoNuevo indPrincipal;
                            if (posIndPrincipal==-1){
                                NodoGrafoNuevo<Individuo> indPrincipal1 = new NodoGrafoNuevo<>(individuo);
                                grafoColaOperaciones.addNodo(indPrincipal1);
                                indPrincipal = indPrincipal1;
                            }else{
                                int posOprincipal = listaPosicionNodo.getElemento(posIndPrincipal).getData();
                                NodoGrafoNuevo indPrincipal2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOprincipal).getData();
                                indPrincipal = indPrincipal2;
                            }
                            int idIndClonado = indClonado.getId();
                            int posIdIndClonado = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndClonado));
                            if (posIdIndClonado==-1){
                                NodoGrafoNuevo<Individuo> nodoClonado = new NodoGrafoNuevo<>(indClonado);
                                ArcoGrafoNuevo<String> arcoClonado = new ArcoGrafoNuevo<>("clonacion", indPrincipal,nodoClonado,10.0);
                                grafoColaOperaciones.addNodo(nodoClonado);
                                grafoColaOperaciones.addArco(arcoClonado);
                            }else {
                                int posOPareja = listaPosicionNodo.getElemento(posIdIndClonado).getData();
                                NodoGrafoNuevo nodoClonado2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOPareja).getData();
                                ArcoGrafoNuevo<String> arcoPareja = new ArcoGrafoNuevo<>("clonacion", indPrincipal,nodoClonado2,10.0);
                                grafoColaOperaciones.addArco(arcoPareja);
                            }



                        }else if (individuo.getColaOperaciones().getElemento(r).getData() == "recurso"){
                            ListaEnlazada<Integer> listaIdIndividuosNodos = new ListaEnlazada<>();
                            ListaEnlazada<Integer> listaPosicionNodo = new ListaEnlazada<>();
                            for (int o = 0; o<=grafoColaOperaciones.getListaVertices().getNumeroElementos()-1;o++){
                                NodoGrafoNuevo nodoGrafo = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(o).getData();
                                if (nodoGrafo.getDato().getClass() == IndBasico.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }else if (nodoGrafo.getDato().getClass() == IndNormal.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }else if (nodoGrafo.getDato().getClass() == IndAvanzado.class){
                                    Individuo ind = (Individuo) nodoGrafo.getDato();
                                    listaIdIndividuosNodos.add(ind.getId());
                                    listaPosicionNodo.add(o);
                                }
                            }
                            int idIndPrincipal = individuo.getId();
                            int posIndPrincipal = listaIdIndividuosNodos.getPosicion(new ElementoLE<>(idIndPrincipal));
                            NodoGrafoNuevo indPrincipal;
                            if (posIndPrincipal==-1){
                                NodoGrafoNuevo<Individuo> indPrincipal1 = new NodoGrafoNuevo<>(individuo);
                                grafoColaOperaciones.addNodo(indPrincipal1);
                                indPrincipal = indPrincipal1;
                            }else{
                                int posOprincipal = listaPosicionNodo.getElemento(posIndPrincipal).getData();
                                NodoGrafoNuevo indPrincipal2 = (NodoGrafoNuevo) grafoColaOperaciones.getListaVertices().getElemento(posOprincipal).getData();
                                indPrincipal = indPrincipal2;
                            }
                            NodoGrafoNuevo recursoRecorrido = new NodoGrafoNuevo<>(individuo.getColaOperaciones().getElemento(r+1).getData());
                            ArcoGrafoNuevo<String> recurso = new ArcoGrafoNuevo<>("recurso", indPrincipal,recursoRecorrido,5.0);
                            grafoColaOperaciones.addNodo(recursoRecorrido);
                            grafoColaOperaciones.addArco(recurso);

                        }
                    }
                }
           // }
       // }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para formar el grafo con las operaciones globales de la partida");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return grafoColaOperaciones;
    }

    //Funcion para saber todos los individuos que han jugado en el tablero
    public ListaEnlazada<Integer> conjuntoIdIndividuosTotales(){
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                for (int k = 0; k <= matriz[i][j].getListaIndividuo().getNumeroElementos() - 1; k++) {
                    Individuo individuo = matriz[i][j].getListaIndividuo().getElemento(k).getData();
                    int idIndividuo = individuo.getId();
                    int turnosRestantesIndividuo = individuo.getTurnosRestantes();
                    int posIdInviduo = listaIdIndividuos.getPosicion(new ElementoLE<>(idIndividuo));
                    if (posIdInviduo==-1) {
                        listaIndividuos.add(individuo);
                        listaIdIndividuos.add(idIndividuo);
                        listaVidaMaxima.add(turnosRestantesIndividuo);
                    }else{
                        int vidaIndividuoLista = listaIndividuos.getElemento(posIdInviduo).getData().getTurnosRestantes();
                        if (vidaIndividuoLista>listaVidaMaxima.getElemento(posIdInviduo).getData()){
                            listaVidaMaxima.delete(posIdInviduo);
                            listaVidaMaxima.insert(vidaIndividuoLista,posIdInviduo);
                        }
                    }//
                }
            }
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para reconocer todos los individuos que han jugado");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return listaIdIndividuos;
    }
    public int numeroReproduccionesTotales(){
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el numero de reproducciones que se han producido a lo largo del juego");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return contadorReproduccionesTotales;
    }
    public int numeroClonacionesTotales(){
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el numero clonaciones que se han producido a lo largo del juego");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return contadorClonacionesTotales;
    }
    public Individuo individuoMaximoReproducciones(){
        conjuntoIdIndividuosTotales();
        Individuo individuo = null;
        if (!listaIndividuos.isVacia()){
            int i = 0;
            int aux = 0;
            while( aux<listaIndividuos.getNumeroElementos()){
                int reproducion = listaIndividuos.getElemento(aux).getData().getContadorReproduccion();
                if (reproducion>listaIndividuos.getElemento(i).getData().getContadorReproduccion()){
                    i=aux;
                }
                aux++;
            }
            individuo = listaIndividuos.getElemento(i).getData();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el individuo que ha realizado mas reproducciones");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuo;
    }

    public Individuo individuoMaximoClonaciones(){
        conjuntoIdIndividuosTotales();
        Individuo individuo = null;
        if (!listaIndividuos.isVacia()){
            int i = 0;
            int aux = 0;
            while( aux<listaIndividuos.getNumeroElementos()){
                int reproducion = listaIndividuos.getElemento(aux).getData().getContadorClonacion();
                if (reproducion>listaIndividuos.getElemento(i).getData().getContadorClonacion()){
                    i=aux;
                }
                aux++;
            }
            individuo = listaIndividuos.getElemento(i).getData();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el individuo que ha realizado mas clonaciones");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuo;
    }

    public Individuo individuoMaximoAgua() {
        conjuntoIdIndividuosTotales();
        Individuo individuo = null;
        if (!listaIndividuos.isVacia()){
            int i = 0;
            int aux = 0;
            while( aux<listaIndividuos.getNumeroElementos()){
                int reproducion = listaIndividuos.getElemento(aux).getData().getContadorAgua();
                if (reproducion>listaIndividuos.getElemento(i).getData().getContadorAgua()){
                    i=aux;
                }
                aux++;
            }
            individuo = listaIndividuos.getElemento(i).getData();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el individuo que ha recorrido el recurso agua mas veces");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuo;

    }
    public Individuo individuoLongevo() {
        conjuntoIdIndividuosTotales();
        Individuo individuo = null;
        if (!listaIndividuos.isVacia()){
            int i = 0;
            int aux = 0;
            while( aux<listaIndividuos.getNumeroElementos()){
                int reproducion = listaIndividuos.getElemento(aux).getData().getContadorIndividuoLongevo();
                if (reproducion>listaIndividuos.getElemento(i).getData().getContadorIndividuoLongevo()){
                    i=aux;
                }
                aux++;
            }
            individuo = listaIndividuos.getElemento(i).getData();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el individuo mas longevo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuo;
    }
    public Cola individuoLongevoOperaciones(){
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener las operaciones del individuo mas longevo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuoLongevo().getColaOperaciones();
    }

    public Individuo individuoMaximoVidaDisponible(){
        conjuntoIdIndividuosTotales();
        Individuo individuo = null;
        if (!listaIndividuos.isVacia()){
            int i = 0;
            int aux = 0;
            while( aux<listaVidaMaxima.getNumeroElementos()){
                int vida = listaVidaMaxima.getElemento(aux).getData();
                if (vida>listaVidaMaxima.getElemento(i).getData()){
                    i=aux;
                }
                aux++;
            }
            individuo = listaIndividuos.getElemento(i).getData();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el individuo que ha conseguido llegar a un momento de maximo tiempo de vida disponible");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return individuo;
    }
    public int cantidadIndividuoMaximoVidaDisponible(){
        int posInd = listaIndividuos.getPosicion(new ElementoLE<>(individuoMaximoVidaDisponible()));
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el numero de vida maximo del individuo que ha conseguido llegar a un momento de maximo tiempo de vida disponible");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return listaVidaMaxima.getElemento(posInd).getData();
    }

    public boolean mismoIndividuoLogevoYVidaDisponible(){
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para saber si el individuo que ha conseguido llegar a un momento de maximo tiempo de vida disponible y el individuo mas longevo son iguales");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return (individuoMaximoVidaDisponible()==individuoLongevo());
    }

}
