package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.Timer;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.vista.VistaGameOver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.Collection;

public class ControladorResponder implements EventHandler<ActionEvent> {

    private final Panel panel;
    private final Timer timer;

    private final Collection<String> respuestaJugador;

    public ControladorResponder(Panel panel, Collection<String> respuestaJugador, Timer timer) {
        this.panel = panel;
        this.respuestaJugador = respuestaJugador;
        this.timer = timer;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            panel.hacerPregunta(respuestaJugador);
            timer.reiniciar();
        } catch (ExcepcionYaNoHayPreguntasParaHacer e) {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            VistaGameOver vistaGameOver = new VistaGameOver();
            stage.setScene(vistaGameOver.devolverVistaGameOver());
            stage.show();
        }
    }
}
