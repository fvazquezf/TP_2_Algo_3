package edu.fiuba.algo3.modelo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class OpcionesCorrectasConPuntajeParcial implements OpcionesCorrectas {

    private Set<String> opciones;

    public OpcionesCorrectasConPuntajeParcial(Set<String> opciones) {
        this.opciones = opciones;
    }

    public Integer comparar(Collection<String> respuestasDelJugador) {
        int puntos = 0;
        for(String respuestaDelJugador: respuestasDelJugador){
            if (opciones.contains(respuestaDelJugador))
                puntos++;
            else
                return 0;
        }
        return puntos;
    }
}
