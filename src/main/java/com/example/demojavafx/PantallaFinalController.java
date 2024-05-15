package com.example.demojavafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PantallaFinalController {
    private Stage stage;
    public void abrirPantallaFinal() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pantalla-final.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            stage.setTitle("¡El juego ha finalizado! ");
            stage.setScene(scene);




            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
