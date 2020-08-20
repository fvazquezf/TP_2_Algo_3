package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

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
