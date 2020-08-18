package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.HashSet;
import java.util.Set;


public class ControladorBotonOpcion implements EventHandler<ActionEvent> {


    private final Set<String> respuestasElegidas;
    private final String opcion;

    public ControladorBotonOpcion(Set<String> respuestasElegidas, String opcion) {
        this.respuestasElegidas = respuestasElegidas;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        respuestasElegidas.add(opcion);
    }
}
