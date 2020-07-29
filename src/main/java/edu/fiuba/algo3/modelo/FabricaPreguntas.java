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
        else if(unTipoPregunta == "preguntaMCClasica"){
            return (new PreguntaMCClasica(unaPregunta,unaRespuesta));
        }
        else if(unTipoPregunta == "preguntaMCConPenalidad"){
            return (new PreguntaMCConPenalidad(unaPregunta,unaRespuesta));
        }
        throw new ExcepcionTipoPreguntaInvalida();
    }
}
