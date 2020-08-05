package edu.fiuba.algo3.modelo.preguntas;

import java.util.Collection;
import java.util.Set;

public class PreguntaConPenalidad extends Pregunta {

    public PreguntaConPenalidad(String pregunta, Set<String> opcionesCorrectas) {
        textoPregunta = pregunta;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public Integer compararRespuestas(Collection<String> respuestasJugador) {
        int puntos = 0;
        for (String respuestaDelJugador : respuestasJugador) {
            if (opcionesCorrectas.contains(respuestaDelJugador))
                puntos++;
            else
                puntos--;
        }
        return puntos;
    }

    @Override
    public void usarMultiplicador() {
    }
}
