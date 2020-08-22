package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ControladorDragDropped;
import edu.fiuba.algo3.controladores.ControladorDragOver;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class BotonCajaOpcionesDragAndDrop extends Button {
    public BotonCajaOpcionesDragAndDrop(String nombre, Collection<String> respuestasJugador, VBox cajaGrupo) {
        super();
        this.setText(nombre);

        this.setOnDragOver(new ControladorDragOver());

        ControladorDragDropped controladorDragDroppedGC = new ControladorDragDropped(respuestasJugador, cajaGrupo);
        this.setOnDragDropped(controladorDragDroppedGC);
    }

}
