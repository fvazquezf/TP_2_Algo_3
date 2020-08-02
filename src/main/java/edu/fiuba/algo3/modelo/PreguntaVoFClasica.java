package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Set;

public class PreguntaVoFClasica extends Pregunta {

    public PreguntaVoFClasica(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new OpcionesCorrectasClasicas(respuesta);
    }
}

