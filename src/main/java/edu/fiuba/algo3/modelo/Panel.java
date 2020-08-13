package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

    private List<Pregunta> preguntas = new ArrayList<>();
    int numeroDePreguntaActual = 0;
    private Pregunta preguntaActual;
    private boolean cambiarPregunta = false;

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private Jugador jugador1;
    private Jugador jugador2;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestasCorrectas, Collection<String> todasRespuestas) {
        this.preguntas.add(fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
        preguntaActual = preguntas.get(0);
    }

    public void siguientePregunta() {
        numeroDePreguntaActual++;
        preguntaActual = preguntas.get(numeroDePreguntaActual);
    }

    public String obtenerPreguntaActual() {
        return preguntaActual.obtenerPregunta();
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return preguntaActual.obtenerTodasLasOpciones();
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = jugador1 = new Jugador(nombre1);
        jugadorSiguiente = jugador2 = new Jugador(nombre2);
    }

    public void siguienteJugador() {

        Jugador jugadorTemp = jugadorActual;
        jugadorActual = jugadorSiguiente;
        jugadorSiguiente = jugadorTemp;

        this.siguienteTurno();

    }

    public void siguienteTurno() {
        if (cambiarPregunta) {
            siguientePregunta();
            this.calcularExclusividad();
            cambiarPregunta = false;
        } else {
            cambiarPregunta = true;
        }
    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {
        int puntos = preguntaActual.compararRespuestas(respuestasJugadores);
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);
    }

    public void activarExclusividad() {
        preguntaActual.activarExclusividad();
        jugadorActual.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadorActual, jugadorSiguiente);
    }

    public void activarDuplicador() {
        jugadorActual.estadoDuplicador();
        preguntaActual.activarMultiplicador();
    }

    public void activarTriplicador() {
        jugadorActual.estadoTriplicador();
        preguntaActual.activarMultiplicador();
    }

    public Jugador pedirJugador1() {
        return (jugador1);
    }

    public Jugador pedirJugador2() {
        return (jugador2);
    }
}
