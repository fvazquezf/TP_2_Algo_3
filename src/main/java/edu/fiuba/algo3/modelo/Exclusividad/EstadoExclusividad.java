package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;

import java.util.*;

public class EstadoExclusividad {
    private final Dictionary<Jugador, Integer> puntosJugadores = new Hashtable();
    private Exclusividad estadoActual = new ExclusividadDesactivada();

    public void guardarRespuesta(Jugador jugador, int puntos) {
        puntosJugadores.put(jugador, puntos);
    }

    public void activarExclusividad() {
        estadoActual = estadoActual.proximo();
    }

    public void calcularExclusividad(Jugador J1, Jugador J2) {
        if (puntosJugadores.get(J1).equals(0) || puntosJugadores.get(J2).equals(0)) {
            J1.asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J1)));
            J2.asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J2)));
        }
        estadoActual = new ExclusividadDesactivada();
    }
}
