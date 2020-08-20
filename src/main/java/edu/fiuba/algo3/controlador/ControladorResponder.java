package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.vista.VistaGameOver;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Set;

public class ControladorResponder implements EventHandler<ActionEvent> {

    private final Panel panel;

    private Collection<String> respuestaJugador;

    public ControladorResponder(Panel panel, Collection<String> respuestaJugador) {
        this.panel = panel;
        this.respuestaJugador = respuestaJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        try{
            panel.hacerPregunta(respuestaJugador);
        } catch(ExcepcionYaNoHayPreguntasParaHacer e){
            Node source = (Node)  event.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();
            VistaGameOver vistaGameOver = new VistaGameOver();
            stage.setScene(vistaGameOver.devolverVistaGameOver());
            stage.show();
        }
    }
}
