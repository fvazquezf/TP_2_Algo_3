package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonOpcion;
import edu.fiuba.algo3.vista.botones.BotonResponder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class CajaPregunta extends HBox implements Observador {

    private Collection<String> respuestasJugador;
    private Pregunta pregunta;
    private Label labelPregunta;
    private HBox cajaOpciones;


    public CajaPregunta(Panel panel, Collection<String> respuestasJugador) {
        super();

        this.respuestasJugador = respuestasJugador;

        this.pregunta = panel.obtenerPreguntaActual();

        labelPregunta = new Label(pregunta.obtenerPregunta());

        cajaOpciones = new HBox();

        pregunta.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});

        Button botonResponder = new BotonResponder(panel, respuestasJugador);

        VBox vb = new VBox();
        vb.getChildren().addAll(labelPregunta, cajaOpciones, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        respuestasJugador.removeAll(pregunta.obtenerTodasLasOpciones());
    }
}
