package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorActivarTriplicador implements EventHandler<ActionEvent> {
    private final Panel panel;
    private final Button boton;

    public ControladorActivarTriplicador(Panel panel, Button botonTriplicador) {
        this.panel = panel;
        this.boton = botonTriplicador;
    }

    public void handle(ActionEvent actionEvent) {
        panel.activarTriplicador();
        boton.setDisable(true);
    }
}
