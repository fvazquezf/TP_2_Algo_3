package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ControladorIniciarJuego implements EventHandler<ActionEvent> {

    private final Panel panel;
    private final Stage stage;

    public ControladorIniciarJuego(Panel panel, Stage stage) {
        this.panel = panel;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        VistaPregunta vistaPregunta = new VistaPregunta(panel);
        Scene scene = vistaPregunta.devolverVistaPregunta();

        stage.setScene(scene);
        stage.show();

    }
}
