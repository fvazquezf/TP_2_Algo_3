package edu.fiuba.algo3.controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class ControladorDrop implements EventHandler<DragEvent> {

    private final Button botonOpcionGC;

    public ControladorDrop(Button botonOpcionGC) {
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
