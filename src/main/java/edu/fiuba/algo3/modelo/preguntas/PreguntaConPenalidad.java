package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;

import java.util.Collection;

public class PreguntaConPenalidad extends Pregunta {

    public PreguntaConPenalidad(String pregunta, Collection<String> opcionesCorrectas) {
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
    public void activarMultiplicador() {
    }

    public void activarExclusividad() {
        throw new ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad();
    }
}
