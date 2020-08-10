package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Panel panel = new Panel();
        panel.crearJugador("Pancho");

        Set<String> respuestaCorrecta = new HashSet<>();
        respuestaCorrecta.add("V");
        panel.crearPregunta("preguntaVoFConPenalidad", "pregunta", respuestaCorrecta);

        VistaPregunta vistaPregunta = new VistaPregunta(panel);
        Scene scene = vistaPregunta.devolverVistaPregunta();

        stage.setTitle("elCajú");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
