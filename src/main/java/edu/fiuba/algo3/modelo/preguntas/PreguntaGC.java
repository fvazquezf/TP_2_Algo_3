package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaGCInvalida;

import java.util.Collection;
import java.util.Set;

public class PreguntaGC extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();
    String[] grupos;

    public PreguntaGC(String pregunta, Set<String> opcionesCorrectas, Set<String> todasLasOpciones, String[] grupos) {
        super(pregunta, opcionesCorrectas, todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 6)
            throw new ExcepcionPreguntaGCInvalida();
        if (todasLasOpciones.contains(grupos[0]) || todasLasOpciones.contains(grupos[1]))
            throw new ExcepcionPreguntaGCInvalida();
        this.grupos = grupos;
        opcionesCorrectas.add(grupos[0]);
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
