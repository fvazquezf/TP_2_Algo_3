package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Pregunta {
    protected Collection<String> opcionesCorrectas;
    protected Collection<String> todasLasOpciones;
    protected String textoPregunta;
    private List<Observador> observadores = new ArrayList<>();

    public abstract Integer compararRespuestas(Collection<String> respuestasJugador);

    public void activarMultiplicador() {
        throw new ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador();
    }

    public void activarExclusividad() {
    }

    public String obtenerPregunta() {
        return textoPregunta;
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return todasLasOpciones;
    }
}
