package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VistaJuego implements Observador {
    private final Panel panel;
    private Stage stage;
    private FabricaVistaPregunta fabricaVistaPregunta = new FabricaVistaPregunta();

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
        Scene vistaPregunta = fabricaVistaPregunta.crearVista(panel, panel.tipoDePreguntaActual());
        stage.setScene(vistaPregunta);
        stage.show();
    }
}
