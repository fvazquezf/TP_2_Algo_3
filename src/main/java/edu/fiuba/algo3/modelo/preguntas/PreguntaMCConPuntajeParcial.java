package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPuntajeParcial;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;

import java.util.Collection;
import java.util.Set;

public class PreguntaMCConPuntajeParcial extends Pregunta {
    private ComportamientoConPuntajeParcial comportamiento = new ComportamientoConPuntajeParcial();

    public PreguntaMCConPuntajeParcial(String pregunta, String[] opcionesCorrectas, Set<String> todasLasOpciones) {
        super(pregunta, opcionesCorrectas, todasLasOpciones);
        if (todasLasOpciones.size() > 5 || todasLasOpciones.size() < 2)
            throw new ExcepcionPreguntaMCInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
