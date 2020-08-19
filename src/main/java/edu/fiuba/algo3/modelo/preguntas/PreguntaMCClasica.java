package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;

import java.util.Collection;
import java.util.Set;

public class PreguntaMCClasica extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();

    public PreguntaMCClasica(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Set<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, opcionesCorrectas, todasLasOpciones);

        if (todasLasOpciones.size() > 5 || todasLasOpciones.size() < 2)
            throw new ExcepcionPreguntaMCInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
