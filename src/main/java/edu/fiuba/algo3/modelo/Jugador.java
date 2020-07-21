package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String unNombre) {
        nombre = unNombre;
        puntos = 0;
    }

    public boolean responder(boolean unaRespuesta) {
        return unaRespuesta;
    }

    public void asignarPuntos(boolean unaRespuesta) {
        if (unaRespuesta) {
            puntos++;
        }
    }

    public int pedirPuntos() {
        return puntos;
    }
}
