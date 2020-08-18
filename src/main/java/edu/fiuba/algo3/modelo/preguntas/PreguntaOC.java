package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaOCInvalida;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class PreguntaOC extends Pregunta {
    private ComportamientoClasico comportamiento = new ComportamientoClasico();

    public PreguntaOC(String tipoPregunta, String pregunta, String[] opcionesCorrectas, List<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, Arrays.asList(opcionesCorrectas), todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 5)
            throw new ExcepcionPreguntaOCInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
