package edu.fiuba.algo3.modelo;


import java.util.Collection;
import java.util.Set;

public class OpcionesCorrectasClasicas implements OpcionesCorrectas {

    private Collection<String> opciones;

    public OpcionesCorrectasClasicas(Collection<String> opciones) {
        this.opciones = opciones;
    }

    public Integer comparar(Collection<String> respuestaDelJugador) {
        if (opciones.equals(respuestaDelJugador))
            return 1;
        return 0;
    }
}
