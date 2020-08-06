package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.HashSet;
import java.util.Set;

public class ControladorBotonFalso implements EventHandler<ActionEvent> {

    private Button miBoton;
    private Label puntos;

    public ControladorBotonFalso(Button botonFalso, Label puntos) {
        this.miBoton = miBoton;
        this.puntos = puntos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Set<String> respuestaJugador = new HashSet<>();
        respuestaJugador.add("F");

        Panel.obtenerPanel().hacerPregunta("Pancho", respuestaJugador);

        String textoClickeado = String.valueOf(Panel.obtenerPanel().pedirPuntos("Pancho"));

        this.puntos.setText(textoClickeado);
    }
}
