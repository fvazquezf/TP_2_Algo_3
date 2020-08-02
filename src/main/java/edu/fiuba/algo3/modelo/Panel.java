package edu.fiuba.algo3.modelo;

import java.util.*;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta preguntas;
    private final HashMap<String, Jugador> jugadores;

    public Panel() {
        jugadores = new HashMap<>();
    }

    public void crearPregunta(String tipoPregunta, String pregunta, Set<String> respuestas) {
        try {
            preguntas = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
        } catch (ExcepcionTipoPreguntaInvalida e) {
            // En un futuro hay que refactorizar para pasar a la siguiente pregunta.
        }
    }

    public void crearJugador(String nombre) {
        jugadores.put(nombre, (new Jugador(nombre)));
    }

    public String pasarPregunta() {
        return preguntas.pasarPregunta();
    }

    public void hacerPregunta(List<HashMap<Integer, Boolean>> respuestasJugadores) {
        preguntas.hacerPregunta(jugadores, respuestasJugadores);
    }

    public List<Integer> pedirPuntos() {
        List<Integer> puntos = new ArrayList<>();
        for (Map.Entry<String, Jugador> jugador : jugadores.entrySet()) {
            puntos.add(jugador.getValue().pedirPuntos());
        }
        return puntos;
    }


}
