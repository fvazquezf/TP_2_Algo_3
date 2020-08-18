package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaJuego implements Observador {
    private final Panel panel;
    private Stage stage;

    public VistaJuego(Stage stage, Panel panel) {
        this.stage = stage;
        this.stage.setTitle("elCajú");
        this.panel = panel;
        this.panel.agregarObservador(this);
    }

    public void iniciarJuego() {
        VistaAgregarJugador vistaAgregarJugador = new VistaAgregarJugador(panel);

        Scene scene = vistaAgregarJugador.devolverVistaAgregarJugador();

        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void actualizar() {
        VistaPregunta vistaPregunta = new VistaPregunta(panel);
        Scene scene = vistaPregunta.devolverVistaPregunta();
        stage.setScene(scene);
        stage.show();
    }
}
