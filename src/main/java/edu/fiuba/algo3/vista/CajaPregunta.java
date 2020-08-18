package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class CajaPregunta extends HBox implements Observador {

    private Label pregunta;
    private HBox cajaOpciones;
    private Panel panel;
    private Set<String> respuestasJugador;



    public CajaPregunta(Panel panel, Set<String> respuestasJugador) {
        super();

        this.respuestasJugador = respuestasJugador;
        this.panel = panel;
        Pregunta pregunta =  panel.obtenerPreguntaActual();
        pregunta.agregarObservador(this);

        this.pregunta = new Label(pregunta.obtenerPregunta());

        cajaOpciones = new HBox();

        pregunta.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});

        Button botonResponder = new BotonResponder(panel, respuestasJugador);

        VBox vb = new VBox();
        vb.getChildren().addAll(this.pregunta, cajaOpciones, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        Pregunta pregunta = panel.obtenerPreguntaActual();
        pregunta.agregarObservador(this);

        this.pregunta.setText(pregunta.obtenerPregunta());
        System.out.println("si");

        cajaOpciones.getChildren().clear();

        pregunta.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});

    }
}
