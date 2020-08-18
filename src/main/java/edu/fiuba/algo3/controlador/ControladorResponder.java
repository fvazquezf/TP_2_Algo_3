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
import java.util.Set;

public class ControladorResponder implements EventHandler<ActionEvent> {

    private final Panel panel;

    private Collection<String> respuestaJugador;

    public ControladorResponder(Panel panel, Set<String> respuestaJugador) {
        this.panel = panel;
        this.respuestaJugador = respuestaJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        panel.hacerPregunta(respuestaJugador);
    }
}
