package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta pregunta;
    private final HashMap<String, Jugador> jugadores;

    public Panel() {
        jugadores = new HashMap<>();
    }

    public void crearPregunta(String tipoPregunta, String pregunta, Set<String> respuestas) {
        this.pregunta = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugador(String nombre) {
        jugadores.put(nombre, (new Jugador(nombre)));
    }

    public void hacerPregunta(String nombreJugador, Set<String> respuestasJugadores) {
        Jugador jugador = jugadores.get(nombreJugador);
        int puntos = pregunta.compararRespuestas(respuestasJugadores);
        jugador.asignarPuntos(puntos);
    }

    public void usarDuplicador(String nombreJugador) {
        Jugador jugador = jugadores.get(nombreJugador);
        pregunta.usarMultiplicador();
        jugador.estadoDuplicador();
    }

    public void usarTriplicador(String nombreJugador) {
        Jugador jugador = jugadores.get(nombreJugador);
        pregunta.usarMultiplicador();
        jugador.estadoTriplicador();
    }

    public int pedirPuntos(String nombreJugador) {
        return jugadores.get(nombreJugador).pedirPuntos();
    }
}
