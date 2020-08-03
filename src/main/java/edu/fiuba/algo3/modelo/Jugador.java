package edu.fiuba.algo3.modelo;

import java.util.Set;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
    }


    public int pedirPuntos() {
        return puntos;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += puntos;
    }
}


