package edu.fiuba.algo3.modelo.comportamientos;

import java.util.Collection;


public interface Comportamiento {

    Integer compararRespuestas(Collection<String> opcionesJugador, Collection<String> opcionesCorrectas);

}
