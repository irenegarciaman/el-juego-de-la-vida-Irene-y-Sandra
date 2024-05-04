package com.example.demojavafx.ed;

public class Cola <TipoDelDato> {
    public ElementoLDE<TipoDelDato> cabeza;
    private ElementoLDE<TipoDelDato> cola;

    public Cola(ElementoLDE<TipoDelDato> cabeza, ElementoLDE<TipoDelDato> cola) {
        this.cabeza = cabeza;
        this.cola = cola;
    }
    public Cola(){

    }

    public boolean isVacia(){
        return cabeza==null;
    }
    public void push(ElementoLDE<TipoDelDato> el){
        ElementoLDE<TipoDelDato> en = new ElementoLDE<>(el.getData());
        if (isVacia()){
            cabeza=en;
        }else{
            en.setSiguiente(cola);
            cola.setAnterior(en);
        }
        cola=en;

    }
    public ElementoLDE<TipoDelDato> mostrarCabera(){
        return cabeza;
    }
    public ElementoLDE<TipoDelDato> pop(){
        ElementoLDE<TipoDelDato> en = cabeza;
        ElementoLDE<TipoDelDato> a = mostrarCabera();
        if (cabeza != null) {
            cabeza=cabeza.getAnterior();
            en.setAnterior(null);
        }else{
            cola = null;
            cabeza = null;
        }
        return a;

    }

    public void machacar(ElementoLDE elemento,int posicion){
        int pos = 0;
       // while (cabeza.getSiguiente()!=null){
         //   cabeza = cabeza.getSiguiente();
        //}
        ElementoLDE primero = this.cabeza;
        while (pos<posicion){
            primero=primero.getAnterior();
            pos++;
        }
        primero.data=elemento.data;
    }

    public int getPosicion(ElementoLDE el) {
        if (isVacia()==false){
            ElementoLDE d = this.cabeza;
            int contador=0;
            while(d.getData()!=el.getData() && contador<getNumeroElementos()-1){
                d = d.getAnterior();
                contador++;
            }
            return contador;
        }else{
            return -1;
        }
    }

    public int getNumeroElementos() {
        ElementoLDE<TipoDelDato> cabeza = this.cabeza;
        if (this.cabeza==null){
            return 0;
        }else{
            int contador = 0;
            while (cabeza!=null){
                cabeza = cabeza.getAnterior();
                contador++;
            }
            return contador;
        }
    }

    public ElementoLDE getElemento(int posicion){
        ElementoLDE c = this.cabeza;
        int contador = 0;
        if (c != null) {
            while (contador < posicion) {
                c = c.getAnterior();
                contador ++;
            }
        }
        return c;
    }


    public void pop2(ElementoLDE el){
        int a = this.getPosicion(el);
        if (el.getSiguiente()!=null) {
            el.getSiguiente().setAnterior(el.getAnterior());
        }
        if (el.getAnterior()!=null){
            el.getSiguiente().setSiguiente(el.getSiguiente());
        }
    }
}
