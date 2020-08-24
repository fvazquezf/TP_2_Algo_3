package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Collection;
import java.util.Map;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, String[] respuestasCorrectas, Collection<String> todasRespuestas, Map<String, String> grupos) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
                return (new PreguntaVOFClasica(tipoPregunta, pregunta, respuestasCorrectas));
            case "preguntaMCClasica":
                return (new PreguntaMCClasica(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaGC":
                return (new PreguntaGC(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas, grupos));
            case "preguntaOC":
                return (new PreguntaOC(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaMCConPuntajeParcial(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaMCConPenalidad":
                return (new PreguntaMCConPenalidad(tipoPregunta, pregunta, respuestasCorrectas, todasRespuestas));
            case "preguntaVoFConPenalidad":
                return (new PreguntaVoFConPenalidad(tipoPregunta, pregunta, respuestasCorrectas));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
