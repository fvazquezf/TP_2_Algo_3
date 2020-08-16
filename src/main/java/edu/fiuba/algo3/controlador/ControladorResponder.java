package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.vista.VistaGameOver;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.HashSet;

public class ControladorResponder implements EventHandler<ActionEvent> {

    private final Panel panel;
    private final Stage stage;
    private Collection<String> respuestaJugador;

    public ControladorResponder(Panel panel, HashSet<String> respuestaJugador, Stage stage) {
        this.panel = panel;
        this.respuestaJugador = respuestaJugador;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            panel.hacerPregunta(respuestaJugador);
        } catch (ExcepcionYaNoHayPreguntasParaHacer excepcion) {

            VistaGameOver gameOver = new VistaGameOver();
            Scene scene = gameOver.devolverVistaGameOver();

            stage.setScene(scene);
            stage.show();
        }
    }
}
