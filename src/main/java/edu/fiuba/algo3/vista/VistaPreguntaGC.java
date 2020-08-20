package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaExclusividades;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaPregunta;
import edu.fiuba.algo3.vista.cajas.CajaPreguntaGC;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.util.HashSet;
import java.util.Set;

public class VistaPreguntaGC implements VistaPregunta{
    private final Panel panel;

    public VistaPreguntaGC(Panel panel){
        this.panel = panel;
    }


    public Scene devolverVistaPregunta(){

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        Set<String> respuestasJugador = new HashSet<>();
        respuestasJugador.add(panel.obtenerPreguntaActual().obtenerGrupoCorrecto());

        CajaJugadores cajaJugadores = new CajaJugadores(panel, respuestasJugador);

        CajaPreguntaGC cajaPregunta = new CajaPreguntaGC(panel, respuestasJugador);
        panel.obtenerPreguntaActual().agregarObservador(cajaPregunta);

        CajaExclusividades cajaExclusividades = new CajaExclusividades(panel);
        panel.obtenerEstadoExclusividad().agregarObservador(cajaExclusividades);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);
        componentLayout.setRight(cajaExclusividades);

        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }
}
