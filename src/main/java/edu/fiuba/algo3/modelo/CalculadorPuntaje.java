package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public interface CalculadorPuntaje {
    Integer calcular(Map<Integer,Boolean> unaRespuestaCorroborada, Map<Integer,Boolean> respuestaDelJugador);
}
