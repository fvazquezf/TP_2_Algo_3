package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.multiplicadores.Ceroplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;

import java.util.*;

public class EstadoExclusividad {
    private final Dictionary<String, Integer> puntosJugadores = new Hashtable();
    private Multiplicador estadoActual =  new Ceroplicador();

    public void guardarRespuesta(String nombreJugador, int puntos) {
        puntosJugadores.put(nombreJugador, puntos);
    }

    public void activarExclusividad(){
        estadoActual = estadoActual.proximo();
    }
    public void desactivarExclusividad(){
        estadoActual = new Ceroplicador();
    }

    public void calcularExclusividad(HashMap<String, Jugador> jugadores) {
        Enumeration<String> nombresJugadores = puntosJugadores.keys();
        String J1 = nombresJugadores.nextElement();
        String J2 = nombresJugadores.nextElement();
        if((puntosJugadores.get(J1).equals(0) && !puntosJugadores.get(J2).equals(0)) || (puntosJugadores.get(J1) < puntosJugadores.get(J2)))
            jugadores.get(J2).asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J2)));
        if((!puntosJugadores.get(J1).equals(0) && puntosJugadores.get(J2).equals(0)) || (puntosJugadores.get(J1) > puntosJugadores.get(J2)) )
            jugadores.get(J1).asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J1)));

    }
}
