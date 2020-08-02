package edu.fiuba.algo3.modelo;

import java.util.Map;

public interface CalculadorPuntaje {
    Integer calcular(Map<Integer, Boolean> respuestasPregunta, Map<Integer, Boolean> respuestasJugador);
}
