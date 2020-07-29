package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaMCClasica extends Pregunta{

    public PreguntaMCClasica(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaClasica(unaRespuesta);
    }
}