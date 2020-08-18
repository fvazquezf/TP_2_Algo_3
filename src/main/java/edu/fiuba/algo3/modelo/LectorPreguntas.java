package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import edu.fiuba.algo3.Preguntas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LectorPreguntas {

    public Preguntas[] leerPreguntas (){
        Gson gson = new Gson();
        String preguntas = null;

        try {
            preguntas = new String(Files.readAllBytes(Paths.get("rsc/Preguntas.json")), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(preguntas, Preguntas[].class);
    }
}
