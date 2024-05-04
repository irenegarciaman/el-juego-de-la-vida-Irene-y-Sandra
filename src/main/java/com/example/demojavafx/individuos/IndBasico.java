package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;

import java.util.Random;

public class IndBasico extends Individuo {
    public IndBasico(int id, int turnoVidaRestantes) {
        super(id, turnoVidaRestantes);
    }

    public IndBasico(int id) {
        super(id);
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
            int rand2 = rand.nextInt(tope);
            posN -= rand2;
        }
        else if(random == 1){
            int tope = maxFilas - posN;
            int rand2 = rand.nextInt(tope);
            posN += rand2;
        }
        else if(random == 2){
            int tope = maxColumnas - posM;
            int rand2 = rand.nextInt(tope);
            posM += rand2;
        }
        else {
            int aux = maxColumnas - posM;
            int tope = maxColumnas - aux -1;
            int rand2 = rand.nextInt(tope);
            posM -= rand2;
        }
    }

}
