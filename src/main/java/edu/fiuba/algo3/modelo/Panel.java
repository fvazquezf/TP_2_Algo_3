package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.util.*;

public class Panel implements Observable{
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta pregunta;

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private Jugador jugador1;
    private Jugador jugador2;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

    private List<Observador> observadores  = new ArrayList<>();


    public void crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestas) {
        this.pregunta = fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestas);
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = jugador1 =  new Jugador(nombre1);
        jugadorSiguiente = jugador2 = new Jugador(nombre2);
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
        this.notificarObservador();
    }

    public void activarExclusividad() {
        pregunta.activarExclusividad();
        jugadorActual.activarExclusividad();
        estadoExclusividad.activarExclusividad();
    }

    public void calcularExclusividad() {
        estadoExclusividad.calcularExclusividad(jugadorActual, jugadorSiguiente);
        this.notificarObservador();
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

    public Jugador pedirJugador1(){
        return(jugador1);
    }
    public Jugador pedirJugador2(){
        return(jugador2);
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
