package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CajaJugadores extends HBox implements Observador {

    private final Jugador j1;
    private final Jugador j2;

    private boolean turno = false;

    private final VBox exclusividades;
    private final CajaExclusividades cajaExclusividadesJ1;
    private final CajaExclusividades cajaExclusividadesJ2;

    private final VBox multiplicadores;
    private final CajaMultiplicadores cajaMultiplicadoresJ1;
    private final CajaMultiplicadores cajaMultiplicadoresJ2;

    private final Label puntosJ1;
    private final Label puntosJ2;

    private final Label nombreJ1;
    private final Label nombreJ2;

    public CajaJugadores(Panel panel) {

        j1 = panel.pedirJugadorActual();
        j1.agregarObservador(this);

        j2 = panel.pedirJugadorSiguiente();
        j2.agregarObservador(this);


        puntosJ1 = new Label(String.valueOf(j1.pedirPuntos()));
        nombreJ1 = new Label("Jugador 1 " + j1.pedirNombre() + ": ");
        nombreJ1.setStyle("-fx-font-weight: bold");
        puntosJ1.setStyle("-fx-font-weight: bold");

        puntosJ2 = new Label(String.valueOf(j2.pedirPuntos()));
        nombreJ2 = new Label("Jugador 2 " + j2.pedirNombre() + ": ");

        HBox J1 = new HBox();
        J1.getChildren().addAll(nombreJ1, puntosJ1);

        HBox J2 = new HBox();
        J2.getChildren().addAll(nombreJ2, puntosJ2);

        VBox jugadores = new VBox();
        jugadores.setSpacing(10);
        jugadores.getChildren().addAll(J1, J2);

        cajaExclusividadesJ1 = new CajaExclusividades(panel);

        cajaExclusividadesJ2 = new CajaExclusividades(panel);
        cajaExclusividadesJ2.setDisable(!turno);

        cajaMultiplicadoresJ1 = new CajaMultiplicadores(panel);
        cajaMultiplicadoresJ2 = new CajaMultiplicadores(panel);

        cajaMultiplicadoresJ2.setDisable(!turno);

        exclusividades = new VBox();
        exclusividades.setSpacing(10);
        exclusividades.getChildren().addAll(cajaExclusividadesJ1, cajaExclusividadesJ2);

        multiplicadores = new VBox();
        multiplicadores.setSpacing(10);
        multiplicadores.getChildren().addAll(cajaMultiplicadoresJ1, cajaMultiplicadoresJ2);

        this.setSpacing(10);

        this.getChildren().addAll(jugadores, exclusividades, multiplicadores);
    }

    public void activarMultiplicadores() {
        exclusividades.setDisable(true);
        multiplicadores.setDisable(false);
    }

    public void activarExclusividades() {
        exclusividades.setDisable(false);
        multiplicadores.setDisable(true);
    }

    @Override
    public void actualizar() {

        turno = !turno;
        cajaExclusividadesJ1.setDisable(turno);
        cajaExclusividadesJ2.setDisable(!turno);

        cajaMultiplicadoresJ1.setDisable(turno);
        cajaMultiplicadoresJ2.setDisable(!turno);

        String puntosJ1 = String.valueOf(j1.pedirPuntos());
        this.puntosJ1.setText(puntosJ1);
        String puntosJ2 = String.valueOf(j2.pedirPuntos());
        this.puntosJ2.setText(puntosJ2);

        if (!turno) {
            nombreJ1.setStyle("-fx-font-weight: bold");
            this.puntosJ1.setStyle("-fx-font-weight: bold");
        } else {
            nombreJ1.setStyle("-fx-font-weight: normal");
            this.puntosJ1.setStyle("-fx-font-weight: normal");
        }
        if (turno) {
            nombreJ2.setStyle("-fx-font-weight: bold");
            this.puntosJ2.setStyle("-fx-font-weight: bold");
        } else {
            nombreJ2.setStyle("-fx-font-weight: normal");
            this.puntosJ2.setStyle("-fx-font-weight: normal");
        }
    }
}
