package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;
import com.example.demojavafx.ed.ListaSimple;
import com.example.demojavafx.excepciones.Superar3Individuos;

import java.util.Random;

public class IndBasico extends Individuo {
    public IndBasico(int id) {
        super(id);
    }

    public IndBasico(int id, int generacion, int turnosRestantes) {
        super(id, generacion, turnosRestantes);
    }

    public IndBasico(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        super(id, generacion, turnoVidaRestantes, probReproduccion, probClonacion, probMuerte);
    }

    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos {

        /***
         * 0 = arriba
         * 1 = abajo
         * 2 = dcha
         * 3 = izq
         */
        ListaSimple<Integer> numeros = new ListaSimple<>();
        if (this.posN != 0){
            numeros.add(0);
        }
        if (this.posN != maxFilas-1){
            numeros.add(1);
        }
        if(this.posM != maxColumnas-1){
            numeros.add(2);
        }
        if(this.posM != 0){
            numeros.add(3);
        }

        Random rand = new Random();
        int indiceRandom = rand.nextInt(numeros.getNumeroElementos());
        int random = numeros.getElemento(indiceRandom).getData();

        if(random == 0){
            matriz[this.posN][this.posM].eliminarIndividuo(this);
            matriz[this.posN-1][this.posM].addIndividuo(this);
        }
        else if(random == 1){
            matriz[this.posN][this.posM].eliminarIndividuo(this);
            matriz[this.posN+1][this.posM].addIndividuo(this);
        }
        else if(random == 2){
            matriz[this.posN][this.posM].eliminarIndividuo(this);
            matriz[this.posN][this.posM+1].addIndividuo(this);
        }
        else {
            matriz[this.posN][this.posM].eliminarIndividuo(this);
            matriz[this.posN][this.posM-1].addIndividuo(this);
        }
    }
}
