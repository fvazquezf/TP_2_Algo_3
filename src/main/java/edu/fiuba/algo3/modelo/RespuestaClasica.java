package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaClasica implements Respuesta{

//    private final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();
    private final HashMap<Integer,Boolean> respuestas = new HashMap<Integer, Boolean>();
    public RespuestaClasica(ArrayList<Boolean> unasRespuestas){
        for(int i = 0; i < unasRespuestas.size(); i++){
            respuestas.put(i,unasRespuestas.get(i));
        }

        //           respuestas.put(0,unasRespuestas.get(0));
//           respuestas.put(1,unasRespuestas.get(1));
    }

    public Integer responder(HashMap unaRespuesta){
       return (CalculadorPuntajeClasico.obtenerCalculadorClasico().calcular(respuestas,unaRespuesta));
    }
}

