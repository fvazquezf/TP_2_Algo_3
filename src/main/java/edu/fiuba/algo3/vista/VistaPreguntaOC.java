package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaExclusividades;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaPregunta;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.LinkedList;
import java.util.List;

public class VistaPreguntaOC implements VistaPregunta{
    private final Panel panel;
    private final CajaJugadores cajaJugadores;

    public VistaPreguntaOC(Panel panel, CajaJugadores cajaJugadores){
        this.panel = panel;
        this.cajaJugadores = cajaJugadores;
    }

    @Override
    public Scene devolverVistaPregunta() {
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        List<String> respuestasJugador = new LinkedList<>();

        CajaPregunta cajaPregunta = new CajaPregunta(panel, respuestasJugador);
        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);

        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }

}
