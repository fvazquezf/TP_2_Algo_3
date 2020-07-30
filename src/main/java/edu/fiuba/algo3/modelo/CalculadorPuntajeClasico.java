package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.Map;

public class CalculadorPuntajeClasico implements CalculadorPuntaje{

    private final static CalculadorPuntajeClasico calculadorPuntajeClasico = new CalculadorPuntajeClasico();

    public static CalculadorPuntajeClasico obtenerCalculadorClasico(){
        return calculadorPuntajeClasico;
    }

    public Integer calcular(Map<Integer,Boolean> unaRespuestaCorroborada, Map<Integer,Boolean> respuesDelJugador){

        if(unaRespuestaCorroborada.equals(respuesDelJugador))
            return 1;

        return 0;
    }
}
