package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.controlador.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaAgregarJugador;
import javafx.scene.control.Button;

public class BotonIniciarJuego extends Button {

    public BotonIniciarJuego(Panel panel, VistaAgregarJugador vistaAgregarJugador) {
        super();
        this.setText("Iniciar Juego");
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(panel, vistaAgregarJugador);
        this.setOnAction(controladorIniciarJuego);
    }
}
