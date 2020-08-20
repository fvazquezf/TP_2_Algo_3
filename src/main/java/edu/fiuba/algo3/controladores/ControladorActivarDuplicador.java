package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorActivarDuplicador implements EventHandler<ActionEvent> {
    private final Panel panel;
    private final Button boton;

    public ControladorActivarDuplicador(Panel panel, Button botonDuplicador) {
        this.panel = panel;
        this.boton = botonDuplicador;
    }

    public void handle(ActionEvent actionEvent) {
        panel.activarDuplicador();
        boton.setDisable(true);
    }
}
