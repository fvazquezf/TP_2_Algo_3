package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorActivarExclusividad implements EventHandler<ActionEvent> {
    private final Panel panel;

    public ControladorActivarExclusividad(Panel panel) {
        this.panel = panel;
    }

    public void handle(ActionEvent actionEvent) {
        panel.activarExclusividad();
    }
}
