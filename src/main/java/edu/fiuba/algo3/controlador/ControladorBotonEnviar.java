package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaAgregarJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;


public class ControladorBotonEnviar implements EventHandler<ActionEvent> {
    private final Label ingresoNombre;
    private  VistaAgregarJugador vista;
    private final Panel panel;

    public ControladorBotonEnviar(Panel panel, VistaAgregarJugador vista, Label ingresoNombre) {
        this.panel = panel;
        this.vista = vista;
        this.ingresoNombre = ingresoNombre;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
       panel.crearJugador(vista.obtenerNombre());
       ingresoNombre.setText("Jugador2 ingrese su nombre: ");
    }
}
