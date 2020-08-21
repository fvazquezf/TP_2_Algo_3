package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controladores.ControladorDrag;
import edu.fiuba.algo3.controladores.ControladorDrop;
import javafx.scene.control.Button;

public class BotonOpcionDragAndDrop extends Button {
    public BotonOpcionDragAndDrop(String opcion) {
        super();
        this.setText(opcion);

        ControladorDrag controladorDragGC = new ControladorDrag(this);
        this.setOnDragDetected(controladorDragGC);

        ControladorDrop controladorDropGC = new ControladorDrop(this);
        this.setOnDragDone(controladorDropGC);

    }
}
