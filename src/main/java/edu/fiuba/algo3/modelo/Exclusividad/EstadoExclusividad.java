package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;

import java.util.*;

public class EstadoExclusividad implements Observable {
    private final Dictionary<Jugador, Integer> puntosJugadores = new Hashtable();
    private Exclusividad estadoActual = new ExclusividadDesactivada();
    private List<Observador> observadores = new ArrayList<>();

    public void guardarRespuesta(Jugador jugador, int puntos) {
        puntosJugadores.put(jugador, puntos);
    }

    public void activarExclusividad() {
        estadoActual = estadoActual.proximo();
        notificarObservador();
    }

    public void calcularExclusividad(Jugador J1, Jugador J2) {
        if (puntosJugadores.get(J1).equals(0) || puntosJugadores.get(J2).equals(0)) {
            J1.asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J1)));
            J2.asignarPuntos(estadoActual.multiplicar(puntosJugadores.get(J2)));
        }
        estadoActual = new ExclusividadDesactivada();
    }

    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void notificarObservador() {
        observadores.stream().forEach(observer -> observer.actualizar());
    }
}
