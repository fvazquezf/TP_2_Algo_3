package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.HashSet;

public class VistaPregunta implements Observador {

    private final Panel panel;
    private Label puntosJ1;
    private Label puntosJ2;

    public VistaPregunta(Panel panel){
        this.panel = panel;
    }


    public Scene devolverVistaPregunta(){
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        Label pregunta = new Label("una PreguntaVoF con penalidad (la respuesta es Verdadera)");
        StackPane panelTop = new StackPane();
        panelTop.getChildren().add(pregunta);


        panel.siguienteJugador();
        puntosJ1 = new Label("0");
        Label nombreJ1 = new Label("Jugador 1 " + panel.jugadorActual() + ": ");
        panel.siguienteJugador();

        puntosJ2 = new Label("0");
        Label nombreJ2 = new Label("Jugador 2 " + panel.jugadorActual() +": ");
        panel.siguienteJugador();

        HBox J1 = new HBox();
        J1.getChildren().addAll(nombreJ1, puntosJ1);

        HBox J2 = new HBox();
        J2.getChildren().addAll(nombreJ2, puntosJ2);

        VBox jugadores = new VBox();
        jugadores.getChildren().addAll(J1, J2);

        StackPane panelBottom = new StackPane();
        panelBottom.getChildren().add(jugadores);

        HashSet<String> respuestasJugador = new HashSet<>();

        Button botonFalso = new BotonOpcion("F", respuestasJugador);
        StackPane panelLeft = new StackPane();
        panelLeft.getChildren().add(botonFalso);

        Button botonVerdadero = new BotonOpcion("V", respuestasJugador);
        StackPane panelRight = new StackPane();
        panelRight.getChildren().add(botonVerdadero);

        Button botonResponder = new BotonResponder(panel, respuestasJugador);
        StackPane panelCenter = new StackPane();
        panelCenter.getChildren().add(botonResponder);


        componentLayout.setTop(panelTop);
        componentLayout.setLeft(panelLeft);
        componentLayout.setRight(panelRight);
        componentLayout.setBottom(panelBottom);
        componentLayout.setCenter(panelCenter);

        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }

    @Override
    public void actualizar() {
        String puntosJ1 = String.valueOf(panel.pedirPuntos(panel.jugadorActual()));
        panel.siguienteJugador();
        this.puntosJ1.setText(puntosJ1);

        String puntosJ2 = String.valueOf(panel.pedirPuntos(panel.jugadorActual()));
        panel.siguienteJugador();
        this.puntosJ2.setText(puntosJ2);

    }
}
