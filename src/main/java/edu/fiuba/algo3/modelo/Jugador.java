package edu.fiuba.algo3.modelo;



import java.util.HashMap;

public class Jugador {

    private final String nombre;
    private int puntos;

    public Jugador(String unNombre) {
        nombre = unNombre;
        puntos = 0;
    }

//    public void  responder(Respuesta respuestas, String respuestaJugador) {
//        puntos += respuestas.responder(respuestaJugador);
//
//    }

    public void  responder(Respuesta respuestas, HashMap<Integer, Boolean> respuestaJugador) {
        puntos += respuestas.responder(respuestaJugador);

    }

    public int pedirPuntos() {
        return puntos;
    }
}


