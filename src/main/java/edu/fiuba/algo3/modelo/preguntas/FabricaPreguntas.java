package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, String[] respuestasCorrectas, Collection<String> todasRespuestas, Map<String, String> grupos) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
                return (new PreguntaVOFClasica(pregunta, respuestasCorrectas));
            case "preguntaMCClasica":
                return (new PreguntaMCClasica(pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaGC":
                return (new PreguntaGC(pregunta, respuestasCorrectas,  todasRespuestas, grupos));
            case "preguntaOC":
                return (new PreguntaOC(pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaMCConPuntajeParcial(pregunta, respuestasCorrectas,  todasRespuestas));
            case "preguntaMCConPenalidad":
                return (new PreguntaMCConPenalidad(pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaVoFConPenalidad":
                return (new PreguntaVoFConPenalidad(pregunta, respuestasCorrectas));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
