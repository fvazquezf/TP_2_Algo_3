package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class OpcionesCorrectasConPenalidad implements OpcionesCorrectas {

    private Set<String> opciones;

    public OpcionesCorrectasConPenalidad(Set<String> opciones) {
        this.opciones = opciones;
    }

    public Integer comparar(Set<String> respuestaDelJugador) {
        if (opciones.equals(respuestaDelJugador))
            return 1;
        return -1;
    }
}
