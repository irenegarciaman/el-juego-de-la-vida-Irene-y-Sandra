package com.example.demojavafx.individuos;

import com.example.demojavafx.BucleDeControl;
import com.example.demojavafx.Celda;
import com.example.demojavafx.HelloApplication;
import com.example.demojavafx.ed.ArbolBinarioDeBusqueda;
import com.example.demojavafx.ed.Cola;
import com.example.demojavafx.ed.NodoArbol;
import com.example.demojavafx.excepciones.PorcentajeValido;
import com.example.demojavafx.excepciones.Superar3Individuos;
import com.example.demojavafx.recursos.Recursos;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Individuo {
    private static final Logger log = LogManager.getLogger(Individuo.class);
    int id;
    int generacion;
    int turnosRestantes;
    int probReproduccion;
    int probClonacion;
    int probMuerte;
    int posN;
    int posM;
    ArbolBinarioDeBusqueda<Individuo> arbolGenealogico;
    Cola colaOperaciones = new Cola<>();
    int contadorReproduccion = 0;
    int contadorClonacion = 0;
    int contadorAgua = 0;
    int contadorIndividuoLongevo = 0;


    public Individuo(int id, int generacion, int turnosRestantes) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnosRestantes;
        this.arbolGenealogico = new ArbolBinarioDeBusqueda<>();
        this.arbolGenealogico.raiz = new NodoArbol<>(this);
    }

    public Individuo(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnoVidaRestantes;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = probMuerte;
        this.posN = posN;
        this.posM = posM;
        this.arbolGenealogico = new ArbolBinarioDeBusqueda<>();
        this.arbolGenealogico.raiz = new NodoArbol<>(this);
    }

    public Individuo(int id, int generacion, int turnoVidaRestantes, int probReproduccion, int probClonacion, int probMuerte) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnoVidaRestantes;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = probMuerte;
        this.arbolGenealogico = new ArbolBinarioDeBusqueda<>();
        this.arbolGenealogico.raiz = new NodoArbol<>(this);
    }

    public Individuo(int id) {
        this.id = id;
        this.arbolGenealogico = new ArbolBinarioDeBusqueda<>();
        this.arbolGenealogico.raiz = new NodoArbol<>(this);
    }

    public Individuo(int id, int generacion, int turnosRestantes, int probReproduccion, int probClonacion, int probMuerte, int posN, int posM, ArbolBinarioDeBusqueda<Individuo> arbolGenealogico, Cola colaOperaciones, int contadorReproduccion, int contadorClonacion, int contadorAgua, int contadorIndividuoLongevo) {
        this.id = id;
        this.generacion = generacion;
        this.turnosRestantes = turnosRestantes;
        this.probReproduccion = probReproduccion;
        this.probClonacion = probClonacion;
        this.probMuerte = probMuerte;
        this.posN = posN;
        this.posM = posM;
        this.arbolGenealogico = arbolGenealogico;
        this.colaOperaciones = colaOperaciones;
        this.contadorReproduccion = contadorReproduccion;
        this.contadorClonacion = contadorClonacion;
        this.contadorAgua = contadorAgua;
        this.contadorIndividuoLongevo = contadorIndividuoLongevo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    public int getTurnosRestantes() {
        return turnosRestantes;
    }

    public void setTurnosRestantes(int turnoVidaRestantes) {
        this.turnosRestantes = turnoVidaRestantes;
    }

    public int getProbReproduccion() {
        return probReproduccion;
    }

    public void setProbReproduccion(int probReproduccion) {
        try {
            this.probReproduccion = probReproduccion;
            if (probReproduccion < 0 || probReproduccion > 100) {
                throw new PorcentajeValido(this.probReproduccion);
            }
        } catch (PorcentajeValido porcentaje) {
            if (porcentaje.porcentaje < 0) {
                this.probReproduccion = 0;
            } else if (porcentaje.porcentaje > 100) {
                this.probReproduccion = 100;
            }
        }
    }

    public int getProbClonacion() {
        return probClonacion;
    }

    public void setProbClonacion(int probClonacion) {
        try {
            this.probClonacion = probClonacion;
            if (probClonacion < 0 || probClonacion > 100) {
                throw new PorcentajeValido(this.probClonacion);
            }
        } catch (PorcentajeValido porcentaje) {
            if (porcentaje.porcentaje < 0) {
                this.probClonacion = 0;
            } else if (porcentaje.porcentaje > 100) {
                this.probClonacion = 100;
            }
        }
    }

    public int getProbMuerte() {
        return probMuerte;
    }

    public void setProbMuerte(int probMuerte) {
        this.probMuerte = probMuerte;
    }

    public int getPosM() {
        return posM;
    }

    public void setPosM(int posM) {
        this.posM = posM;
    }

    public int getPosN() {
        return posN;
    }

    public void setPosN(int posN) {
        this.posN = posN;
    }

    public abstract void moverse(int maxColumnas, int maxFilas, Celda[][] matriz) throws Superar3Individuos;

    public ArbolBinarioDeBusqueda<Individuo> getArbolGenealogico() {
        return arbolGenealogico;
    }

    public void setArbolGenealogico(ArbolBinarioDeBusqueda<Individuo> arbolGenealogico) {
        this.arbolGenealogico = arbolGenealogico;
    }


    public Cola getColaOperaciones() {
        return colaOperaciones;
    }

    public void setColaOperaciones(Cola colaOperaciones) {
        this.colaOperaciones = colaOperaciones;
    }

    public int getContadorReproduccion() {
        return contadorReproduccion;
    }

    public void setContadorReproduccion(int contadorReproduccion) {
        this.contadorReproduccion = contadorReproduccion;
    }

    public int getContadorClonacion() {
        return contadorClonacion;
    }

    public void setContadorClonacion(int contadorClonacion) {
        this.contadorClonacion = contadorClonacion;
    }


    public static Individuo fromStringI(String individuoString, String split) {

        String[] partes = individuoString.split(split);

        String tipo = partes[0].substring(0);


        //int arbol = Integer.parseInt(partes[1].substring(partes[1].indexOf("=") + 1));

        int posM = Integer.parseInt(partes[2].split("=")[1]);
        int posN = Integer.parseInt(partes[3].split("=")[1]);
        int probMuerte = Integer.parseInt(partes[4].split("=")[1]);
        int probClonacion = Integer.parseInt(partes[5].split("=")[1]);
        int probReproduccion = Integer.parseInt(partes[6].split("=")[1]);
        int turnosRestantes = Integer.parseInt(partes[7].split("=")[1]);
        int generacion = Integer.parseInt(partes[8].split("=")[1]);
        int id = Integer.parseInt(partes[9].split("=")[1]);


        if (tipo.equals("IndBasico")) {
            return new IndBasico(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        } else if (tipo.equals("IndNormal")) {
            return new IndNormal(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        } else {
            return new IndAvanzado(id, generacion, turnosRestantes, probReproduccion, probClonacion, probMuerte, posN, posM);
        }
    }

    public static Individuo fromString(String individuoString) {
        return fromStringI(individuoString, ", ");
    }

    @Override
    public String toString() {
        return "";
    }

    public int getContadorAgua() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el contadorAgua del individuo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return contadorAgua;
    }

    public void setContadorAgua(int contadorAgua) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el contadorAgua del individuo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.contadorAgua = contadorAgua;
    }

    public int getContadorIndividuoLongevo() {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para obtener el contadorIndividuoLongevo del individuo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        return contadorIndividuoLongevo;
    }

    public void setContadorIndividuoLongevo(int contadorIndividuoLongevo) {
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion para modificar el contadorIndividuoLongevo del individuo");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
        this.contadorIndividuoLongevo = contadorIndividuoLongevo;
    }


}
