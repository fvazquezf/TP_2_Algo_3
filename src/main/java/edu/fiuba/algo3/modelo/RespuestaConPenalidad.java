package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaConPenalidad implements Respuesta{

    private final HashMap<Integer,Boolean> respuestas = new HashMap<Integer, Boolean>();

    public RespuestaConPenalidad(ArrayList<Boolean> unasRespuestas) {
        for(int i = 0; i < unasRespuestas.size(); i++){
            respuestas.put(i,unasRespuestas.get(i));
        }
    }

    public Integer responder(HashMap unaRespuesta){
        return (CalculadorPuntajeConPenalidad.obtenerCalculadorConPenalidad().calcular(respuestas,unaRespuesta));
    }
}
