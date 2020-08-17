package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.comportamientos.ComportamientoClasico;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionPreguntaGCInvalida;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PreguntaGC extends Pregunta {
    private final ComportamientoClasico comportamiento = new ComportamientoClasico();
    Map<String, String> grupos = new HashMap<>();

    public PreguntaGC(String pregunta, Set<String> opcionesCorrectas, Set<String> todasLasOpciones, Map<String, String> grupos) {
        super(pregunta, opcionesCorrectas, todasLasOpciones);
        if (todasLasOpciones.size() < 2 || todasLasOpciones.size() > 6)
            throw new ExcepcionPreguntaGCInvalida();
        if (todasLasOpciones.contains(grupos.get("grupoAComparar")) || todasLasOpciones.contains(grupos.get("OtroGrupo")))
            throw new ExcepcionPreguntaGCInvalida();
        this.grupos = grupos;
        opcionesCorrectas.add(grupos.get("grupoAComparar"));
    }

    @Override
    public Integer compararRespuestas(Collection<String> opcionesJugador) {
        return comportamiento.compararRespuestas(opcionesJugador, opcionesCorrectas);
    }
}
