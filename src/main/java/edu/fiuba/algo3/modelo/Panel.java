package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel implements Observable {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();

    private List<Pregunta> preguntas = new ArrayList<>();
    int numeroDePreguntaActual = 0;
    private Pregunta preguntaActual;

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private Jugador jugador1;
    private Jugador jugador2;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

    private List<Observador> observadores = new ArrayList<>();

    private boolean cambiarPregunta = false;


    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestasCorrectas, Collection<String> todasRespuestas) {
        this.preguntas.add(fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
        preguntaActual = preguntas.get(0);
    }

    public void siguientePregunta() {
        numeroDePreguntaActual++;
        preguntaActual = preguntas.get(numeroDePreguntaActual);
        this.notificarObservador();
    }

    public String obtenerPreguntaActual() {
        return preguntaActual.obtenerPregunta();
    }

    public Collection<String> obtenerTodasLasOpciones(){
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

        if (cambiarPregunta) {
            siguientePregunta();
            cambiarPregunta = false;
        } else {
            cambiarPregunta = true;
        }

    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {
        int puntos = preguntaActual.compararRespuestas(respuestasJugadores);
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);
        this.notificarObservador();
    }

    public void activarExclusividad() {
        preguntaActual.activarExclusividad();
        jugadorActual.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadorActual, jugadorSiguiente);
        this.notificarObservador();
    }

    public void activarDuplicador() {
        jugadorActual.estadoDuplicador();
        preguntaActual.activarMultiplicador();
    }

    public void activarTriplicador() {
        jugadorActual.estadoTriplicador();
        preguntaActual.activarMultiplicador();
    }

    public int pedirPuntos() {
        return jugadorActual.pedirPuntos();
    }

    public Jugador pedirJugador1() {
        return (jugador1);
    }

    public Jugador pedirJugador2() {
        return (jugador2);
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservador() {
        observadores.stream().forEach(observer -> observer.actualizar());
    }
}
