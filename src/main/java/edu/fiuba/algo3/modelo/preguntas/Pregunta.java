package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaNoEsDeTipoConPenalidad;

import java.util.Collection;

public abstract class Pregunta {
    protected Collection<String> opcionesCorrectas;
    protected String textoPregunta;

    public abstract Integer compararRespuestas(Collection<String> respuestasJugador);

    public void usarMultiplicador() {
        throw new ExcepcionPreguntaNoEsDeTipoConPenalidad();
    }
}
