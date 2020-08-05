package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;

import java.util.Set;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, Set<String> respuesta) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
            case "preguntaMCClasica":
            case "preguntaGC":
            case "preguntaOC":
                return (new PreguntaClasica(pregunta, respuesta));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaConPuntajeParcial(pregunta, respuesta));
            case "preguntaMCConPenalidad":
            case "preguntaVoFConPenalidad":
                return (new PreguntaConPenalidad(pregunta, respuesta));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
