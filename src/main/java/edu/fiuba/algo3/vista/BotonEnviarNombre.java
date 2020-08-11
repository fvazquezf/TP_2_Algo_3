package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonEnviar;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class BotonEnviarNombre extends Button {

    public BotonEnviarNombre(Panel panel, VistaAgregarJugador vista) {
        super();
        this.setText("Enviar");
        ControladorBotonEnviar controladorBotonEnviar = new ControladorBotonEnviar(panel, vista);
        this.setOnAction(controladorBotonEnviar);
    }
}