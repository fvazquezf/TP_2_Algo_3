package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.exclusividad.EstadoExclusividad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.modelo.manejoDeTurnos.EstadoFlowDelJuego;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.scene.media.AudioClip;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Panel implements Observable {


    private final List<Pregunta> preguntas = new ArrayList<>();
    int numeroDePreguntaActual = 0;

    private final EstadoFlowDelJuego estadoDelJuego = new EstadoFlowDelJuego();

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private final EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

    private final ArrayList<Observador> observadores = new ArrayList<>();

    static final String archivoFiesta = "rsc/diegoFiesta.wav";
    static final String archivoFrula = "rsc/pabloFrula.wav";

    public Panel(LectorPreguntas lector) {
        preguntas.addAll(lector.parsearPreguntas());
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = new Jugador(nombre1);
        jugadorSiguiente = new Jugador(nombre2);
    }

    public Jugador pedirJugadorActual() {
        return (jugadorActual);
    }

    public Jugador pedirJugadorSiguiente() {
        return (jugadorSiguiente);
    }

    public Pregunta obtenerPreguntaActual() {
        return preguntas.get(numeroDePreguntaActual);
    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {

        AudioClip sonido;
        if(!respuestasJugadores.isEmpty()){
            sonido = new AudioClip(new File(archivoFiesta).toURI().toString());
        }else{
            sonido = new AudioClip(new File(archivoFrula).toURI().toString());
        }
        sonido.play();

        int puntos = preguntas.get(numeroDePreguntaActual).compararRespuestas(respuestasJugadores);
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);

        estadoDelJuego.proximoEstado(this);
    }

    public void hacerPregunta(Collection<String> opcionesGrupoUno, Collection<String> opcionesDelOtroGrupo) {
        int puntos;
        if ((opcionesGrupoUno.size() + opcionesDelOtroGrupo.size()) == (preguntas.get(numeroDePreguntaActual).obtenerTodasLasOpciones().size() + 1)) {
            puntos = preguntas.get(numeroDePreguntaActual).compararRespuestas(opcionesGrupoUno);
        } else {
            puntos = preguntas.get(numeroDePreguntaActual).compararRespuestas(opcionesDelOtroGrupo);
        }
        jugadorActual.asignarPuntos(puntos);
        estadoExclusividad.guardarRespuesta(jugadorActual, puntos);
        estadoDelJuego.proximoEstado(this);
    }

    public void siguientePregunta() {
        numeroDePreguntaActual++;
        if (preguntas.size() == numeroDePreguntaActual) throw new ExcepcionYaNoHayPreguntasParaHacer();

        notificarObservador();
    }

    public void siguienteJugador() {
        Jugador jugadorTemp = jugadorActual;
        jugadorActual = jugadorSiguiente;
        jugadorSiguiente = jugadorTemp;
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
        jugadorActual.activarDuplicador();
        preguntas.get(numeroDePreguntaActual).activarMultiplicador();
    }

    public void activarTriplicador() {
        jugadorActual.activarTriplicador();
        preguntas.get(numeroDePreguntaActual).activarMultiplicador();
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservador() {
        observadores.forEach(Observador::actualizar);
    }
}
