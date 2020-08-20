package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class VistaGameOver {

    private final Panel panel;

    public VistaGameOver(Panel panel) {
        this.panel = panel;
    }

    public Scene devolverVistaGameOver() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(100, 100, 100, 100));

        Label gameOver = new Label();

        gameOver.setText("game over");

        VBox puntosFinales = new VBox();

        Label puntosJ1 = new Label();
        Jugador J1 = panel.pedirJugadorSiguiente();
        puntosJ1.setText(J1.pedirNombre() + ": " + J1.pedirPuntos());

        Label puntosJ2 = new Label();
        Jugador J2 = panel.pedirJugadorActual();
        puntosJ2.setText(J2.pedirNombre() + ": " + J2.pedirPuntos());

        puntosFinales.getChildren().addAll(puntosJ2, puntosJ1);

        componentLayout.setTop(gameOver);
        componentLayout.setCenter(puntosFinales);

        return new Scene(componentLayout, 1280, 720);
    }
}
