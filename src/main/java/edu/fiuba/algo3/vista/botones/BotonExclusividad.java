package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ControladorActivarExclusividad;
import edu.fiuba.algo3.modelo.Panel;

import javafx.scene.control.Button;

public class BotonExclusividad extends Button {
    public BotonExclusividad(Panel panel) {
        super();
        this.setText("Activar Exclusividad");
        ControladorActivarExclusividad controladorActivarExclusividad = new ControladorActivarExclusividad(panel);
        this.setOnAction(controladorActivarExclusividad);
    }
}
