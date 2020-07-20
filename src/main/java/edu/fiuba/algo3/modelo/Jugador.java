package edu.fiuba.algo3.modelo;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String s) {
        nombre = s;
        puntos = 0;
    }

    public boolean responder(boolean unaRespuesta) {
        return unaRespuesta;
    }

    public void asignarPuntos(boolean b) {
        if (b) {
            puntos++;
        }
    }

    public int pedirPuntos() {
        return puntos;
    }
}
