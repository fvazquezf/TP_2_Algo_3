package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.controlador.ControladorResponder;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;

import java.util.Collection;

public class BotonResponder extends Button {
    public BotonResponder(Panel panel, Collection<String> respuestasElegidas, Timer timer) {
        super();
        this.setText("Enviar Respuesta");
        ControladorResponder controladorBotonFalso = new ControladorResponder(panel, respuestasElegidas, timer);
        this.setOnAction(controladorBotonFalso);
    }
}
