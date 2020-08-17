package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BotonIniciarJuego extends Button {

    public BotonIniciarJuego(Panel panel, VistaAgregarJugador vistaAgregarJugador) {
        super();
        this.setText("Iniciar Juego");
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(panel, vistaAgregarJugador);
        this.setOnAction(controladorIniciarJuego);
    }
}
