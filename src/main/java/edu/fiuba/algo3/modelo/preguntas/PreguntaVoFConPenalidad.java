package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPenalidad;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaVOFInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntasClasicasYPuntajeParcialPuedeUsarExclusividad;

import java.util.Collection;
import java.util.HashSet;

public class PreguntaVoFConPenalidad extends Pregunta {
    private final ComportamientoConPenalidad comportamiento = new ComportamientoConPenalidad();

    public PreguntaVoFConPenalidad(String tipoPregunta, String pregunta, String[] opcionesCorrectas) {
        super(tipoPregunta, pregunta, opcionesCorrectas);
        todasLasOpciones = new HashSet<>();
        todasLasOpciones.add("V");
        todasLasOpciones.add("F");
        if (this.opcionesCorrectas.size() != 1)
            throw new ExcepcionPreguntaVOFInvalida();
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
