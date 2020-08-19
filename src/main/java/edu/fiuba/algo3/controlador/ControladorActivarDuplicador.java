package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorActivarDuplicador implements EventHandler<ActionEvent> {
    private final Panel panel;

    public ControladorActivarDuplicador(Panel panel) {
        this.panel = panel;
    }

    public void handle(ActionEvent actionEvent) {
        panel.activarDuplicador();
    }
}
