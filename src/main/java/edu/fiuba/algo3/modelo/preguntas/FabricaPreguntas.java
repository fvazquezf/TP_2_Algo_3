package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Collection;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, Collection<String> respuestasCorrectas, Collection<String> todasRespuesta) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
            case "preguntaMCClasica":
            case "preguntaGC":
            case "preguntaOC":
                return (new PreguntaClasica(pregunta, respuestasCorrectas, todasRespuesta));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaConPuntajeParcial(pregunta, respuestasCorrectas, todasRespuesta));
            case "preguntaMCConPenalidad":
            case "preguntaVoFConPenalidad":
                return (new PreguntaConPenalidad(pregunta, respuestasCorrectas, todasRespuesta));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
