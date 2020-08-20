package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CajaTimer extends HBox {
    private final Timer timer;


    public CajaTimer(Panel panel) {
        super();

        timer = new Timer(10, panel);

        HBox reloj = new HBox();

        timer.iniciar();
        Label label = timer.obtenerLabel();

        Label tiempoRelojString = new Label();
        tiempoRelojString.setText("Tiempo Restante: ");

        reloj.getChildren().addAll(tiempoRelojString, label);


        this.getChildren().addAll(reloj);
    }

    public Timer devolverReloj() {
        return timer;
    }


}