package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaVoFConPenalidad extends Pregunta {

    public PreguntaVoFConPenalidad(String pregunta, List<Boolean> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new RespuestaConPenalidad(respuesta);
    }

}
