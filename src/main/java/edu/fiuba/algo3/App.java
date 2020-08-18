package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaJuego;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Panel panel = new Panel();

        VistaJuego vistaJuego = new VistaJuego(stage, panel);

        vistaJuego.iniciarJuego();
    }

    public static void main(String[] args) {
        launch();
    }

}
