package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String unNombre) {
        nombre = unNombre;
        puntos = 0;
    }

    public void responder(boolean unaRespuesta, boolean respuestaJugador) {
        if (unaRespuesta == respuestaJugador) {
            puntos++;
        }
    }

    public int pedirPuntos() {
        return puntos;
    }
}


