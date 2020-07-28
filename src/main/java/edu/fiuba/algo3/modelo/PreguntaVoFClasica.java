package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFClasica extends Pregunta{


    public PreguntaVoFClasica(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaClasica(unaRespuesta);
    }
}

