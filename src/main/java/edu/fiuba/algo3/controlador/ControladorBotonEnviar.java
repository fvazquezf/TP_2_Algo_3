package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaAgregarJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

import java.util.HashSet;

public class ControladorBotonEnviar implements EventHandler<ActionEvent> {
    private  VistaAgregarJugador vista;
    private final Panel panel;

    public ControladorBotonEnviar(Panel panel, VistaAgregarJugador vista) {
        this.panel = panel;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

       panel.crearJugador(vista.obtenerNombre());
    }
}
