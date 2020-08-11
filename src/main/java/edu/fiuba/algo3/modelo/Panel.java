package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel{
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta pregunta;

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();
    private ArrayList<Observador> observadores = new ArrayList<>();


    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestas) {
        this.pregunta = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = new Jugador(nombre1);
        jugadorSiguiente = new Jugador(nombre2);
    }

    public void siguienteJugador() {
        Jugador jugadorTemp = jugadorActual;
        jugadorActual = jugadorSiguiente;
        jugadorSiguiente = jugadorTemp;

    }

    public String jugadorActual() {
        return jugadorActual.pedirNombre();
    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {
        int puntos = pregunta.compararRespuestas(respuestasJugadores);
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);
    }

    public void activarExclusividad() {
        pregunta.activarExclusividad();
        jugadorActual.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadorActual, jugadorSiguiente);
    }

    public void activarDuplicador() {
        jugadorActual.estadoDuplicador();
        pregunta.activarMultiplicador();
    }

    public void activarTriplicador() {
        jugadorActual.estadoTriplicador();
        pregunta.activarMultiplicador();
    }

    public int pedirPuntos(){
        return jugadorActual.pedirPuntos();
    }
}
