package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class PreguntaMCConPuntajeParcial extends Pregunta {

    public PreguntaMCConPuntajeParcial(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new OpcionesCorrectasConPuntajeParcial(respuesta);
    }
}
