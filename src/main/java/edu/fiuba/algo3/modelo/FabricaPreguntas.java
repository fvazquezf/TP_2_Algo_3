package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String unTipoPregunta,String unaPregunta, ArrayList<Boolean> unaRespuesta) {
        if(unTipoPregunta == "preguntaVoFClasica") {
            return (new PreguntaVoFClasica(unaPregunta, unaRespuesta));
        }
        else if(unTipoPregunta == "preguntaVoFConPenalidad") {
            return (new PreguntaVoFConPenalidad(unaPregunta, unaRespuesta));
        }
        throw new ExcepcionTipoPreguntaInvalida();
    }
}
