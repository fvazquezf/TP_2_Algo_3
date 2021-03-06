package edu.fiuba.algo3.controladores;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;


import java.util.Collection;

public class ControladorDragDropped implements EventHandler<DragEvent> {
    private final Collection<String> respuestasJugador;
    private final VBox cajaGrupo;

    public ControladorDragDropped(Collection<String> respuestasJugador, VBox cajaGrupo) {
        this.respuestasJugador = respuestasJugador;
        this.cajaGrupo = cajaGrupo;
    }

    public void handle(DragEvent event) {
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            respuestasJugador.add(db.getString());
            Label opcionAgregada = new Label();
            opcionAgregada.setText(db.getString());
            cajaGrupo.getChildren().add(opcionAgregada);

            success = true;
        }

        event.setDropCompleted(success);

        event.consume();
    }
}
