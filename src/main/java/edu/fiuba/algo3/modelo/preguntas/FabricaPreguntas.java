package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestasCorrectas, Collection<String> todasRespuestas, String[] grupos) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
                return (new PreguntaVOFClasica(pregunta, (Set<String>) respuestasCorrectas));
            case "preguntaMCClasica":
                return (new PreguntaMCClasica(pregunta, (Set<String>) respuestasCorrectas, (Set<String>) todasRespuestas));
            case "preguntaGC":
                return (new PreguntaGC(pregunta, (Set<String>) respuestasCorrectas, (Set<String>) todasRespuestas, grupos));
            case "preguntaOC":
                return (new PreguntaOC(pregunta, (LinkedList<String>) respuestasCorrectas, (LinkedList<String>) todasRespuestas));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaMCConPuntajeParcial(pregunta, (Set<String>) respuestasCorrectas, (Set<String>) todasRespuestas));
            case "preguntaMCConPenalidad":
                return (new PreguntaMCConPenalidad(pregunta, (Set<String>) respuestasCorrectas, (Set<String>) todasRespuestas));
            case "preguntaVoFConPenalidad":
                return (new PreguntaVoFConPenalidad(pregunta, (Set<String>) respuestasCorrectas));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
