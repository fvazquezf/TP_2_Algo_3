package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ControladorBotonOpcion;
import javafx.scene.control.Button;

import java.util.Collection;

public class BotonOpcion extends Button {

    public BotonOpcion(String opcion, Collection<String> respuestasElegidas) {
        super();
        this.setText(opcion);
        ControladorBotonOpcion controladorBotonOpcion = new ControladorBotonOpcion(respuestasElegidas, opcion);
        this.setOnAction(controladorBotonOpcion);
    }
}
