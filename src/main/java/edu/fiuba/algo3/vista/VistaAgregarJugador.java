package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.HashSet;

public class VistaAgregarJugador implements Observador {

    private final Panel panel;
    private Label ingresoNombre;
    private TextField nombre;

    public VistaAgregarJugador(Panel panel) {
        this.panel = panel;
        panel.agregarObservador(this);
    }

    public Scene devolverVistaAgregarJugador() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        ingresoNombre = new Label("Ingrese su nombre: ");
        nombre = new TextField();
        VBox vb = new VBox();
        vb.getChildren().addAll(ingresoNombre, nombre);
        vb.setSpacing(20);
        StackPane panelCenter = new StackPane();
        panelCenter.getChildren().add(vb);

        Button botonEnviar = new BotonEnviarNombre( panel,this);
        StackPane panelBottom = new StackPane();
        panelBottom.getChildren().add(botonEnviar);


        componentLayout.setBottom(panelBottom);
        componentLayout.setCenter(panelCenter);

        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }
    public String obtenerNombre() {
        return nombre.getText();
    }

    public void actualizar () {
        this.nombre = new TextField("Ingrese Otro Jugador");
    }
}
