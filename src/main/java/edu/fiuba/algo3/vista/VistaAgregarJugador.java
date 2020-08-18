package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.botones.BotonIniciarJuego;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class VistaAgregarJugador {

    private final Panel panel;

    private TextField nombreJugador1;
    private TextField nombreJugador2;
    private Scene scene;

    public VistaAgregarJugador(Panel panel) {
        this.panel = panel;
    }

    public Scene devolverVistaAgregarJugador() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 200, 10, 100));

        Label ingresoNombre1 = new Label("Jugador1 ingrese su nombre: ");
        nombreJugador1 = new TextField();

        Label ingresoNombre2 = new Label("Jugador2 ingrese su nombre: ");
        nombreJugador2 = new TextField();

        VBox vb = new VBox();
        vb.getChildren().addAll(ingresoNombre1, nombreJugador1, ingresoNombre2, nombreJugador2);
        vb.setSpacing(20);
        StackPane panelCenter = new StackPane();
        panelCenter.getChildren().add(vb);

        Button botonIniciar = new BotonIniciarJuego(panel, this);
        StackPane panelLeft = new StackPane();
        panelLeft.getChildren().add(botonIniciar);

        componentLayout.setCenter(panelCenter);
        componentLayout.setRight(panelLeft);

        this.scene = new Scene(componentLayout, 640, 480);

        return scene;
    }

    public String obtenerNombre1() {
        return nombreJugador1.getText();
    }

    public String obtenerNombre2() {
        return nombreJugador2.getText();
    }
}
