package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Panel;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

import java.util.Collection;
import java.util.HashSet;

public class ControladorTimer implements EventHandler<ActionEvent> {

    private final Label label;
    private final Timeline tiempo;
    private final Panel panel;
    private final Integer tiempoInicial;

    public ControladorTimer(Integer tiempoInicial, Label label, Timeline tiempo, Panel panel) {
        this.panel = panel;
        this.tiempoInicial = tiempoInicial;
        this.label = label;
        this.tiempo = tiempo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int segundos = Integer.parseInt(label.getText());
        segundos--;
        if (segundos <= 0) {
            Collection<String> coleccionVacia = new HashSet<>();

            panel.hacerPregunta(coleccionVacia);

            label.setText(String.valueOf(tiempoInicial));
            tiempo.playFromStart();
        } else {
            label.setText(String.valueOf((segundos)));
        }
    }
}
