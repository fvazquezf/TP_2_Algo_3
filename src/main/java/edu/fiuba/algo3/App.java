package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.LectorPreguntas;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        LectorPreguntas lector = new LectorPreguntas();
        Panel panel = new Panel(lector);

        VistaJuego vistaJuego = new VistaJuego(stage, panel);

        vistaJuego.iniciarJuego();
    }

    public static void main(String[] args) {
        launch();
    }

}
