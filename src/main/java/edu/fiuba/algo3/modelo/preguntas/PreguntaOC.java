package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaOCInvalida;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Arrays;
import java.util.Collection;

public class PreguntaOC extends Pregunta {
    private ComportamientoClasico comportamiento = new ComportamientoClasico();
  
    public PreguntaOC(String tipoPregunta, String pregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        super(tipoPregunta, pregunta, Arrays.asList(opcionesCorrectas), todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 5)
            throw new ExcepcionTipoPreguntaInvalida();
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        int puntos = comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
        notificarObservador();
        return puntos;
    }
}
