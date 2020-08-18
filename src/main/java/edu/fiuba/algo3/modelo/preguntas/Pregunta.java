package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;

import java.util.*;

public abstract class Pregunta {
    protected Collection<String> opcionesCorrectas;
    protected Collection<String> todasLasOpciones;
    protected String textoPregunta;

    public Pregunta(String textoPregunta, String[] opcionesCorrectas) {
        this.opcionesCorrectas = new HashSet<>();
        Collections.addAll(this.opcionesCorrectas, opcionesCorrectas);
        this.textoPregunta = textoPregunta;
    }

    public Pregunta(String textoPregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        this.opcionesCorrectas = new HashSet<>();
        Collections.addAll(this.opcionesCorrectas, opcionesCorrectas);
        this.textoPregunta = textoPregunta;
        this.todasLasOpciones = todasLasOpciones;
    }
    public Pregunta(String textoPregunta, List opcionesCorrectas, Collection<String> todasLasOpciones) {
        this.opcionesCorrectas = new LinkedList<>(opcionesCorrectas);
        this.textoPregunta = textoPregunta;
        this.todasLasOpciones = todasLasOpciones;
    }


    public String obtenerPregunta() {
        return textoPregunta;
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return todasLasOpciones;
    }

    public abstract Integer compararRespuestas(Collection<String> respuestasJugador);

    public void activarMultiplicador() {
        throw new ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador();
    }

    public void activarExclusividad() {
    }
}
