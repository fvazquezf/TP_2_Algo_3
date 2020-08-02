package edu.fiuba.algo3.modelo;

import java.util.Map;

public class CalculadorPuntajeClasico implements CalculadorPuntaje {

    private final static CalculadorPuntajeClasico calculadorPuntajeClasico = new CalculadorPuntajeClasico();

    public static CalculadorPuntajeClasico obtenerCalculadorClasico() {
        return calculadorPuntajeClasico;
    }

    public Integer calcular(Map<Integer, Boolean> respuestasPregunta, Map<Integer, Boolean> respuestasJugador) {

        if (respuestasPregunta.equals(respuestasJugador))
            return 1;

        return 0;
    }
}
