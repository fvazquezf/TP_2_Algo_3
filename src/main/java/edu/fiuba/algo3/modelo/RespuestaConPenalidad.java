package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;

public class RespuestaConPenalidad implements Respuesta {

    private final HashMap<Integer, Boolean> respuestas = new HashMap<>();

    public RespuestaConPenalidad(List<Boolean> respuestas) {
        for (int i = 0; i < respuestas.size(); i++) {
            this.respuestas.put(i, respuestas.get(i));
        }
    }

    public Integer responder(HashMap<Integer, Boolean> respuestas) {
        return (CalculadorPuntajeConPenalidad.obtenerCalculadorConPenalidad().calcular(this.respuestas, respuestas));
    }
}
