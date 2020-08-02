package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta preguntas;
    private final List<Jugador> jugadores;

    public Panel() {
        jugadores = new ArrayList<>();
    }

    public void crearPregunta(String tipoPregunta, String pregunta, List<Boolean> respuestas) {
        try {
            preguntas = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
        } catch (ExcepcionTipoPreguntaInvalida e) {
            // En un futuro hay que refactorizar para pasar a la siguiente pregunta.
        }
    }

    public void crearJugador(String nombre) {
        jugadores.add(new Jugador(nombre));
    }

    public String pasarPregunta() {
        return preguntas.pasarPregunta();
    }


    public void hacerPregunta(List<HashMap<Integer, Boolean>> respuestasJugadores) {
        preguntas.hacerPregunta(jugadores, respuestasJugadores);
    }

    public List<Integer> pedirPuntos() {
        List<Integer> puntos = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            puntos.add(jugador.pedirPuntos());
        }
        return puntos;
    }


}
