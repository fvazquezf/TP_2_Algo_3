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
        String json = "{\"pregunta\": \"¿Cómo festeja Diego?\",\"opcionesPosibles\":[\"Fiesta\", \"Frula\"],\"opcionesCorrectas\":[\"Fiesta\"]}";
        Gson gson = new Gson();
        PreguntasJson preguntasJson = gson.fromJson(json,PreguntasJson.class);

        assertEquals("¿Cómo festeja Diego?", preguntasJson.obtenerPregunta());
    }

    @Test
    public void test02CargoUnArchivoConDosPreguntasYLasLeo() throws IOException {

        Gson gson = new GsonBuilder().create();
        String JsonTexto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")));

        PreguntasJson[] preguntasJsons = gson.fromJson(JsonTexto, PreguntasJson[].class);
        assertEquals("¿Es blanco el caballo blanco de San Martin?",preguntasJsons[0].obtenerPregunta());
        assertEquals("¿Qué es PDD?",preguntasJsons[1].obtenerPregunta());
        assertEquals("Verdadero",preguntasJsons[0].obtenerOpcionesPosibles()[0]);
        assertEquals("Metodo de desarrollo",preguntasJsons[1].obtenerOpcionesCorrectas()[1]);
    }


}
