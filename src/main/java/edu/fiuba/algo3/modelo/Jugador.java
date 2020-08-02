package edu.fiuba.algo3.modelo;


import java.util.HashMap;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void responder(Respuesta respuestas, HashMap<Integer, Boolean> respuestasJugador) {
        puntos += respuestas.responder(respuestasJugador);
    }

    public int pedirPuntos() {
        return puntos;
    }
}


