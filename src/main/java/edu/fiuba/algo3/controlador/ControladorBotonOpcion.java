package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashSet;
import java.util.Set;

public class ControladorBotonOpcion implements EventHandler<ActionEvent> {


    private final HashSet<String> respuestasElegidas;
    private final String opcion;

    public ControladorBotonOpcion(HashSet<String> respuestasElegidas, String opcion) {
        this.respuestasElegidas = respuestasElegidas;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        respuestasElegidas.add(opcion);
    }
}
