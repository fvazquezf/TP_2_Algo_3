package edu.fiuba.algo3.controlador;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;

public class ControladorDragOverGC implements EventHandler<DragEvent> {

    public void handle(DragEvent event) {

        if (event.getGestureSource() != this &&
                event.getDragboard().hasString()) {
            event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
        }

        event.consume();
    }
}
