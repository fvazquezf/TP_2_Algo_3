package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.Collection;


public class ControladorResponderGC implements EventHandler<ActionEvent> {

    private final Panel panel;
    private final Timer timer;
    private final Collection<String> respuestasElegidas;
    private final Collection<String> opcionesDelOtroGrupo;


    public ControladorResponderGC(Panel panel, Collection<String> respuestasElegidas, Collection<String> opcionesDelOtroGrupo, Timer timer) {
        this.respuestasElegidas = respuestasElegidas;
        this.opcionesDelOtroGrupo = opcionesDelOtroGrupo;
        this.panel = panel;
        this.timer = timer;
    }

    @Override
    public void handle(ActionEvent event) {
        panel.hacerPregunta(respuestasElegidas, opcionesDelOtroGrupo);
        timer.reiniciar();
    }
}
