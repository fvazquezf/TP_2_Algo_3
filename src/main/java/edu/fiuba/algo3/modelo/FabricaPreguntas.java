package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class FabricaPreguntas {

    public Pregunta crearPregunta(String unTipoPregunta,String unaPregunta, ArrayList<Boolean> unaRespuesta) {
        if(unTipoPregunta.equals("preguntaVoFClasica")) {
            return (new PreguntaVoFClasica(unaPregunta, unaRespuesta));
        }
        else if(unTipoPregunta.equals("preguntaVoFConPenalidad")) {
            return (new PreguntaVoFConPenalidad(unaPregunta, unaRespuesta));
        }
        else if(unTipoPregunta.equals("preguntaMCClasica")){
            return (new PreguntaMCClasica(unaPregunta,unaRespuesta));
        }
        else if(unTipoPregunta.equals("preguntaMCConPuntajeParcial")){
            return (new PreguntaMCConPuntajeParcial(unaPregunta,unaRespuesta));
        }
        else if(unTipoPregunta.equals("preguntaMCConPenalidad")){
            return (new PreguntaMCConPenalidad(unaPregunta,unaRespuesta));
        }
        throw new ExcepcionTipoPreguntaInvalida();
    }
}
