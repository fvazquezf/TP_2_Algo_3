package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorResponder;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.HashSet;

public class BotonResponder extends Button {
    public BotonResponder(Panel panel, HashSet<String> respuestasElegidas, Stage stage) {
        super();
        this.setText("Enviar Respuesta");
        ControladorResponder controladorBotonFalso = new ControladorResponder(panel, respuestasElegidas, stage);
        this.setOnAction(controladorBotonFalso);
    }
}
