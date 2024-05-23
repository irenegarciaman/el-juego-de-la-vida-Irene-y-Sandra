package com.example.demojavafx;

import javafx.fxml.Initializable;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class AddEliminiarController implements Initializable {

    private Stage scene;

    private BucleDeControlProperties matrizModel;

    protected Celda[][] matriz;

    private static final Logger log = LogManager.getLogger(AddEliminiarController.class);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    protected void updateGUIwithModel() {
    }


    public void loadUserData(BucleDeControlProperties parametrosBucleDeControl) {
        this.matriz = parametrosBucleDeControl.matrizProperty();
        this.matrizModel = parametrosBucleDeControl;
        this.updateGUIwithModel();
        log.trace("Enviando una traza de ejecución");
        log.debug("Enviado un debug");
        log.info("Funcion, la cual se encarga de cargar datos");
        log.warn("Enviando un aviso");
        log.error("Enviando un error");
        log.fatal("Enviando una explosión fatal");
    }

    public void setStage(Stage s) {
        this.scene = s;
    }

    public void guardarButton() {

        matrizModel.commit();

    }

    public void cerrarButton() {
        scene.close();
    }

    public void cancelarButton() {

        matrizModel.rollback();
    }

}
