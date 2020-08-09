package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta pregunta;
    private final HashMap<String, Jugador> jugadores;
    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


    public Panel() {
        jugadores = new HashMap<>();
    }

    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestas) {
        this.pregunta = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugador(String nombre) {
        jugadores.put(nombre, (new Jugador(nombre)));
    }

    public void hacerPregunta(String nombreJugador, Collection<String> respuestasJugadores) {
        Jugador jugador = jugadores.get(nombreJugador);
        int puntos = pregunta.compararRespuestas(respuestasJugadores);
        jugador.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(nombreJugador, puntos);
    }

    public void activarExclusividad(String nombreJugador) {
        Jugador jugador = jugadores.get(nombreJugador);
        pregunta.activarExclusividad();
        jugador.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadores);
        estadoExclusividad.desactivarExclusividad();
    }

    public void activarDuplicador(String nombreJugador) {
        Jugador jugador = jugadores.get(nombreJugador);
        pregunta.activarMultiplicador();
        jugador.estadoDuplicador();
    }

    public void activarTriplicador(String nombreJugador) {
        Jugador jugador = jugadores.get(nombreJugador);
        pregunta.activarMultiplicador();
        jugador.estadoTriplicador();
    }

    public int pedirPuntos(String nombreJugador) {
        return jugadores.get(nombreJugador).pedirPuntos();
    }
}
