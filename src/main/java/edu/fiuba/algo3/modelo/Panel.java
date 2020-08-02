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
        preguntas = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugador(String nombre) {
        jugadores.put(nombre, (new Jugador(nombre)));
    }

    public void hacerPregunta(String nombreDelJugador, Set<String> respuestasJugadores) {
        preguntas.hacerPregunta(jugadores.get(nombreDelJugador), respuestasJugadores);
    }

    public int pedirPuntos(String nombreJugador) {
        return jugadores.get(nombreJugador).pedirPuntos();
    }


}
