package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {
    private final boolean respuesta;
    private final String textoPregunta;

    public Pregunta(String unaPregunta, boolean unaRespuesta) {
        textoPregunta = unaPregunta;
        respuesta = unaRespuesta;
    }

    public String pasarPregunta() {
        return textoPregunta;
    }

    public boolean pasarRespuesta() {
        return respuesta;
    }

    public void hacerPregunta(ArrayList<Jugador> jugadores, ArrayList<Boolean> respuestasJugadores) {
        for (int i = 0; i < jugadores.size(); i++){
             jugadores.get(i).responder(respuesta, respuestasJugadores.get(i));
        }
    }
}
