package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaClasica implements Respuesta{

    private final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();

    public RespuestaClasica(ArrayList<Boolean> unasRespuestas){
           respuestas.put("V",unasRespuestas.get(0));
           respuestas.put("F",unasRespuestas.get(1));
    }

    public Integer responder(String unaRespuesta){
       return (CalculadorPuntajeClasico.obtenerCalculadorClasico().calcular(respuestas.get(unaRespuesta)));
    }
}

