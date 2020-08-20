package edu.fiuba.algo3.vista.vistaPregunta;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.HashSet;
import java.util.Set;

public class VistaPreguntaGC implements VistaPregunta {
    private final Panel panel;
    private final CajaJugadores cajaJugadores;
    private final CajaTimer cajaTimer;

    public VistaPreguntaGC(Panel panel, CajaJugadores cajaJugadores, CajaTimer cajaTimer) {
        this.panel = panel;
        this.cajaJugadores = cajaJugadores;
        this.cajaTimer = cajaTimer;
    }


    public Scene devolverVistaPregunta() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(50, 100, 50, 100));

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add(panel.obtenerPreguntaActual().obtenerGrupoCorrecto());

        cajaJugadores.activarExclusividades();

        CajaPreguntaGC cajaPregunta = new CajaPreguntaGC(panel, respuestasJugador, cajaTimer.devolverReloj());
        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);
        componentLayout.setRight(cajaTimer);

        return new Scene(componentLayout, 1280, 720);
    }
}
