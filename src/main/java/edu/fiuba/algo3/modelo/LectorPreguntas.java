package edu.fiuba.algo3.modelo;

import com.google.gson.Gson;
import edu.fiuba.algo3.Preguntas;
import edu.fiuba.algo3.modelo.preguntas.FabricaPreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LectorPreguntas {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    static final String caminoArchivoJSON =  "rsc/Preguntas.json";

    public List<Pregunta> parsearPreguntas() {
        List<Pregunta> todasLasPreguntas = new ArrayList<>();
        Gson gson = new Gson();
        String preguntasTexto = null;

        try {
            preguntasTexto = Files.readString(Paths.get(caminoArchivoJSON));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Preguntas[] preguntas = gson.fromJson(preguntasTexto, Preguntas[].class);

        Arrays.stream(preguntas).forEach(pregunta -> todasLasPreguntas.add(fabricaPreguntas.crearPregunta(pregunta.obtenerTipoPregunta(), pregunta.obtenerPregunta(), pregunta.obtenerOpcionesCorrectas(), pregunta.obtenerOpcionesPosbiles(), pregunta.obtenerGrupos())));

        return todasLasPreguntas;
    }
}
