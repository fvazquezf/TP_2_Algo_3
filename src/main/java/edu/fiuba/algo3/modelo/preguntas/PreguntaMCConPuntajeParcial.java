package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoConPuntajeParcial;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaMCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Collection;

public class PreguntaMCConPuntajeParcial extends Pregunta {
    private ComportamientoConPuntajeParcial comportamiento = new ComportamientoConPuntajeParcial();

    public PreguntaMCConPuntajeParcial(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
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
}
