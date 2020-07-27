package edu.fiuba.algo3.modelo;



public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String unNombre) {
        nombre = unNombre;
        puntos = 0;
    }

    public void  responder(Respuesta respuestaCorrecta,String respuestaJugador) {
        if(respuestaCorrecta.responder(respuestaJugador))
            puntos++;
    }

    public int pedirPuntos() {
        return puntos;
    }
}


