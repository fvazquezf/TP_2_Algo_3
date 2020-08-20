package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class VistaGameOver {

    public Scene devolverVistaGameOver() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 100, 10, 100));

        Label gameOver = new Label();

        gameOver.setText("game over");

        componentLayout.setCenter(gameOver);

        return new Scene(componentLayout, 640, 480);
    }
}
