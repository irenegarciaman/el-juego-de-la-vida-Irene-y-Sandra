package com.example.demojavafx;


import com.example.demojavafx.individuos.Individuo;
import com.example.demojavafx.individuos.IndividuoProperties;
import com.example.demojavafx.recursos.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;

import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

import static com.example.demojavafx.ed.Gson1.cargarObjetoDesdeArchivo;

public class HelloController implements Initializable {


    private Stage stage;
    private static final Logger log = LogManager.getLogger(HelloController.class);


    protected RecursosProperties recursosModel;
    protected AguaProperties aguaModel;
    protected BibliotecaProperties bibliotecaModel;
    protected ComidaProperties comidaModel;
    protected MontanaProperties montanaModel;
    protected PozoProperties pozoModel;
    protected TesoroProperties tesoroModel;
    //Individuos model
    protected IndividuoProperties individuoModel;

    private BucleDeControl matriz = new BucleDeControl(15, 15);
    private BucleDeControlProperties modeloMatriz = new BucleDeControlProperties(matriz);

    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */


    @FXML
    protected void onMiBotonNuevaVentajaClick() {
        try {
            JuegoController p = new JuegoController();
            GuardarDatos gd = cargarObjetoDesdeArchivo("partidaAnterior.json", GuardarDatos.class);

            Agua a = gd.cargarAgua();
            Biblioteca b = gd.cargarBiblioteca();
            Comida co = gd.cargarComida();
            Montana m = gd.cargarMontana();
            Pozo po = gd.cargarPozo();
            Tesoro t = gd.cargarTesoro();
            Recursos r = gd.getRecursos();
            Individuo ind = gd.cargarIndividuo();

            this.recursosModel = new RecursosProperties(r);
            this.matriz = gd.cargarBucle();
            this.modeloMatriz = new BucleDeControlProperties(this.matriz);
            this.pozoModel = new PozoProperties(po,r);
            this.aguaModel = new AguaProperties(a,b);
            this.comidaModel = new ComidaProperties(co,m);
            this.montanaModel = new MontanaProperties(m,po);
            this.tesoroModel = new TesoroProperties(t,r);
            this.bibliotecaModel = new BibliotecaProperties(b,r);
            this.individuoModel = new IndividuoProperties(ind);



            p.loadUserData(recursosModel, aguaModel, bibliotecaModel, comidaModel, montanaModel, pozoModel, tesoroModel, individuoModel, modeloMatriz);
            p.crearJuegoR(this.modeloMatriz);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    protected void onMiBotonNuevaVentanaAjustesClick() {
        log.info("Inicio del método de arranque de la aplicación para elegir los parámetros");
        cerraryGuardar();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cond-iniciales.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("Ajustes: ");
            stage.setScene(scene);
            //Recursos
            RecursosController p = fxmlLoader.getController();
            p.loadUserData(this.recursosModel, this.aguaModel, this.bibliotecaModel,
                    this.comidaModel, this.montanaModel, this.pozoModel, this.tesoroModel, this.individuoModel,
                    this.modeloMatriz);
            p.setStage(stage);

            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");


        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Enviando un info");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");


        log.info("Fin del método de arranque de la aplicación para elegir los parámetros\"");
    }

    public void loadUserData(RecursosProperties parametrosRecursos, AguaProperties parametrosAgua,
                             BibliotecaProperties parametrosBiblioteca, ComidaProperties parametrosComida,
                             MontanaProperties parametrosMontana, PozoProperties parametrosPozo,
                             TesoroProperties parametrosTesoro, IndividuoProperties parametrosInd,
                             BucleDeControlProperties parametroMatriz) {
        this.recursosModel = parametrosRecursos;
        this.aguaModel = parametrosAgua;
        this.bibliotecaModel = parametrosBiblioteca;
        this.comidaModel = parametrosComida;
        this.montanaModel = parametrosMontana;
        this.pozoModel = parametrosPozo;
        this.tesoroModel = parametrosTesoro;
        this.individuoModel = parametrosInd;
        this.modeloMatriz = parametroMatriz;

        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion, la cual se encarga de cargar datos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");    }

    public void cerraryGuardar() {
        this.recursosModel.commit();
        this.aguaModel.commit();
        this.bibliotecaModel.commit();
        this.comidaModel.commit();
        this.montanaModel.commit();
        this.pozoModel.commit();
        this.tesoroModel.commit();
        this.individuoModel.commit();
        this.modeloMatriz.commit();
    }
}