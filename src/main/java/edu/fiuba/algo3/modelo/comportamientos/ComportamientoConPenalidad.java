package edu.fiuba.algo3.modelo.comportamientos;

import java.util.Collection;

public class ComportamientoConPenalidad implements Comportamiento {

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador, Collection<String> opcionesCorrectas) {
        int puntos = 0;
        for (String respuestaDelJugador : opcionesJugador) {
            if (opcionesCorrectas.contains(respuestaDelJugador))
                puntos++;
            else
                puntos--;
        }
        return puntos;
    }
}
