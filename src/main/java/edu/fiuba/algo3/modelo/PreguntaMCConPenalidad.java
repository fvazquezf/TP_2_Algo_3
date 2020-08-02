package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaMCConPenalidad extends Pregunta {

    public PreguntaMCConPenalidad(String pregunta, List<Boolean> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new RespuestaConPenalidad(respuesta);
    }
}
