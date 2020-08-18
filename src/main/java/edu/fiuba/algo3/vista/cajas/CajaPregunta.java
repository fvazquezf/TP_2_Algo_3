package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.botones.BotonOpcion;
import edu.fiuba.algo3.vista.botones.BotonResponder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class CajaPregunta extends HBox implements Observador {

    private Label pregunta;
    private HBox cajaOpciones;


    public CajaPregunta(Panel panel, Collection<String> respuestasJugador) {
        super();

        pregunta = new Label(panel.obtenerPreguntaActual());

        cajaOpciones = new HBox();

        panel.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcion(o, respuestasJugador));});

        Button botonResponder = new BotonResponder(panel, respuestasJugador);

        VBox vb = new VBox();
        vb.getChildren().addAll(pregunta, cajaOpciones, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
    }
}
