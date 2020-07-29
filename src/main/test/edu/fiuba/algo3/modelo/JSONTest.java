package edu.fiuba.algo3.modelo;
import org.json.*;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JSONTest {

    @Test
    public void Test01PruebaJSONLeoPreguntaYEntero() {

        String preguntas = "{ \"pregunta\": \"Es blanco el caballo blanco de San Martin?\", \"respuesta\": 1 }";
        JSONObject parser = new JSONObject(preguntas);
        String unaPregunta;

        unaPregunta = parser.getString("pregunta");
        int respuesta = parser.getInt("respuesta");

        assertEquals("Es blanco el caballo blanco de San Martin?", unaPregunta);
        assertEquals(1,respuesta);
    }

    @Test
    public void Test02PruebaJSONLeoPreguntaYArregloDeEnteros() {

        String preguntas = "{ \"pregunta\": \"Es blanco el caballo blanco de San Martin?\", \"respuestas\": [1, 0] }";
        JSONObject parser = new JSONObject(preguntas);
        List<Integer> respuestasLeidas = new ArrayList<>();
        List<Integer> respuestasEsperadas = new ArrayList<>();
        //String unaPregunta;
        respuestasEsperadas.add(1);
        respuestasEsperadas.add(0);

        //unaPregunta = parser.getString("pregunta");
        JSONArray respuestas = parser.getJSONArray("respuestas");

        for (int i = 0; i < respuestas.length(); i++) {
            respuestasLeidas.add(respuestas.getInt(i));
        }

        assertEquals(respuestasEsperadas,respuestasLeidas);
    }


   @Test
    public void Test03PruebaJSONLeoArchivoJsonYComparoPreguntaYRespuesta() {
       String JsonTexto = null;
       List<Boolean> respuestasLeidas = new ArrayList<>();
       String textoPregunta = "\0";
       List<Boolean> respuestasEsperadas = new ArrayList<>();
       respuestasEsperadas.add(true);
       respuestasEsperadas.add(false);
       boolean respuestaCorrecta = true;
       //boolean seLanzoError = false;

       try{
           JsonTexto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")));
       }
       catch (Exception e){
           e.printStackTrace();
           //seLanzoError = true;
       }

       if(JsonTexto != null) {
           JSONObject preguntas = new JSONObject(JsonTexto);

           JSONArray todasLasPreguntas = preguntas.getJSONArray("Preguntas");

           for (int i = 0; i < todasLasPreguntas.length(); i++) {
               JSONObject unaPregunta = todasLasPreguntas.getJSONObject(i);

               textoPregunta = unaPregunta.getString("Pregunta");
               JSONArray respuestasPosibles = unaPregunta.getJSONArray("PosiblesRespuestas");
               for (int j = 0; j < respuestasPosibles.length(); j++) {
                   respuestasLeidas.add(respuestasPosibles.getBoolean(j));
               }
               respuestaCorrecta = unaPregunta.getBoolean("RespuestaCorrecta");
           }
       }
       assertEquals(respuestasEsperadas,respuestasLeidas);
       assertTrue(respuestaCorrecta);
       //assertTrue(seLanzoError);
       assertEquals("Es blanco el caballo blanco de San Martin?",textoPregunta);
    }
}
