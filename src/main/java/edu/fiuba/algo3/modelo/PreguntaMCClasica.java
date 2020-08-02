package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaMCClasica extends Pregunta {

    public PreguntaMCClasica(String pregunta, List<Boolean> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new RespuestaClasica(respuesta);
    }
}