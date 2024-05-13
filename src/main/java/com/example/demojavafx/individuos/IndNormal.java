package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ElementoLE;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.Recursos;

import java.util.Random;

public class IndNormal extends Individuo {

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
    public ListaEnlazada<Integer> creacionListaMovimiento(int posNDeseado, int posMDeseado, int posN, int posM, Celda[][] matriz){
            if (posN == posNDeseado && posM == posMDeseado){
                return listaMovimiento.invertir();
            }else {
            int n = posN - posNDeseado;
            int m = posM - posMDeseado;
            if (m>=0 && n>=0){
                if (m>n){
                    listaMovimiento.add(this.posM-1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM-1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM - 1, matriz);
                }else{
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN-1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN-1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN-1, posM, matriz);
                }
            }else if(m<=0 && n<=0){
                n=n*(-1);
                m=m*(-1);
                if (m>n){
                    listaMovimiento.add(this.posM+1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM+1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM + 1, matriz);
                }else{
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN+1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN+1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN+1, posM, matriz);
                }
            }else if (m>=0 && n<=0){
                n = n*(-1);
                if (m>n) {
                    listaMovimiento.add(this.posM - 1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM-1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM - 1, matriz);
                }else{
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN+1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN+1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN+1, posM, matriz);
                }
            }else{
                m=m*(-1);
                if (m>n){
                    listaMovimiento.add(this.posM+1);
                    listaMovimiento.add(this.posN);
                    this.setPosM(this.posM+1);
                    this.setPosN(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM+1, matriz);
                }else {
                    listaMovimiento.add(this.posM);
                    listaMovimiento.add(this.posN - 1);
                    this.setPosM(this.posM);
                    this.setPosN(this.posN-1);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN - 1, posM, matriz);
                }
            }
            /**
            int mPositivo;
            if (m < 0) {
                mPositivo = m * (-1);
                if (mPositivo>=n){
                    listaMovimiento1.add(this.posM-1);
                    listaMovimiento1.add(this.posN);
                    creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM + 1, matriz);
                }
            }
            int nPositivo;
            if (n < 0) {
                nPositivo = n * (-1);
                //poner un if
            }
            if (m >= n) {
                listaMovimiento1.add(this.posM+1);
                listaMovimiento1.add(this.posN);
                creacionListaMovimiento(posNDeseado, posMDeseado, posN, posM + 1, matriz);
            } else {
                listaMovimiento1.add(posM);
                listaMovimiento1.add(posN+1);
                creacionListaMovimiento(posNDeseado, posMDeseado, posN + 1, posM, matriz);
            }*/
        }
        return listaMovimiento.invertir();


    }

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {
        int posNGuardado = this.posN;
        int posMGuardado = this.posM;
        ListaEnlazada<Recursos> listaOpciones = new ListaEnlazada<>();
        if (recursoDeseado== null) {
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
            listaMovimiento = creacionListaMovimiento (posNDeseado,posMDeseado,posN,posM,matriz);


        }
        if (!listaMovimiento.isVacia()){
            matriz[posNGuardado][posMGuardado].eliminarIndividuo(this);
            int posMNueva = listaMovimiento.getElemento(0).getData();
            int posNNueva = listaMovimiento.getElemento(1).getData();
            this.setPosN(posNNueva);
            this.setPosM(posMNueva);
            int posNAEliminar = listaMovimiento.getPosicion(new ElementoLE<>(posNNueva));
            int posMAEliminar = listaMovimiento.getPosicion(new ElementoLE<>(posMNueva));
            listaMovimiento.delete(posNAEliminar);
            listaMovimiento.delete(posMAEliminar);
            matriz[this.posN][this.posM].addIndividuo(this);
        }else{
            recursoDeseado = null;
            moverse(maxColumnas,maxFilas,matriz);
        }



        /**
        //Recorrer las columnas
        for (int i = 0; i <maxColumnas; i++) {
            for (int j = 0; j<matriz[this.posN][i].getListaRecurso().getNumeroElementos(); j++) {
                if (i!=this.posM) {
                    Recursos recursos = matriz[this.posN][i].getListaRecurso().getElemento(j).getData();
                    listaOpciones.add(recursos);
                }
            }
        }
        matriz[this.posN][this.posM].eliminarIndividuo(this);
        Random rand = new Random();
        int aux = rand.nextInt(listaOpciones.getNumeroElementos());
        Recursos recurso = listaOpciones.getElemento(aux).getData();
        this.setPosN(recurso.getPosN());
        this.setPosM(recurso.getPosM());
        matriz[posN][posM].addIndividuo(this);
         */
    }
}
