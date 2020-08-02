package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVoFClasica extends Pregunta {

    public PreguntaVoFClasica(String pregunta, List<Boolean> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new RespuestaClasica(respuesta);
    }
}

