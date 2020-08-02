package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Pregunta {
    protected Respuesta respuesta;
    protected String textoPregunta;

    public String pasarPregunta() {
        return textoPregunta;
    }

    public void hacerPregunta(HashMap<String, Jugador> jugadores, List<HashMap<Integer, Boolean>> respuestasJugadores) {
        int i = 0;
        for (Map.Entry<String, Jugador> jugador : jugadores.entrySet()) {
            jugador.getValue().responder(respuesta, respuestasJugadores.get(i));
            i++;
        }
    }
}
