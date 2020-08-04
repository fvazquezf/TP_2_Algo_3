package edu.fiuba.algo3.modelo.preguntas;

import java.util.Collection;
import java.util.Set;

public class PreguntaConPuntajeParcial extends Pregunta {

    public PreguntaConPuntajeParcial(String pregunta, Set<String> opcionesCorrectas) {
        textoPregunta = pregunta;
        this.opcionesCorrectas = opcionesCorrectas;
    }

    public Integer compararRespuestas(Collection<String> respuestasJugador) {
        int puntos = 0;
        for (String respuestaDelJugador : respuestasJugador) {
            if (opcionesCorrectas.contains(respuestaDelJugador))
                puntos++;
            else {
                return 0;
            }
        }
        return puntos;
    }
}
