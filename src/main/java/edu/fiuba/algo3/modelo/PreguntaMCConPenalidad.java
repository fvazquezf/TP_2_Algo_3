package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class PreguntaMCConPenalidad extends Pregunta {

    public PreguntaMCConPenalidad(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new OpcionesCorrectasConPenalidad(respuesta);
    }
}
