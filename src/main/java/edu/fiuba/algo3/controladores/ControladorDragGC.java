package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.vista.botones.BotonOpcionGC;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;


public class ControladorDragGC implements EventHandler<MouseEvent> {

    private final BotonOpcionGC boton;

    public ControladorDragGC(BotonOpcionGC botonOpcionGC) {
        this.boton = botonOpcionGC;
    }

    public void handle(MouseEvent event) {

        Dragboard db = boton.startDragAndDrop(TransferMode.ANY);

        ClipboardContent content = new ClipboardContent();
        content.putString(boton.getText());
        db.setContent(content);

        event.consume();
    }

}
