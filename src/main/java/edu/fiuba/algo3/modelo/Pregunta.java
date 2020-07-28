package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta {
    protected Respuesta respuesta;
    protected String textoPregunta;

    public String pasarPregunta() {
        return textoPregunta;
    }
    public void hacerPregunta(ArrayList<Jugador> jugadores, ArrayList<String> respuestasJugadores) {
        for (int i = 0; i < jugadores.size(); i++){
            jugadores.get(i).responder(respuesta,respuestasJugadores.get(i));
        }
    }
}
