package edu.fiuba.algo3.modelo;

import com.google.gson.*;
import org.junit.Test;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.Buffer;

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
    public void test02CargoUnArchivoConDosPreguntasYLasLeo() throws FileNotFoundException {

        Gson gson = new GsonBuilder().create();
        FileReader fr = new FileReader("D:\\Datos\\Google Drive\\Fiuba\\95.02 - Algoritmos y programación III\\TP2\\Repositorio\\TP_2_Algo_3\\rsc\\Preguntas.json");
        BufferedReader br = new BufferedReader(fr);
        System.out.println(br);
        assertEquals(1,1);
    }
}
