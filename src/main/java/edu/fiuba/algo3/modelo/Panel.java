package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel implements Observable{

    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private List<Pregunta> preguntas = new ArrayList<>();
    int numeroDePreguntaActual = 0;

    private boolean cambiarPregunta = false;

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();
    private ArrayList<Observador> observadores = new ArrayList<>();


    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestasCorrectas, Collection<String> todasRespuestas) {
        this.preguntas.add(fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = new Jugador(nombre1);
        jugadorSiguiente = new Jugador(nombre2);
    }

    public String obtenerPreguntaActual() {
        return preguntas.get(numeroDePreguntaActual).obtenerPregunta();
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return preguntas.get(numeroDePreguntaActual).obtenerTodasLasOpciones();
    }

    public void siguientePregunta() {
        numeroDePreguntaActual++;
        if(preguntas.size() == numeroDePreguntaActual) throw new ExcepcionYaNoHayPreguntasParaHacer();
        notificarObservador();
    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {
        int puntos = preguntas.get(numeroDePreguntaActual).compararRespuestas(respuestasJugadores);
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);

        siguienteJugador();
    }

    public void siguienteJugador() {
        Jugador jugadorTemp = jugadorActual;
        jugadorActual = jugadorSiguiente;
        jugadorSiguiente = jugadorTemp;

        siguienteTurno();
    }

    public void siguienteTurno() {
        if (cambiarPregunta) {
            calcularExclusividad();
            siguientePregunta();
            cambiarPregunta = false;
        } else {
            cambiarPregunta = true;
        }
    }

    public void activarExclusividad() {
        preguntas.get(numeroDePreguntaActual).activarExclusividad();
        jugadorActual.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadorActual, jugadorSiguiente);
    }

    public void activarDuplicador() {
        jugadorActual.estadoDuplicador();
        preguntas.get(numeroDePreguntaActual).activarMultiplicador();
    }

    public void activarTriplicador() {
        jugadorActual.estadoTriplicador();
        preguntas.get(numeroDePreguntaActual).activarMultiplicador();
    }

    public Jugador pedirJugadorActual() {
        return (jugadorActual);
    }

    public Jugador pedirJugadorSiguiente() {
        return (jugadorSiguiente);
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
