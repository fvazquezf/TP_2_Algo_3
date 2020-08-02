package edu.fiuba.algo3.modelo;

import java.util.Set;

public abstract class Pregunta {
    protected OpcionesCorrectas opcionesCorrectas;
    protected String textoPregunta;

    public void hacerPregunta(Jugador jugador, Set<String> respuestasJugador) {
        jugador.responder(opcionesCorrectas, respuestasJugador);
    }
}
