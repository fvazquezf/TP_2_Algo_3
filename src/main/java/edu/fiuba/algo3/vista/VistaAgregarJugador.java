package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class VistaAgregarJugador{

    private final Panel panel;
    private final Stage stage;
    private Label ingresoNombre;
    private TextField nombre;
    private Scene scene;

    public VistaAgregarJugador(Panel panel, Stage stage) {
        this.panel = panel;
        this.stage = stage;
    }

    public Scene devolverVistaAgregarJugador() {

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20, 200, 10, 100));

        ingresoNombre = new Label( "Jugador1 ingrese su nombre: ");
        nombre = new TextField();
        VBox vb = new VBox();
        vb.getChildren().addAll(ingresoNombre, nombre);
        vb.setSpacing(20);
        StackPane panelCenter = new StackPane();
        panelCenter.getChildren().add(vb);

        Button botonEnviar = new BotonEnviarNombre(panel, this, ingresoNombre);
        StackPane panelBottom = new StackPane();
        panelBottom.getChildren().add(botonEnviar);

        Button botonIniciar = new BotonIniciarJuego(panel, stage);
        StackPane panelLeft = new StackPane();
        panelLeft.getChildren().add(botonIniciar);

        componentLayout.setBottom(panelBottom);
        componentLayout.setCenter(panelCenter);
        componentLayout.setRight(panelLeft);

        this.scene = new Scene(componentLayout, 640, 480);

        return scene;
    }

    public String obtenerNombre() {
        return nombre.getText();
    }
}
