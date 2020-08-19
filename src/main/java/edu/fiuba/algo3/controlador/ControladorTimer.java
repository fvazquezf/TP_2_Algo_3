package edu.fiuba.algo3.controlador;

import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ControladorTimer implements EventHandler<ActionEvent> {

    private final Label label;
    private final Timeline tiempo;
    private Integer segundos;

    public ControladorTimer(Integer segundos, Label label, Timeline tiempo) {
        this.segundos = segundos;
        this.label = label;
        this.tiempo = tiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        segundos--;
        label.setText("Tiempo restante: " + segundos.toString());
        if (segundos <= 0)
            tiempo.stop();
    }
}
