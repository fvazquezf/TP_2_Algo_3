package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaConPenalidad implements Respuesta {
    private final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();

    public RespuestaConPenalidad(ArrayList<Boolean> unasRespuestas) {
        respuestas.put("V",unasRespuestas.get(0));
        respuestas.put("F",unasRespuestas.get(1));
    }

    public Integer responder(String unaRespuesta){
        return (CalculadorPuntajeConPenalidad.obtenerCalculadorConPenalidad().calcular(respuestas.get(unaRespuesta)));
    }
}
