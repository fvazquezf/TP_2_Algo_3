package edu.fiuba.algo3;

import edu.fiuba.algo3.controlador.ControladorTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

public class Timer {
    private Integer segundos;
    Label label = new Label();

    public Timer(Integer segundos) {
        this.segundos = segundos;
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font(20));
    }

    public void iniciar() {

        Timeline tiempo = new Timeline();
        tiempo.setCycleCount(Timeline.INDEFINITE);

        tiempo.stop();

        KeyFrame cuadro = new KeyFrame(Duration.seconds(1), new ControladorTimer(segundos, label, tiempo));

        tiempo.getKeyFrames().add(cuadro);
        tiempo.playFromStart();
    }

    public Label obtenerLabel() {
        return label;
    }
}
