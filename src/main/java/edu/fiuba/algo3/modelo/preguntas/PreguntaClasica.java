package edu.fiuba.algo3.modelo.preguntas;

import java.util.Collection;

public class PreguntaClasica extends Pregunta {

    public PreguntaClasica(String pregunta, Collection<String> opcionesCorrectas) {
        textoPregunta = pregunta;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public Integer compararRespuestas(Collection<String> respuestasJugador) {
        if (opcionesCorrectas.equals(respuestasJugador))
            return 1;
        else
            return 0;
    }
}
