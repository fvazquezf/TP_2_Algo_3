package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.util.HashSet;

public class VistaPregunta implements Observador {

    private final Panel panel;
    private Label puntos;

    public VistaPregunta(Panel panel){
        this.panel = panel;
        panel.agregarObservador(this);
    }


    public Scene devolverVistaPregunta(){
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        Label pregunta = new Label("una PreguntaVoF con penalidad (la respuesta es Verdadera)");
        StackPane panelTop = new StackPane();
        panelTop.getChildren().add(pregunta);

        puntos = new Label("0");
        StackPane panelBottom = new StackPane();
        panelBottom.getChildren().add(puntos);

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
        String puntos = String.valueOf(panel.pedirPuntos("Pancho"));
        this.puntos.setText(puntos);
    }
}
