package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CajaTimer extends HBox {
    private final Label label;
    private final Panel panel;


    public CajaTimer(Panel panel) {
        super();
        this.panel = panel;

        Timer timer = new Timer(10,panel);

        HBox reloj = new HBox();

        timer.iniciar();
        label = timer.obtenerLabel();

        reloj.getChildren().addAll(label);


        this.getChildren().addAll(reloj);
    }

}