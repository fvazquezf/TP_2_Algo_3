package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivo {

    private Pregunta preguntas;

    public Pregunta leerArchivo(String archivo){

        String JsonTexto = null;
        List respuestasLeidas = new ArrayList();
        String textoPregunta = "\0";
        boolean respuestaCorrecta = true;

        try{
            JsonTexto = new String(Files.readAllBytes(Paths.get(archivo)));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JSONObject preguntasObj = new JSONObject(JsonTexto);

        JSONArray todasLasPreguntas = preguntasObj.getJSONArray("Preguntas");

        for(int i = 0; i < todasLasPreguntas.length(); i++){
            JSONObject unaPregunta =  todasLasPreguntas.getJSONObject(i);

            textoPregunta = unaPregunta.getString("Pregunta");
            JSONArray respuestasPosibles = unaPregunta.getJSONArray("PosiblesRespuestas");
            for(int j = 0; j < respuestasPosibles.length(); j++){
                respuestasLeidas.add(respuestasPosibles.getBoolean(j));
            }
            respuestaCorrecta = unaPregunta.getBoolean("RespuestaCorrecta");
            preguntas = new Pregunta(textoPregunta,respuestaCorrecta);

        }
        return preguntas;
    }
}
