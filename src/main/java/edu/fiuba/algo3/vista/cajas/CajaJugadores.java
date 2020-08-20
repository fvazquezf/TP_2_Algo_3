package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;

public class CajaJugadores extends HBox implements Observador {

    private final Jugador j1;
    private final Jugador j2;

    private boolean turno = false;

    private CajaExclusividades cajaExclusividadesJ1;
    private CajaExclusividades cajaExclusividadesJ2;

    private final Label puntosJ1;
    private final Label puntosJ2;

    public CajaJugadores(Panel panel) {

        j1 = panel.pedirJugadorActual();
        j1.agregarObservador(this);

        j2 = panel.pedirJugadorSiguiente();
        j2.agregarObservador(this);


        puntosJ1 = new Label(String.valueOf(j1.pedirPuntos()));
        Label nombreJ1 = new Label("Jugador 1 " + j1.pedirNombre() + ": ");

        puntosJ2 = new Label(String.valueOf(j2.pedirPuntos()));
        Label nombreJ2 = new Label("Jugador 2 " + j2.pedirNombre() + ": ");

        HBox J1 = new HBox();
        J1.getChildren().addAll(nombreJ1, puntosJ1);

        HBox J2 = new HBox();
        J2.getChildren().addAll(nombreJ2, puntosJ2);

        VBox jugadores = new VBox();
        jugadores.setSpacing(10);
        jugadores.getChildren().addAll(J1, J2);

        cajaExclusividadesJ1 = new CajaExclusividades(panel);
        panel.obtenerEstadoExclusividad().agregarObservador(cajaExclusividadesJ1);

        cajaExclusividadesJ2 = new CajaExclusividades(panel);
        cajaExclusividadesJ2.setDisable(!turno);
        panel.obtenerEstadoExclusividad().agregarObservador(cajaExclusividadesJ2);

        VBox exclusividades = new VBox();
        exclusividades.setSpacing(10);
        exclusividades.getChildren().addAll(cajaExclusividadesJ1, cajaExclusividadesJ2);

        this.getChildren().addAll(jugadores, exclusividades);
    }


    @Override
    public void actualizar() {

        turno = !turno;
        cajaExclusividadesJ1.setDisable(turno);
        cajaExclusividadesJ2.setDisable(!turno);

        String puntosJ1 = String.valueOf(j1.pedirPuntos());
        this.puntosJ1.setText(puntosJ1);

        String puntosJ2 = String.valueOf(j2.pedirPuntos());
        this.puntosJ2.setText(puntosJ2);
    }
}
