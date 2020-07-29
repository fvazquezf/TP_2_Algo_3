package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public interface CalculadorPuntaje {
    Integer calcular(HashMap<Integer,Boolean> unaRespuestaCorroborada, HashMap<Integer,Boolean> respuestaDelJugador);
}
