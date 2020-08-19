package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.botones.BotonOpcionGC;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class ControladorDropGC implements EventHandler<DragEvent> {


    private final BotonOpcionGC boton;

    public ControladorDropGC(BotonOpcionGC botonOpcionGC) {
        this.boton = botonOpcionGC;
    }
    @Override
    public void handle(DragEvent event) {

        if (event.getTransferMode() == TransferMode.MOVE) {
            boton.setText("Opcion Guardada");
        }
        event.consume();
    }
}
