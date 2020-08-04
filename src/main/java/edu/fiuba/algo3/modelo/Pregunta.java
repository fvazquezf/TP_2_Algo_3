package edu.fiuba.algo3.modelo;

import java.util.Collection;

public abstract class Pregunta {
    protected Collection<String> opcionesCorrectas;
    protected String textoPregunta;

    public abstract Integer compararRespuestas(Collection<String> respuestasJugador);

    public Integer usarMultiplicador(Jugador jugador, int puntos) {
        throw new ExcepcionPreguntaNoEsDeTipoConPenalidad();
    }
}
