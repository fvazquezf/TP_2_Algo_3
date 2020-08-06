package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ControladorBotonFalso;
import edu.fiuba.algo3.controlador.ControladorBotonVerdadero;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class VistaPregunta {
    public static Scene devolverVistaPregunta(){
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,20,10,20));

        Label pregunta = new Label("una PreguntaVoF con penalidad (la respuesta es Verdadera)");
        StackPane panelTop = new StackPane();
        panelTop.getChildren().add(pregunta);

        Label puntos = new Label("0");
        StackPane panelBottom = new StackPane();
        panelBottom.getChildren().add(puntos);

        Button botonFalso = new Button();
        botonFalso.setText("Falso");
        ControladorBotonFalso controladorBotonFalso = new ControladorBotonFalso(botonFalso,puntos);
        botonFalso.setOnAction(controladorBotonFalso);
        StackPane panelLeft = new StackPane();
        panelLeft.getChildren().add(botonFalso);

        Button botonVerdadero = new Button();
        botonVerdadero.setText("Verdadero");
        ControladorBotonVerdadero botonVerdaderoHandler = new ControladorBotonVerdadero(botonVerdadero, puntos);
        botonVerdadero.setOnAction(botonVerdaderoHandler);
        StackPane panelRight = new StackPane();
        panelRight.getChildren().add(botonVerdadero);


        componentLayout.setTop(panelTop);
        componentLayout.setLeft(panelLeft);
        componentLayout.setRight(panelRight);
        componentLayout.setBottom(panelBottom);

        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }
}
