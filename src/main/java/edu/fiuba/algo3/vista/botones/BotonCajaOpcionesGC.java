package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ControladorDragDroppedGC;
import edu.fiuba.algo3.controlador.ControladorDragOverGC;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class BotonCajaOpcionesGC extends Button {
    public BotonCajaOpcionesGC(String opcion, Collection<String> respuestasJugador, VBox cajaGrupo) {
        super();
        this.setText(opcion);

        this.setOnDragOver(new ControladorDragOverGC());

        ControladorDragDroppedGC controladorDragDroppedGC = new ControladorDragDroppedGC(this, respuestasJugador, cajaGrupo);
        this.setOnDragDropped(controladorDragDroppedGC);
    }

}
