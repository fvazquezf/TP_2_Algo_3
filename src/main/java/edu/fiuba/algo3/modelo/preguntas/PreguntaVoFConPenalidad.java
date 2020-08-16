package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPenalidad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PreguntaVoFConPenalidad extends Pregunta {
    private ComportamientoConPenalidad comportamiento = new ComportamientoConPenalidad();

    public PreguntaVoFConPenalidad(String pregunta, Set<String> opcionesCorrectas) {
        super(pregunta, opcionesCorrectas);
        todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("V");
        todasLasOpciones.add("F");
        if (opcionesCorrectas.size() != 1)
            throw new ExcepcionPreguntaVOFInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }

    @Override
    public void activarExclusividad() {
        throw new ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad();
    }
}
