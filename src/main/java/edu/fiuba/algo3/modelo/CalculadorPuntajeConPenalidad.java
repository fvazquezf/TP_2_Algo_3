package edu.fiuba.algo3.modelo;


import java.util.Map;

public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje {

    private final static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad() {
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(Map<Integer, Boolean> respuestasPregunta, Map<Integer, Boolean> respuestasJugador) {

        int puntos = 0;
        for (Map.Entry<Integer, Boolean> respuesta : respuestasPregunta.entrySet()) {
            if (!respuesta.getValue() && respuestasJugador.get(respuesta.getKey()))
                puntos--;
            if (respuesta.getValue() && respuestasJugador.get(respuesta.getKey()))
                puntos++;
        }
        return puntos;
    }

}
