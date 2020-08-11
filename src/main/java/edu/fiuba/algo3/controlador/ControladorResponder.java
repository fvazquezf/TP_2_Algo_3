package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Collection;
import java.util.HashSet;

public class ControladorResponder implements EventHandler<ActionEvent> {

    private final Panel panel;
    private Collection<String> respuestaJugador;

    public ControladorResponder(Panel panel, HashSet<String> respuestaJugador) {
        this.panel = panel;
        this.respuestaJugador = respuestaJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        panel.hacerPregunta(panel.jugadorActual(), respuestaJugador);
        respuestaJugador.clear();
    }
}
