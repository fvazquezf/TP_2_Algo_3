package edu.fiuba.algo3.vista.botones;

import edu.fiuba.algo3.controlador.ControladorActivarDuplicador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Button;

public class BotonTriplicador extends Button {
    public BotonTriplicador(Panel panel) {
        super();
        this.setText("Activar Triplicador");
        ControladorActivarDuplicador controladorActivarDuplicador = new ControladorActivarDuplicador(panel);
        this.setOnAction(controladorActivarDuplicador);
    }
}
