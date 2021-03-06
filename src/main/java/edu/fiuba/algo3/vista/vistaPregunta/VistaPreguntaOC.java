package edu.fiuba.algo3.vista.vistaPregunta;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaPregunta;
import edu.fiuba.algo3.vista.cajas.CajaPreguntaOC;
import edu.fiuba.algo3.vista.cajas.CajaTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.LinkedList;
import java.util.List;

public class VistaPreguntaOC implements VistaPregunta {
    private final Panel panel;
    private final CajaJugadores cajaJugadores;
    private final CajaTimer cajaTimer;

    public VistaPreguntaOC(Panel panel, CajaJugadores cajaJugadores, CajaTimer cajaTimer) {
        this.panel = panel;
        this.cajaJugadores = cajaJugadores;
        this.cajaTimer = cajaTimer;
    }

    @Override
    public Scene devolverVistaPregunta() {
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(50, 100, 50, 100));

        LinkedList<String> respuestasJugador = new LinkedList<>();

        CajaPreguntaOC cajaPregunta = new CajaPreguntaOC(panel, respuestasJugador, cajaTimer.devolverReloj());
        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        cajaJugadores.activarExclusividades();

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);
        componentLayout.setRight(cajaTimer);

        return new Scene(componentLayout, 1280, 720);
    }

}
