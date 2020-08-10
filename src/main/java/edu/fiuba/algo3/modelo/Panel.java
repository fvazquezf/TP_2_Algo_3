package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel {

    private final static Panel panel = new Panel();

    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta pregunta;
    private final HashMap<String, Jugador> jugadores;
    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


    public Panel() {
        jugadores = new HashMap<>();
    }

    public static Panel obtenerPanel(){
        return panel;
    }

    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestas) {
        this.pregunta = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugador(String nombre) {
        jugadores.put(nombre, (new Jugador(nombre)));
    }

    public void hacerPregunta(String nombreJugador, Collection<String> respuestasJugadores) {
        int puntos = pregunta.compararRespuestas(respuestasJugadores);
        jugadores.get(nombreJugador).asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(nombreJugador, puntos);
    }

    public void activarExclusividad(String nombreJugador) {
        pregunta.activarExclusividad();
        jugadores.get(nombreJugador).activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadores);
    }

    public void activarDuplicador(String nombreJugador) {
        jugadores.get(nombreJugador).estadoDuplicador();
        pregunta.activarMultiplicador();
    }

    public void activarTriplicador(String nombreJugador) {
        jugadores.get(nombreJugador).estadoTriplicador();
        pregunta.activarMultiplicador();
    }

    public int pedirPuntos(String nombreJugador) {
        return jugadores.get(nombreJugador).pedirPuntos();
    }
}
