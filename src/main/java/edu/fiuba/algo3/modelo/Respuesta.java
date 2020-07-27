package edu.fiuba.algo3.modelo;
import java.util.ArrayList;
import java.util.HashMap;

public class Respuesta {

    private final HashMap<String,Boolean> respuestas = new HashMap<String, Boolean>();

    public Respuesta(ArrayList<Boolean> unasRespuestas){

        respuestas.put("V",unasRespuestas.get(0));
        respuestas.put("F",unasRespuestas.get(1));
    }

    public ArrayList<Boolean> pedirRespuestas() {

        return new ArrayList<Boolean>(respuestas.values());
    }

    public boolean responder(String unaRespuesta){

        return respuestas.get(unaRespuesta);
    }
}
