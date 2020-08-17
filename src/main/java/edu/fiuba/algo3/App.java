package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaAgregarJugador;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Panel panel = new Panel();

        VistaAgregarJugador vistaAgregarJugador = new VistaAgregarJugador(panel, stage);
        Scene scene = vistaAgregarJugador.devolverVistaAgregarJugador();

        stage.setTitle("elCajú");
        stage.setScene(scene);
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}
