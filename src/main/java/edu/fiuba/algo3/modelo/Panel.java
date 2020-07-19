package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Panel {

    private Pregunta preguntas;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList respuestas;

    public void crearPreguntaVoFClasica(String s, boolean b) {
        Pregunta pregunta = new Pregunta(s,b);
        preguntas = pregunta;
    }

    public boolean pasarRespuesta() {
        return preguntas.pasarRespuesta();
    }

    public void crearJugador1(String s) {
        jugador1 = new Jugador(s);
    }

    public void crearJugador2(String s) {
        jugador2 = new Jugador(s);
    }

    public void pedirRespuestas() {
        respuestas.add(jugador1.responder(true));
        respuestas.add(jugador2.responder(false));
    }

    public void chequearRespuestas() {
        jugador1.asignarPuntos(preguntas.chequearRespuesta((Boolean) respuestas.get(0)));
        jugador2.asignarPuntos(preguntas.chequearRespuesta((Boolean) respuestas.get(1)));
    }

    public int pedirPuntosJugador1() {
        return jugador1.pedirPuntos();
    }

    public int pedirPuntosJugador2() {
        return jugador2.pedirPuntos();
    }
}
