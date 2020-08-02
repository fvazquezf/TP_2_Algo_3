package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class RespuestaClasica implements Respuesta {

    private final HashMap<Integer, Boolean> respuestas = new HashMap<>();

    public RespuestaClasica(List<Boolean> respuestas) {
        for (int i = 0; i < respuestas.size(); i++)
            this.respuestas.put(i, respuestas.get(i));
    }

    public Integer responder(HashMap<Integer, Boolean> respuestas) {
        return (CalculadorPuntajeClasico.obtenerCalculadorClasico().calcular(this.respuestas, respuestas));
    }
}

