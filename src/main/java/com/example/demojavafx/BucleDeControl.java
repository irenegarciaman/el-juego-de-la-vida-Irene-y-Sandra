package com.example.demojavafx;

import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.matriz.Matriz;
import com.example.demojavafx.recursos.Recursos;

public class BucleDeControl {
    private int columna;
    private int fila;
    public Celda matriz[][];

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
                for(int k=0;k<matriz[j][i].getListaIndividuo().getNumeroElementos()-1 ;k++){
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
                for(int k=0;k<matriz[j][i].getListaRecurso().getNumeroElementos()-1 ;k++){
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

    }


}
