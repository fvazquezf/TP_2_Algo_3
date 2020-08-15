package edu.fiuba.algo3.modelo.comportamientos;

import java.util.Collection;

public class ComportamientoConPuntajeParcial implements Comportamiento {

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador, Collection<String> opcionesCorrectas) {
        int puntos = 0;
        for (String respuestaDelJugador : opcionesJugador) {
            if (opcionesCorrectas.contains(respuestaDelJugador))
                puntos++;
            else {
                return 0;
            }
        }
        return puntos;
    }
}
