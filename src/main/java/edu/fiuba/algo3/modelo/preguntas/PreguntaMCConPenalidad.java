package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPenalidad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;

import java.util.Collection;

public class PreguntaMCConPenalidad extends Pregunta {
    private final ComportamientoConPenalidad comportamiento = new ComportamientoConPenalidad();

    public PreguntaMCConPenalidad(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, opcionesCorrectas, todasLasOpciones);

        if (todasLasOpciones.size() > 5 || todasLasOpciones.size() < 2)
            throw new ExcepcionPreguntaMCInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        int puntos = comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
        notificarObservador();
        return puntos;
    }

    @Override
    public void activarMultiplicador() {

    }

    @Override
    public void activarExclusividad() {
        throw new ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad();
    }
}
