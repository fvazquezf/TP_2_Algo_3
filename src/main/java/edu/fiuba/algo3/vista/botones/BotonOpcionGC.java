package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ControladorDragGC;
import edu.fiuba.algo3.controladores.ControladorDropGC;
import javafx.scene.control.Button;

public class BotonOpcionGC extends Button {
    public BotonOpcionGC(String opcion) {
        super();
        this.setText(opcion);

        ControladorDragGC controladorDragGC = new ControladorDragGC(this);
        this.setOnDragDetected(controladorDragGC);

        ControladorDropGC controladorDropGC = new ControladorDropGC(this);
        this.setOnDragDone(controladorDropGC);

    }
}
