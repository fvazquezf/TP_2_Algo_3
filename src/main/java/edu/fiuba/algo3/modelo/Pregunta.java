package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public abstract class Pregunta {
    protected Respuesta respuesta;
    protected String textoPregunta;

    public String pasarPregunta() {
        return textoPregunta;
    }

    public void hacerPregunta(List<Jugador> jugadores, List<HashMap<Integer, Boolean>> respuestasJugadores) {

        for (int i = 0; i < jugadores.size(); i++) {
            jugadores.get(i).responder(respuesta, respuestasJugadores.get(i));
        }
    }
}
