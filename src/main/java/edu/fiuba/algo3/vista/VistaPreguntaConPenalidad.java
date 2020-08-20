package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.HashSet;
import java.util.Set;

public class VistaPreguntaConPenalidad implements VistaPregunta {
    private final Panel panel;
    private final CajaJugadores cajaJugadores;
    private final CajaTimer cajaTimer;

    public VistaPreguntaConPenalidad(Panel panel, CajaJugadores cajaJugadores, CajaTimer cajaTimer) {
        this.panel = panel;
        this.cajaJugadores = cajaJugadores;
        this.cajaTimer = cajaTimer;
    }

    @Override
    public Scene devolverVistaPregunta() {
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 100, 10, 100));

        Set<String> respuestasJugador = new HashSet<>();


        CajaPregunta cajaPregunta = new CajaPregunta(panel, respuestasJugador, cajaTimer.devolverReloj());
        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        cajaJugadores.activarMultiplicadores();

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);
        componentLayout.setRight(cajaTimer);

        return new Scene(componentLayout, 640, 480);
    }
}
