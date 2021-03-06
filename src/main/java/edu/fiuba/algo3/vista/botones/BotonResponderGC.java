package edu.fiuba.algo3.vista.botones;


import edu.fiuba.algo3.vista.Timer;
import edu.fiuba.algo3.controladores.ControladorResponderGC;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;

import java.util.Collection;

public class BotonResponderGC extends Button {
    public BotonResponderGC(Panel panel, Collection<String> respuestasElegidas, Collection<String> respuestasDelOtroGrupo, Timer timer) {
        super();
        this.setText("Enviar Respuesta");

        ControladorResponderGC controladorBoton = new ControladorResponderGC(panel, respuestasElegidas, respuestasDelOtroGrupo, timer);
        this.setOnAction(controladorBoton);
    }
}
