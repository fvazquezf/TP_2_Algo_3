package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaMCConPenalidad extends Pregunta{

    public PreguntaMCConPenalidad(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaConPenalidad(unaRespuesta);
    }
}
