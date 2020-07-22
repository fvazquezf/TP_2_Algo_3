package edu.fiuba.algo3.modelo;
import org.json.*;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {

    @Test
    public void Test01PruebaJSONLeoPreguntaYEntero() {

        String preguntas = "{ \"pregunta\": \"¿Es blanco el caballo blanco de San Martin?\", \"respuesta\": 1 }";
        JSONObject parser = new JSONObject(preguntas);
        List listaRespuestas = new ArrayList();
        String unaPregunta;

        unaPregunta = parser.getString("pregunta");
        int respuesta = parser.getInt("respuesta");

        assertEquals("¿Es blanco el caballo blanco de San Martin?", unaPregunta);
        assertEquals(1,respuesta);
    }

    @Test
    public void Test02PruebaJSONLeoPreguntaYArregloDeEnteros() {

        String preguntas = "{ \"pregunta\": \"¿Es blanco el caballo blanco de San Martin?\", \"respuestas\": [1, 0] }";
        JSONObject parser = new JSONObject(preguntas);
        List respuestasLeidas = new ArrayList();
        List respuestasEsperadas = new ArrayList();
        String unaPregunta;
        respuestasEsperadas.add(1);
        respuestasEsperadas.add(0);

        unaPregunta = parser.getString("pregunta");
        JSONArray respuestas = parser.getJSONArray("respuestas");

        for (int i = 0; i < respuestas.length(); i++) {
            respuestasLeidas.add(respuestas.getInt(i));
        }

        assertEquals(respuestasEsperadas,respuestasLeidas);
    }


   @Test
    public void Test03PruebaJSONLeoArchivoJsonYComparoPreguntaYRespuesta() {

       String linea;
       String JsonTexto = null;
       //File archivoJson;// = new File("Preguntas.json");
       FileReader fr;// = new FileReader(archivoJson);
       BufferedReader br;// = new BufferedReader(fr);
       List respuestasLeidas = new ArrayList();
       String textoPregunta = "\0";
       List respuestasEsperadas = new ArrayList();
       respuestasEsperadas.add(1);
       respuestasEsperadas.add(0);
       int respuestaCorrecta = 0;

       try{
           /* archivoJson = new File("D:\\Datos\\Google Drive\\Fiuba\\95.02 - Algoritmos y programación III\\TP2\\Repositorio\\TP_2_Algo_3\\src\\main\\test\\edu\\fiuba\\algo3\\modelo\\Preguntas.json");
            fr = new FileReader(archivoJson);
            br = new BufferedReader(fr);

            while((linea = br.readLine()) != null)
                JsonTexto += linea;*/

           //JsonTexto = new String(Files.readAllBytes(Paths.get("D:\\Datos\\Google Drive\\Fiuba\\95.02 - Algoritmos y programación III\\TP2\\Repositorio\\TP_2_Algo_3\\src\\main\\test\\edu\\fiuba\\algo3\\modelo\\Preguntas.json")));
           JsonTexto = new String(Files.readAllBytes(Paths.get("Preguntas.json")));
       }
       catch (Exception e){
           e.printStackTrace();
       }

       JSONObject preguntas = new JSONObject(JsonTexto);

       JSONArray todasLasPreguntas = preguntas.getJSONArray("Preguntas");

       for(int i = 0; i < todasLasPreguntas.length(); i++){
           JSONObject unaPregunta =  todasLasPreguntas.getJSONObject(i);

           textoPregunta = unaPregunta.getString("Pregunta");
           JSONArray respuestasPosibles = unaPregunta.getJSONArray("PosiblesRespuestas");
           for(int j = 0; j < respuestasPosibles.length(); j++){
               respuestasLeidas.add(respuestasPosibles.getInt(j));
           }
           respuestaCorrecta = unaPregunta.getInt("RespuestaCorrecta");

       }
       assertEquals(respuestasEsperadas,respuestasLeidas);
       assertEquals(respuestaCorrecta,1);
       assertEquals("¿Es blanco el caballo blanco de San Martin?",textoPregunta);
    }
}
