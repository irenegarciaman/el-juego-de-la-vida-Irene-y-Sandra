package com.example.demojavafx.individuos;

import com.example.demojavafx.Celda;

import java.util.Random;

public class IndBasico extends Individuo {
    public IndBasico(int id) {
        super(id);
    }

    public IndBasico(int id, int generacion, int turnosRestantes) {
        super(id, generacion, turnosRestantes);
    }
    @Override
    public void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) {
        Random rand = new Random();
        int random = rand.nextInt(4);
        /***
         * 0 = arriba
         * 1 = abajo
         * 2 = dcha
         * 3 = izq
         */
        if(random == 0){
            int aux = maxFilas - posN;
            int tope = maxFilas - aux -1;
            if (tope<0){
                tope = tope*(-1);
            }
            int rand2 = rand.nextInt(tope);
            posN -= rand2;
        }
        else if(random == 1){
            int tope = maxFilas - posN;
            if (tope<0){
                tope = tope*(-1);
            }
            int rand2 = rand.nextInt(tope);
            posN += rand2;
        }
        else if(random == 2){
            int tope = maxColumnas - posM;
            if (tope<0){
                tope = tope*(-1);
            }
            int rand2 = rand.nextInt(tope);
            posM += rand2;
        }
        else {
            int aux = maxColumnas - posM;
            int tope = maxColumnas - aux -1;
            if (tope<0){
                tope = tope*(-1);
            }
            int rand2 = rand.nextInt(tope);
            posM -= rand2;
        }
    }

}
