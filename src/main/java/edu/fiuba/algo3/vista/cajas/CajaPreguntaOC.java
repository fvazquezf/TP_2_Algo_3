package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.Timer;
import edu.fiuba.algo3.vista.botones.BotonCajaOpcionesDragAndDrop;
import edu.fiuba.algo3.vista.botones.BotonOpcion;
import edu.fiuba.algo3.vista.botones.BotonOpcionDragAndDrop;
import edu.fiuba.algo3.vista.botones.BotonResponder;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;
import java.util.LinkedList;

public class CajaPreguntaOC extends HBox implements Observador {

    private final LinkedList<String> respuestasJugador;
    private final Pregunta pregunta;
    private final HBox cajaPreguntaYRespuestas;


    public CajaPreguntaOC(Panel panel, LinkedList<String> respuestasJugador, Timer timer) {
        super();

        this.respuestasJugador = respuestasJugador;

        this.pregunta = panel.obtenerPreguntaActual();

        Label labelPregunta = new Label(pregunta.obtenerPregunta());

        VBox cajaOpciones = new VBox();

        pregunta.obtenerTodasLasOpciones().forEach((o) -> cajaOpciones.getChildren().add(new BotonOpcionDragAndDrop(o)));

        VBox cajaOpcionesOrdenadas = new VBox();
        BotonCajaOpcionesDragAndDrop grupoCorrecto = new BotonCajaOpcionesDragAndDrop("Arraste sus respuestas aqui:", respuestasJugador, cajaOpcionesOrdenadas);
        cajaOpcionesOrdenadas.getChildren().add(grupoCorrecto);

        Button botonResponder = new BotonResponder(panel, respuestasJugador, timer);

        this.cajaPreguntaYRespuestas = new HBox();
        cajaPreguntaYRespuestas.setSpacing(20);
        cajaPreguntaYRespuestas.getChildren().addAll(cajaOpciones, cajaOpcionesOrdenadas);

        VBox vb = new VBox();
        vb.setSpacing(25);
        vb.getChildren().addAll(labelPregunta, cajaPreguntaYRespuestas,botonResponder);


        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        respuestasJugador.removeAll(pregunta.obtenerTodasLasOpciones());

        VBox cajaOpciones = new VBox();
        pregunta.obtenerTodasLasOpciones().forEach((o) -> cajaOpciones.getChildren().add(new BotonOpcionDragAndDrop(o)));

        VBox cajaOpcionesOrdenadas = new VBox();
        BotonCajaOpcionesDragAndDrop grupoCorrecto = new BotonCajaOpcionesDragAndDrop("Arraste sus respuestas aqui:", respuestasJugador, cajaOpcionesOrdenadas);
        cajaOpcionesOrdenadas.getChildren().add(grupoCorrecto);

        cajaPreguntaYRespuestas.getChildren().clear();
        cajaPreguntaYRespuestas.getChildren().addAll(cajaOpciones, cajaOpcionesOrdenadas);
    }
}
