package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.HashMap;


public interface Respuesta {

    public final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();

    public Integer responder(String unaRespuesta);
}


public class RespuestaConPenalidad implements Respuesta {

    private final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();
//    private final CalculadorPuntajeConPenaldiad calculadorPuntaje;

    default Respuesta(Respuesta unasRespuestas){

        respuestas.put("V",unasRespuestas.get(0));
        respuestas.put("F",unasRespuestas.get(1));
    }

    default Integer responder(String unaRespuesta){

        return calculadorPuntaje.calcular(respuestas.get(unaRespuesta));
    }


}