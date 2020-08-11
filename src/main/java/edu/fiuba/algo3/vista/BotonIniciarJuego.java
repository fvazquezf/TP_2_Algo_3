package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonEnviar;
import edu.fiuba.algo3.controlador.ControladorIniciarJuego;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BotonIniciarJuego extends Button {

    public BotonIniciarJuego(Panel panel, Stage stage) {
        super();
        this.setText("Iniciar Juego");
        ControladorIniciarJuego controladorIniciarJuego = new ControladorIniciarJuego(panel, stage);
        this.setOnAction(controladorIniciarJuego);
    }
}
