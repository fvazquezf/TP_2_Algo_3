package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CajaJugadores extends VBox implements Observador {

    private final Jugador j1;
    private final Jugador j2;

    private final Label puntosJ1;
    private final Label puntosJ2;

    public CajaJugadores(Panel panel) {

        j1 = panel.pedirJugador1();
        j1.agregarObservador(this);

        j2 = panel.pedirJugador2();
        j2.agregarObservador(this);

        puntosJ1 = new Label("0");
        Label nombreJ1 = new Label("Jugador 1 " + j1.pedirNombre() + ": ");

        puntosJ2 = new Label("0");
        Label nombreJ2 = new Label("Jugador 2 " + j2.pedirNombre() + ": ");

        HBox J1 = new HBox();
        J1.getChildren().addAll(nombreJ1, puntosJ1);

        HBox J2 = new HBox();
        J2.getChildren().addAll(nombreJ2, puntosJ2);

        this.getChildren().addAll(J1, J2);
    }


    @Override
    public void actualizar() {
        String puntosJ1 = String.valueOf(j1.pedirPuntos());
        this.puntosJ1.setText(puntosJ1);

        String puntosJ2 = String.valueOf(j2.pedirPuntos());
        this.puntosJ2.setText(puntosJ2);
    }
}
