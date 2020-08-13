package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.HashSet;

public class CajaPregunta extends HBox implements Observador {

    private final Panel panel;
    private Label pregunta;
    private HBox cajaOpciones;
    private HashSet<String> respuestasJugador;

    public CajaPregunta(Panel panel) {
        super();

        this.panel = panel;

        pregunta = new Label(panel.obtenerPreguntaActual());

        respuestasJugador = new HashSet<>();

        cajaOpciones = new HBox();

        panel.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});

        Button botonResponder = new BotonResponder(panel, respuestasJugador);

        VBox vb = new VBox();
        vb.getChildren().addAll(pregunta, cajaOpciones, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        pregunta.setText(panel.obtenerPreguntaActual());
        cajaOpciones.getChildren().clear();
        respuestasJugador.clear();
        panel.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});
    }
}
