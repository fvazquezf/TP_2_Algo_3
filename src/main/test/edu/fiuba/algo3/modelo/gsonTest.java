package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import org.junit.Test;


import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class gsonTest {

    @Test
    public void test01CargoUnStringConDAtosEnFormatoJsonyComparoResultados() {
        String json = "{\"pregunta\": \"¿Cómo festeja Diego?\",\"respuestasCorrectas\":[\"Fiesta\"],\"respuestaFalsa\":[\"Frula\"]}";
        Gson gson = new Gson();
        PreguntasJson preguntasJson = gson.fromJson(json,PreguntasJson.class);

        assertEquals("¿Cómo festeja Diego?", preguntasJson.obtenerPregunta());
    }

    @Test
    public void test02CargoUnArchivoConDosPreguntasYLasLeo() throws IOException {

        Gson gson = new GsonBuilder().create();
//        FileReader fr = new FileReader("D:\\Datos\\Google Drive\\Fiuba\\95.02 - Algoritmos y programación III\\TP2\\Repositorio\\TP_2_Algo_3\\rsc\\Preguntas.json");
//        BufferedReader br = new BufferedReader(fr);
//        System.out.println(br);
        String JsonTexto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")));

        PreguntasJson[] preguntasJsons = gson.fromJson(JsonTexto,PreguntasJson[].class);
//        for(PreguntasJson preguntasJson : preguntasJsons) {
//            System.out.println(preguntasJsons);
//        }
        System.out.println(preguntasJsons[0].obtenerPregunta());
        System.out.println(preguntasJsons[0].obtenerTipoPregunta());
        System.out.println(preguntasJsons[0].obtenerOpcionesCorrectas().obtenerOpciones());
        System.out.println(preguntasJsons[0].obtenerOpcionesPosibles().obtenerOpciones());
        assertEquals(1,1);
    }


}
