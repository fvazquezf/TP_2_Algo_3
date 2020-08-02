package edu.fiuba.algo3.modelo;

import java.util.Set;

public class PreguntaVoFClasica extends Pregunta {

    public PreguntaVoFClasica(String pregunta, Set<String> respuesta) {
        textoPregunta = pregunta;
        this.opcionesCorrectas = new OpcionesCorrectasClasicas(respuesta);
    }
}

