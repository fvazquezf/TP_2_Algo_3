package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PreguntaVOFClasica extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();

    public PreguntaVOFClasica(String pregunta, Set<String> opcionesCorrectas) {
        super(pregunta, opcionesCorrectas);
        todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("V");
        todasLasOpciones.add("F");
        if (todasLasOpciones.size() != 2 || opcionesCorrectas.size() != 1)
            throw new ExcepcionPreguntaVOFInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
