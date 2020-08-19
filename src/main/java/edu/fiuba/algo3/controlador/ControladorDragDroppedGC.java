package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.botones.BotonCajaOpcionesGC;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;


import java.util.Collection;

public class ControladorDragDroppedGC implements EventHandler<DragEvent> {
    private final BotonCajaOpcionesGC boton;
    private final Collection<String> respuestasJugador;
    private final VBox cajaGrupo;

    public ControladorDragDroppedGC(BotonCajaOpcionesGC botonCajaOpcionesGC, Collection<String> respuestasJugador, VBox cajaGrupo) {
        this.boton = botonCajaOpcionesGC;
        this.respuestasJugador = respuestasJugador;
        this.cajaGrupo = cajaGrupo;
    }

    public void handle(DragEvent event) {
        /* if there is a string data on dragboard, read it and use it */
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            respuestasJugador.add(db.getString());
            Label opcionAgregada = new Label();
            opcionAgregada.setText(db.getString());
            cajaGrupo.getChildren().add(opcionAgregada);

            success = true;
        }
        /* let the source know whether the string was successfully
         * transferred and used */
        event.setDropCompleted(success);

        event.consume();
    }
}
