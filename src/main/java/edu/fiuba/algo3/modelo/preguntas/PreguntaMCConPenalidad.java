package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPenalidad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;

import java.util.Collection;

public class PreguntaMCConPenalidad extends Pregunta {
    private ComportamientoConPenalidad comportamiento = new ComportamientoConPenalidad();

    public PreguntaMCConPenalidad(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, opcionesCorrectas, todasLasOpciones);

        if (todasLasOpciones.size() > 5 || todasLasOpciones.size() < 2)
            throw new ExcepcionPreguntaMCInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }

    @Override
    public void activarMultiplicador() {

    }

    @Override
    public void activarExclusividad() {
        throw new ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad();
    }
}
