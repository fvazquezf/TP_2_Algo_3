package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaConPuntajeParcial implements Respuesta {

    private final HashMap<Integer,Boolean> respuestas = new HashMap<>();

    public RespuestaConPuntajeParcial(ArrayList<Boolean> unasRespuestas) {
        for(int i = 0; i < unasRespuestas.size(); i++){
            respuestas.put(i,unasRespuestas.get(i));
        }
    }
    public Integer responder(HashMap<Integer, Boolean> unaRespuesta){
        return (CalculadorPuntajeParcial.obtenerCalculadorParcial().calcular(respuestas,unaRespuesta));
    }
}