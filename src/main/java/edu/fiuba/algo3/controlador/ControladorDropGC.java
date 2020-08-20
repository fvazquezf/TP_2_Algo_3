package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class ControladorDropGC implements EventHandler<DragEvent> {

    private final Button botonOpcionGC;

    public ControladorDropGC(Button botonOpcionGC) {
        this.botonOpcionGC = botonOpcionGC;
    }

    @Override
    public void handle(DragEvent event) {

        if (event.getTransferMode() == TransferMode.MOVE) {
            botonOpcionGC.setText("Opcion Guardada");

        }
        event.consume();
    }
}
