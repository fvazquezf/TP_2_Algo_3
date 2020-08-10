package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonOpcion;
import javafx.scene.control.Button;

import java.util.HashSet;

public class BotonOpcion extends Button {

    public BotonOpcion(String opcion, HashSet<String> respuestasElegidas) {
        super();
        this.setText(opcion);
        ControladorBotonOpcion controladorBotonOpcion = new ControladorBotonOpcion(respuestasElegidas, opcion);
        this.setOnAction(controladorBotonOpcion);
    }
}
