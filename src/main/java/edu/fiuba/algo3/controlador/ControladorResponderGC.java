package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Collection;


public class ControladorResponderGC implements EventHandler<ActionEvent> {

    private final Panel panel;
    private Collection<String> respuestasElegidas;
    private Collection<String> opcionesDelOtroGrupo;


    public ControladorResponderGC(Panel panel, Collection<String> respuestasElegidas, Collection<String> opcionesDelOtroGrupo) {
        this.respuestasElegidas = respuestasElegidas;
        this.opcionesDelOtroGrupo = opcionesDelOtroGrupo;
        this.panel = panel;
    }
    @Override
    public void handle(ActionEvent event) {
        panel.hacerPregunta(respuestasElegidas, opcionesDelOtroGrupo);
    }
}
