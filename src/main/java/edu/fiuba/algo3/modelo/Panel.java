package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import edu.fiuba.algo3.Preguntas;
import edu.fiuba.algo3.modelo.Exclusividad.EstadoExclusividad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaNoHayPreguntasParaHacer;
import edu.fiuba.algo3.modelo.manejoDeTurnos.EstadoFlowDelJuego;
import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Panel implements Observable {

    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private List<Pregunta> preguntas = new ArrayList<>();
    int numeroDePreguntaActual = 0;

    private EstadoFlowDelJuego estadoDelJuego = new EstadoFlowDelJuego();

    private Jugador jugadorActual;
    private Jugador jugadorSiguiente;

    private EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

    private ArrayList<Observador> observadores = new ArrayList<>();

    public Panel(){
        this.leerPreguntas();
    }

    public void crearPregunta(String tipoPregunta, String pregunta, String[] respuestasCorrectas, Collection<String> todasRespuestas, Map<String, String> grupos) {
        this.preguntas.add(fabricaPreguntas.crearPregunta(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas, grupos));
    }

    public void crearJugadores(String nombre1, String nombre2) {
        jugadorActual = new Jugador(nombre1);
        jugadorSiguiente = new Jugador(nombre2);

        notificarObservador();
    }

    public String obtenerPreguntaActual() {
        return preguntas.get(numeroDePreguntaActual).obtenerPregunta();
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return preguntas.get(numeroDePreguntaActual).obtenerTodasLasOpciones();
    }

    public void hacerPregunta(Collection<String> respuestasJugadores) {
        int puntos = preguntas.get(numeroDePreguntaActual).compararRespuestas(respuestasJugadores);
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

    public void leerPreguntas() {
        Gson gson = new Gson();
        String preguntas = null;

        try {
            preguntas = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Arrays.stream(gson.fromJson(preguntas, Preguntas[].class)).forEach(pregunta -> this.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos()));

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
