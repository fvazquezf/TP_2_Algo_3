package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaPregunta;
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
        respuestasJugador.add(panel.obtenerGrupoAComparar());

        CajaJugadores cajaJugadores = new CajaJugadores(panel, respuestasJugador);

        CajaPregunta cajaPregunta = new CajaPregunta(panel, respuestasJugador);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);


        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }
}