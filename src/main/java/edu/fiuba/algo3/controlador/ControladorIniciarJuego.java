package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaAgregarJugador;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private final Panel panel;
    private final Stage stage;
    private final VistaAgregarJugador vista;

    public ControladorIniciarJuego(Panel panel, Stage stage, VistaAgregarJugador vistaAgregarJugador) {
        this.panel = panel;
        this.stage = stage;
        this.vista = vistaAgregarJugador;
    }

    @Override
    public void handle(ActionEvent event) {
        panel.crearJugadores(vista.obtenerNombre1(), vista.obtenerNombre2());

        VistaPregunta vistaPregunta = new VistaPregunta(panel, stage);
        Scene scene = vistaPregunta.devolverVistaPregunta();

        stage.setScene(scene);
        stage.show();

    }
}