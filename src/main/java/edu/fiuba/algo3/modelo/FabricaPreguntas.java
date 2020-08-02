package edu.fiuba.algo3.modelo;

import java.util.List;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String tipoPregunta, String pregunta, List<Boolean> respuesta) {
        switch (tipoPregunta) {
            case "preguntaVoFClasica":
                return (new PreguntaVoFClasica(pregunta, respuesta));
            case "preguntaVoFConPenalidad":
                return (new PreguntaVoFConPenalidad(pregunta, respuesta));
            case "preguntaMCClasica":
                return (new PreguntaMCClasica(pregunta, respuesta));
            case "preguntaMCConPuntajeParcial":
                return (new PreguntaMCConPuntajeParcial(pregunta, respuesta));
            case "preguntaMCConPenalidad":
                return (new PreguntaMCConPenalidad(pregunta, respuesta));
            default:
                throw new ExcepcionTipoPreguntaInvalida();
        }
    }
}
