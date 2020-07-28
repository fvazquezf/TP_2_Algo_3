package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public interface Pregunta {
    public String pasarPregunta();
    void hacerPregunta(ArrayList<Jugador> jugadores, ArrayList<String> respuestasJugadores);
}
