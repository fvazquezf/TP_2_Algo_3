package edu.fiuba.algo3.modelo;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.fiuba.algo3.Preguntas;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class gsonTest {

    @Test
    public void test01CargoUnStringConDAtosEnFormatoJsonyComparoResultados() {
        String json = "{\"pregunta\": \"¿Cómo festeja Diego?\",\"opcionesPosibles\":[\"Fiesta\", \"Frula\"],\"opcionesCorrectas\":[\"Fiesta\"]}";
        Gson gson = new Gson();
        Preguntas preguntasJson = gson.fromJson(json, Preguntas.class);

        assertEquals("¿Cómo festeja Diego?", preguntasJson.obtenerPregunta());
    }

    @Test
    public void test02CargoUnArchivoConPreguntasLeoAlgunosCampos() throws IOException {

        Gson gson = new GsonBuilder().create();
        String JsonTexto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")), "UTF-8");


        Preguntas[] preguntasJsons = gson.fromJson(JsonTexto, Preguntas[].class);

        assertEquals("¿Es blanco el caballo blanco de San Martin?", preguntasJsons[0].obtenerPregunta());
        assertEquals("¿Qué es PDD?", preguntasJsons[1].obtenerPregunta());
        assertEquals("Pares", preguntasJsons[3].obtenerGrupos().get("grupoAComparar"));
        assertEquals("Impares", preguntasJsons[3].obtenerGrupos().get("otroGrupo"));
    }

    @Test
    public void test03CargoUnArchivoConPreguntasCorroboroLosGruposCargadosAlRevées() throws IOException {

        Gson gson = new Gson();
        String texto = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")), "UTF-8");

        Preguntas[] preguntasJsons = gson.fromJson(texto, Preguntas[].class);

        assertEquals("Fuego", preguntasJsons[4].obtenerGrupos().get("grupoAComparar"));
        assertEquals("Electricidad", preguntasJsons[4].obtenerGrupos().get("otroGrupo"));
    }


}
