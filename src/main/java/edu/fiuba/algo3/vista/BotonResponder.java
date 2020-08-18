package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorResponder;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;

import java.util.Set;

public class BotonResponder extends Button {
    public BotonResponder(Panel panel, Set<String> respuestasElegidas) {
        super();
        this.setText("Enviar Respuesta");
        ControladorResponder controladorBotonFalso = new ControladorResponder(panel, respuestasElegidas);
        this.setOnAction(controladorBotonFalso);
    }
}
