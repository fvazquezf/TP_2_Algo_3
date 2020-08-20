package edu.fiuba.algo3.vista.vistaPregunta;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaPregunta;
import edu.fiuba.algo3.vista.cajas.CajaTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.HashSet;
import java.util.Set;

public class VistaPreguntaClasica implements VistaPregunta {

    private final Panel panel;
    private final CajaJugadores cajaJugadores;
    private final CajaTimer cajaTimer;

    public VistaPreguntaClasica(Panel panel, CajaJugadores cajaJugadores, CajaTimer cajaTimer) {
        this.panel = panel;
        this.cajaJugadores = cajaJugadores;
        this.cajaTimer = cajaTimer;
    }


    public Scene devolverVistaPregunta() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 100, 10, 100));

        Set<String> respuestasJugador = new HashSet<>();

        CajaPregunta cajaPregunta = new CajaPregunta(panel, respuestasJugador, cajaTimer.devolverReloj());

        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        cajaJugadores.activarExclusividades();

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);
        componentLayout.setRight(cajaTimer);

        return new Scene(componentLayout, 640, 480);
    }
}
