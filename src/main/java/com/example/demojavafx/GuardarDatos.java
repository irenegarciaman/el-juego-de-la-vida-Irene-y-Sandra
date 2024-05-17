package com.example.demojavafx;

import com.example.demojavafx.ed.Gson1;
import com.example.demojavafx.ed.ListaEnlazada;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.excepciones.Superar3Recursos;
import com.example.demojavafx.individuos.IndAvanzado;
import com.example.demojavafx.individuos.IndBasico;
import com.example.demojavafx.individuos.IndNormal;
import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.recursos.*;

public class GuardarDatos {
    public String listaIndividuo[];
    public String listaRecurso[];
    public int infoIndyRec[];
    public int fyc[];

    public void guardarDatos(BucleDeControl bucle, Individuo ind,
                             Agua agua, Biblioteca biblioteca, Comida comida,
                             Montana montana, Pozo pozo, Tesoro tesoro) {
        int fila = bucle.getFila();
        int columna = bucle.getColumna();

        fyc = new int[2];
        fyc[0] = fila;
        fyc[1] = columna;


        ListaEnlazada<Individuo> listaInd = new ListaEnlazada<>();
        ListaEnlazada<Recursos> listaRec = new ListaEnlazada<>();

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                for (int k = 0; k < bucle.matriz[i][j].getListaIndividuo().getNumeroElementos(); k++) {
                    Individuo individuo = bucle.matriz[i][j].getListaIndividuo().getElemento(k).getData();
                    listaInd.add(individuo);
                }
                for (int k = 0; k < bucle.matriz[i][j].getListaRecurso().getNumeroElementos(); k++) {
                    listaRec.add(bucle.matriz[i][j].getListaRecurso().getElemento(k).getData());
                }
            }
        }



        listaIndividuo = new String[listaInd.getNumeroElementos()];
        listaRecurso = new String[listaRec.getNumeroElementos()];


        for (int i = 0; i < listaInd.getNumeroElementos(); i++) {
            listaIndividuo[i] = listaInd.getElemento(i).getData().toString();
        }


        for (int i = 0; i < listaRec.getNumeroElementos(); i++) {
            listaRecurso[i] = listaRec.getElemento(i).getData().toString();
        }

        infoIndyRec = new int[17];

        infoIndyRec[0] = agua.getProbNuevoRecurso();

        infoIndyRec[1] = agua.getProbAgua();
        infoIndyRec[2] = agua.getAumentoDeVida();

        infoIndyRec[3] = biblioteca.getProbBiblioteca();
        infoIndyRec[4] = biblioteca.getAumentoDePorcenClon();

        infoIndyRec[5] = comida.getProbComida();
        infoIndyRec[6] = comida.getAumentoDeVida();

        infoIndyRec[7] = montana.getProbMontana();
        infoIndyRec[8] = montana.getDisminucionDeVida();

        infoIndyRec[9] = tesoro.getProbTesoro();
        infoIndyRec[10] = tesoro.getAumentoDePorcenRep();

        infoIndyRec[11] = pozo.getProbPozo();

        infoIndyRec[12] = ind.getTurnosRestantes();
        infoIndyRec[13] = ind.getProbClonacion();
        infoIndyRec[14] = ind.getProbReproduccion();
        infoIndyRec[15] = ind.getProbMuerte();

        infoIndyRec[16] = agua.getTurnosRestantes();


        Gson1.guardarObjetoEnArchivo("partidaAnterior.json", this);


    }

    public static Individuo fromStringI(String individuoString) {
        String[] partes = individuoString.split(", ");

        String tipo = partes[0].substring(0);


        //int arbol = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));

        int posM = Integer.parseInt(partes[1].split("=")[1]);
        int posN = Integer.parseInt(partes[2].split("=")[1]);
        int probMuerte = Integer.parseInt(partes[3].split("=")[1]);
        int probClonacion = Integer.parseInt(partes[4].split("=")[1]);
        int probReproduccion = Integer.parseInt(partes[5].split("=")[1]);
        int turnosRestantes = Integer.parseInt(partes[6].split("=")[1]);
        int generacion = Integer.parseInt(partes[7].split("=")[1]);
        int id = Integer.parseInt(partes[8].split("=")[1]);

//        String[] split = partes[9].split(":");
//        for (int i = 0; i < split.length; i++) {
        /***
         String[] elemento = split[i].split("=");
         int tipo1 = Integer.parseInt(elemento[0]);
         int posM1 = Integer.parseInt(elemento[2].split(";")[0]);
         int posN1 = Integer.parseInt(elemento[3].split(";")[0]);
         int probMuerte1 = Integer.parseInt(elemento[4].split(";")[0]);
         int probClonacion1 = Integer.parseInt(elemento[5].split(";")[0]);
         int probReproduccion1 = Integer.parseInt(elemento[6].split(";")[0]);
         int turnosRestantes1 = Integer.parseInt(elemento[7].split(";")[0]);
         int generacion1 = Integer.parseInt(elemento[8].split(";")[0]);
         int id1 = Integer.parseInt(elemento[9].split(";")[0]);*/

//        }

        if (tipo.equals("IndBasico")) {
            return new IndBasico(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        } else if (tipo.equals("IndNormal")) {
            return new IndNormal(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        } else {
            return new IndAvanzado(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        }
    }

    public static Recursos fromStringR(String recursoString) {
        String[] partes = recursoString.split(", ");

        String tipo = partes[0].substring(0);


        if (tipo.equals("Agua")) {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            int probNuevo = Integer.parseInt(partes[6].substring(partes[6].indexOf("=") + 1));
            return new Agua(turnosRestantes, posN, posM, probNuevo, inter, probThis);
        } else if (tipo.equals("Biblioteca")) {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            int probNuevo = Integer.parseInt(partes[6].substring(partes[6].indexOf("=") + 1));
            return new Biblioteca(turnosRestantes, posN, posM, probNuevo, inter, probThis);
        } else if (tipo.equals("Comida")) {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            int probNuevo = Integer.parseInt(partes[6].substring(partes[6].indexOf("=") + 1));
            return new Comida(turnosRestantes, posN, posM, probNuevo, inter, probThis);
        } else if (tipo.equals("Montana")) {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            int probNuevo = Integer.parseInt(partes[6].substring(partes[6].indexOf("=") + 1));

            return new Montana(turnosRestantes, posN, posM, probNuevo, inter, probThis);
        } else if (tipo.equals("Tesoro")) {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            int probNuevo = Integer.parseInt(partes[6].substring(partes[6].indexOf("=") + 1));
            return new Tesoro(turnosRestantes, posN, posM, probNuevo, inter, probThis);
        } else {
            int inter = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));
            int probThis = Integer.parseInt(partes[2].substring(partes[2].indexOf("=") + 1));
            int turnosRestantes = Integer.parseInt(partes[3].substring(partes[3].indexOf("=") + 1));
            int posN = Integer.parseInt(partes[4].substring(partes[4].indexOf("=") + 1));
            int posM = Integer.parseInt(partes[5].substring(partes[5].indexOf("=") + 1));
            return new Pozo(probThis, turnosRestantes, posN, posM, inter);
        }
    }

    public BucleDeControl cargarBucle() throws Superar3Individuos, Superar3Recursos {


        int fila = fyc[0];
        int columna = fyc[1];
        BucleDeControl bucle = new BucleDeControl(fila, columna);


        for (int k = 0; k < listaIndividuo.length; k++) {
            Individuo ind = fromStringI(listaIndividuo[k]);
            for (int i = 0; i < bucle.getFila(); i++) {
                for (int j = 0; j < bucle.getColumna(); j++) {
                    if (ind.getPosN() == i && ind.getPosM() == j) {
                        bucle.matriz[i][j].addIndividuo(ind);
                    }
                }
            }
        }

        for (int k = 0; k < listaRecurso.length; k++) {
            Recursos rec = fromStringR(listaRecurso[k]);
            for (int i = 0; i < bucle.getFila(); i++) {
                for (int j = 0; j < bucle.getColumna(); j++) {
                    if (rec.getPosN() == i && rec.getPosM() == j) {
                        bucle.matriz[i][j].addRecurso(rec);
                    }
                }
            }
        }

        return bucle;
    }

    public Individuo cargarIndividuo() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Individuo ind = new IndAvanzado(1);
        ind.setTurnosRestantes(infoIndyRec[12]);
        ind.setProbClonacion(infoIndyRec[13]);
        ind.setProbReproduccion(infoIndyRec[14]);
        ind.setProbMuerte(infoIndyRec[15]);
        return ind;
    }

    public Recursos cargarRecursos() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Recursos rec = new Recursos();
        rec.setProbNuevoRecurso(infoIndyRec[0]);
        rec.setTurnosRestantes(infoIndyRec[16]);
        return rec;
    }

    public Agua cargarAgua() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Agua agua = new Agua();
        agua.setProbAgua(infoIndyRec[1]);
        agua.setAumentoDeVida(infoIndyRec[2]);
        agua.setProbNuevoRecurso(infoIndyRec[0]);
        agua.setTurnosRestantes(infoIndyRec[16]);
        return agua;
    }

    public Biblioteca cargarBiblioteca() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.setProbBiblioteca(infoIndyRec[3]);
        biblioteca.setAumentoDePorcenClon(infoIndyRec[4]);
        biblioteca.setProbNuevoRecurso(infoIndyRec[0]);
        biblioteca.setTurnosRestantes(infoIndyRec[16]);
        return biblioteca;
    }

    public Comida cargarComida() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Comida comida = new Comida();
        comida.setProbComida(infoIndyRec[5]);
        comida.setAumentoDeVida(infoIndyRec[6]);
        comida.setProbNuevoRecurso(infoIndyRec[0]);
        comida.setTurnosRestantes(infoIndyRec[16]);
        return comida;
    }

    public Montana cargarMontana() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Montana montana = new Montana();
        montana.setProbMontana(infoIndyRec[7]);
        montana.setDisminucionDeVida(infoIndyRec[8]);
        montana.setProbNuevoRecurso(infoIndyRec[0]);
        montana.setTurnosRestantes(infoIndyRec[16]);
        return montana;
    }

    public Tesoro cargarTesoro() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Tesoro tesoro = new Tesoro();
        tesoro.setProbTesoro(infoIndyRec[9]);
        tesoro.setAumentoDePorcenRep(infoIndyRec[10]);
        tesoro.setProbNuevoRecurso(infoIndyRec[0]);
        tesoro.setTurnosRestantes(infoIndyRec[16]);
        return tesoro;
    }

    public Pozo cargarPozo() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Pozo pozo = new Pozo();
        pozo.setProbPozo(infoIndyRec[11]);
        pozo.setProbNuevoRecurso(infoIndyRec[0]);
        pozo.setTurnosRestantes(infoIndyRec[16]);
        return pozo;
    }


    public static void main(String[] args) throws Superar3Recursos, Superar3Individuos {
        GuardarDatos g = new GuardarDatos();
        int columna = 5;
        int fila = 6;
        BucleDeControl matriz = new BucleDeControl(fila, columna);
        IndAvanzado ind1 = new IndAvanzado(222, 4, 6, "montaña");
        IndAvanzado ind2 = new IndAvanzado(333, 6, 7, "agua");
        IndAvanzado ind3 = new IndAvanzado(444, 9, 1, "pozo");
        Agua agua = new Agua(3, 4);
        Comida comida = new Comida(2, 3);
        Montana montana = new Montana(4, 5);
        Biblioteca biblioteca = new Biblioteca(3, 45);
        Tesoro tesoro = new Tesoro(3, 32);
        Pozo pozo = new Pozo(6);
        matriz.matriz[0][2].addRecurso(agua);
        matriz.matriz[0][2].addRecurso(tesoro);
        matriz.matriz[0][2].addRecurso(biblioteca);
        matriz.matriz[1][0].addRecurso(comida);
        matriz.matriz[1][2].addRecurso(montana);
        matriz.matriz[1][1].addRecurso(pozo);
        matriz.matriz[0][2].addIndividuo(ind1);
        matriz.matriz[1][0].addIndividuo(ind2);
        matriz.matriz[1][2].addIndividuo(ind3);
        ind1.setPosN(0);
        ind1.setPosM(2);
        ind2.setPosN(1);
        ind2.setPosM(0);
        ind3.setPosN(1);
        ind3.setPosM(2);
        agua.setPosN(0);
        agua.setPosM(2);
        tesoro.setPosN(0);
        tesoro.setPosM(2);
        biblioteca.setPosN(0);
        biblioteca.setPosM(2);
        comida.setPosN(1);
        comida.setPosM(0);
        montana.setPosN(1);
        montana.setPosM(2);
        pozo.setPosN(1);
        pozo.setPosM(1);


        g.cargarBucle();
    }

    public Recursos getRecursos() {
        Gson1.cargarObjetoDesdeArchivo("partidaAnterior.json", this.getClass());
        Recursos recursos = new Recursos();
        recursos.setProbNuevoRecurso(infoIndyRec[0]);
        recursos.setTurnosRestantes(infoIndyRec[16]);
        return recursos;
    }
}
