package edu.fiuba.algo3.modelo;

import java.util.Collection;
import java.util.LinkedList;


public class OpcionesCorrectasOrdered {

    private LinkedList<String> opciones;

    public OpcionesCorrectasOrdered(LinkedList<String> opcionesCorrectas) {
        this.opciones = opcionesCorrectas;
    }

    public Integer comparar(Collection<String> respuestasDelJugador) {
        if (opciones.equals(respuestasDelJugador))
            return 1;
        return 0;
    }
}
