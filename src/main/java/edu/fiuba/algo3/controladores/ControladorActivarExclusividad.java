package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteLasExclusividadesSalame;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ControladorActivarExclusividad implements EventHandler<ActionEvent> {
    private final Panel panel;
    private final Button boton;

    public ControladorActivarExclusividad(Panel panel, BotonExclusividad botonExclusividad) {
        this.panel = panel;
        this.boton = botonExclusividad;
    }

    public void handle(ActionEvent actionEvent) {
        try {
            panel.activarExclusividad();
        } catch (ExcepcionYaUsasteLasExclusividadesSalame e) {
            boton.setDisable(true);
            boton.setText("Ya usaste tu \nExclusividad SALAME ");
        }
    }
}
