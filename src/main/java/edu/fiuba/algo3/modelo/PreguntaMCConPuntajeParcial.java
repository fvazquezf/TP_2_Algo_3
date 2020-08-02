package edu.fiuba.algo3.modelo;

import java.util.List;

public class PreguntaMCConPuntajeParcial extends Pregunta {

    public PreguntaMCConPuntajeParcial(String pregunta, List<Boolean> respuesta) {
        textoPregunta = pregunta;
        this.respuesta = new RespuestaConPuntajeParcial(respuesta);
    }
}
