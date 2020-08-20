package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorTimer;
import edu.fiuba.algo3.modelo.Panel;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Timer {
    private final Panel panel;
    private Integer segundos;
    Label label = new Label();
    private Timeline tiempo;

    public Timer(Integer segundos, Panel panel) {
        this.segundos = segundos;
        this.panel = panel;

        label.setText(String.valueOf(segundos));
    }

    public void iniciar() {
        tiempo = new Timeline();
        tiempo.setCycleCount(Timeline.INDEFINITE);

        tiempo.stop();

        KeyFrame cuadro = new KeyFrame(Duration.seconds(1), new ControladorTimer(segundos, label, tiempo, panel));

        tiempo.getKeyFrames().add(cuadro);
        tiempo.playFromStart();
    }

    public Label obtenerLabel() {
        return label;
    }

    public void reiniciar() {
        label.setText(String.valueOf(segundos));
        tiempo.playFromStart();
    }
}
