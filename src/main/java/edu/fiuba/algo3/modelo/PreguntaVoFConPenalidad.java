package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFConPenalidad extends Pregunta{

    public PreguntaVoFConPenalidad(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaConPenalidad(unaRespuesta);
    }

}
