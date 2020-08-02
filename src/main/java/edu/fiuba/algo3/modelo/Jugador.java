package edu.fiuba.algo3.modelo;

import java.util.Set;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }

    public void responder(OpcionesCorrectas opcionesCorrectas, Set<String> respuestasJugador) {
        puntos += opcionesCorrectas.comparar(respuestasJugador);
    }

    public int pedirPuntos() {
        return puntos;
    }
}


