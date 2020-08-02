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
        String pregunta;

        pregunta = parser.getString("pregunta");
        int respuesta = parser.getInt("respuesta");

        assertEquals("Es blanco el caballo blanco de San Martin?", pregunta);
        assertEquals(1, respuesta);
    }

    @Test
    public void Test02PruebaJSONLeoPreguntaYArregloDeEnteros() {

        String preguntas = "{ \"pregunta\": \"Es blanco el caballo blanco de San Martin?\", \"respuestas\": [1, 0] }";
        JSONObject parser = new JSONObject(preguntas);
        List<Integer> respuestasLeidas = new ArrayList<>();
        List<Integer> respuestasEsperadas = new ArrayList<>();
        respuestasEsperadas.add(1);
        respuestasEsperadas.add(0);

        JSONArray respuestas = parser.getJSONArray("respuestas");

        for (int i = 0; i < respuestas.length(); i++) {
            respuestasLeidas.add(respuestas.getInt(i));
        }

        assertEquals(respuestasEsperadas, respuestasLeidas);
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

        try {
            JsonTexto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (JsonTexto != null) {
            JSONObject preguntas = new JSONObject(JsonTexto);

            JSONArray todasLasPreguntas = preguntas.getJSONArray("Preguntas");

            for (int i = 0; i < todasLasPreguntas.length(); i++) {
                JSONObject pregunta = todasLasPreguntas.getJSONObject(i);

                textoPregunta = pregunta.getString("Pregunta");
                JSONArray respuestasPosibles = pregunta.getJSONArray("PosiblesRespuestas");
                for (int j = 0; j < respuestasPosibles.length(); j++) {
                    respuestasLeidas.add(respuestasPosibles.getBoolean(j));
                }
                respuestaCorrecta = pregunta.getBoolean("RespuestaCorrecta");
            }
        }
        assertEquals(respuestasEsperadas, respuestasLeidas);
        assertTrue(respuestaCorrecta);
        assertEquals("Es blanco el caballo blanco de San Martin?", textoPregunta);
    }
}
