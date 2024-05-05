package com.example.demojavafx.ed;

/**
 * Programar la lista simplemente enlazada.
 **/

public class ListaSimple <TipoDelDato> {
    private ElementoLS<TipoDelDato>[] datos;
    private int maximo=100000;
    private int numeroElementos;




    public ListaSimple() {
        this.datos = new ElementoLS[this.maximo];
    }
    public boolean isVacia() {
        boolean bool = false;
        if (getNumeroElementos() == 0) {
            bool = true;
        }
        return bool;
    }

    public void Vaciar() {
        ElementoLS<TipoDelDato>[] datos = null;
    }

    private int add(ElementoLS<TipoDelDato> el) {
        int pos = 0;
        boolean añadido = false;
        while (pos < maximo) {
            if (this.datos[pos] == null) {
                this.datos[pos] = el;
                añadido = true;
                break;
            } else pos++;

        }
        if (añadido == false) {
            System.out.println("lista llena");
        }
        return pos;
    }

    public void add(String s) {
        ElementoLS<TipoDelDato> a = new ElementoLS(s);
        add(a);
    }

    public void add(Object o) {
        ElementoLS<TipoDelDato> a = new ElementoLS(o);
        add(a);
    }

    private void insert(ElementoLS<TipoDelDato> s, int posicion) { //he creado esta clase para poder hacer de mejor forma la insercion de un String y de un Object
        if (posicion < maximo) {
            if (this.datos[maximo - 1] != null) {
                System.out.println("la lista esta llena");
            } else {
                if (this.datos[posicion] == null) {
                    add(s);
                } else {
                    int i;
                    for (i = maximo - 1; i >= posicion; i--) {
                        if (this.datos[i] != null) {
                            this.datos[i + 1] = this.datos[i];
                        }
                    }
                    this.datos[posicion] = s;
                }
            }
        } else {
            System.out.println("no se ha añadido");
        }
    }

    public void insert(String s, int posicion) {
        ElementoLS<TipoDelDato> a = new ElementoLS(s);
        insert(a, posicion);
    }

    public void insert(Object o, int posicion) {
        ElementoLS<TipoDelDato> a = new ElementoLS(o);
        insert(a, posicion);
    }

    public int del(int posicion) {
        int contador = 0;
        while (this.datos[contador] != null && contador < maximo) {
            contador++;
        }
        numeroElementos = contador;
        if (posicion < numeroElementos && posicion >= 0) {
            this.datos[posicion] = null;
        }
        if (posicion != (numeroElementos - 1)) {
            int i;
            for (i = posicion; i <= numeroElementos; i++) {
                this.datos[i] = this.datos[i + 1];
            }
        }
        return numeroElementos - 1;
    }


    public int getNumeroElementos() {
        int contador = 0;
        while (this.datos[contador] != null && contador < maximo) {
            contador++;
        }
        numeroElementos = contador;
        return numeroElementos;
    }

    public int getPosicion(ElementoLS<TipoDelDato> el) {
        int pos = 0;
        while (pos < maximo) {
            if (this.datos[pos] == null) {
                //System.out.println("no hemos encontrado el elemento");
                pos = -1;
                break;
            }
            if (this.datos[pos].getData() == el.getData()) {
                //System.out.println("Hemos encontrado el elemento");
                break;
            }

            pos += 1;
        }
        return pos;
    }

    public ElementoLS<TipoDelDato> getElemento(int posicion) {
        return this.datos[posicion];
    }

    public ElementoLS<TipoDelDato> getSiguiente(ElementoLS<TipoDelDato> el) {
        int pos = getPosicion(el);
        return getElemento(pos+1);

    }

    public ElementoLS<TipoDelDato> getPrimero() {
        int posicion = 0;
        return this.datos[posicion];
    }



    public ElementoLS getUltimo() {
        int posicion = getNumeroElementos();
        return this.datos[posicion - 1];
    }

    public ArcoGrafoNuevo menorPeso (ListaSimple<ArcoGrafoNuevo> lista){
        ArcoGrafoNuevo min = lista.getElemento(0).getData();

        for (int i=0; i<lista.getNumeroElementos()-1;i++){
            ArcoGrafoNuevo aux = lista.getElemento(i).getData();
            if (aux.peso<min.peso){
                min=aux;
            }
        }
        return min;
    }

   public ListaSimple<TipoDelDato> invertir (ListaSimple<TipoDelDato> lista){
        ListaSimple<TipoDelDato> lista2 = new ListaSimple<>();
        for (int i =lista.getNumeroElementos()-1; 0<=i;i--){
           // if (lista.getElemento(i)!=null){
                lista2.add(lista.getElemento(i));
            //}
        }
        return lista2;
   }
    public void guardarLS() {
        String rutaArchivo = "listaS.json";
        Gson1.guardarObjetoEnArchivo(rutaArchivo,this);
        ListaSimple listaS = Gson1.cargarObjetoDesdeArchivo(rutaArchivo,ListaSimple.class);
        if(listaS != null){
            System.out.println("Arbol Cargado");
        }
    }



}


