package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionTipoPreguntaInvalida;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaClasica;
import edu.fiuba.algo3.modelo.preguntas.PreguntaConPenalidad;
import edu.fiuba.algo3.modelo.preguntas.PreguntaConPuntajeParcial;

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
