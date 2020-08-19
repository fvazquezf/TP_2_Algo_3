package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.Timer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CajaTimer extends HBox {
    private final Label label;

    public CajaTimer() {
        super();

        Timer timer = new Timer(20);

        HBox reloj = new HBox();

        timer.iniciar();
        label = timer.obtenerLabel();

        reloj.getChildren().addAll(label);

        this.getChildren().addAll(reloj);
    }

}