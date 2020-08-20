package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonOpcion;
import edu.fiuba.algo3.vista.botones.BotonResponder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class CajaPregunta extends VBox implements Observador {

    private final Collection<String> respuestasJugador;
    private final Pregunta pregunta;
    private final VBox cajaOpciones;


    public CajaPregunta(Panel panel, Collection<String> respuestasJugador, Timer timer) {
        super();

        this.respuestasJugador = respuestasJugador;

        this.pregunta = panel.obtenerPreguntaActual();

        Label labelPregunta = new Label(pregunta.obtenerPregunta());

        cajaOpciones = new VBox();

        pregunta.obtenerTodasLasOpciones().forEach((o) -> cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador)));

        Button botonResponder = new BotonResponder(panel, respuestasJugador, timer);

        VBox vb = new VBox();
        vb.setSpacing(25);
        vb.getChildren().addAll(labelPregunta, cajaOpciones, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        respuestasJugador.removeAll(pregunta.obtenerTodasLasOpciones());
    }
}
