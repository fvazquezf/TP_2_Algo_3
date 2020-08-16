package edu.fiuba.algo3.modelo.comportamientos;

import java.util.Collection;

public class ComportamientoClasico implements Comportamiento {

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador, Collection<String> opcionesCorrectas) {
        if (opcionesCorrectas.equals(opcionesJugador))
            return 1;
        else
            return 0;
    }
}
