package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CalculadorPuntajeClasico implements CalculadorPuntaje{

    private static CalculadorPuntajeClasico calculadorPuntajeClasico = new CalculadorPuntajeClasico();

    public static CalculadorPuntajeClasico obtenerCalculadorClasico(){
        return calculadorPuntajeClasico;
    }

    public Integer calcular(HashMap unaRespuestaCorroborada, HashMap respuesDelJugador){

        if(unaRespuestaCorroborada.equals(respuesDelJugador))
            return 1;

        return 0;
    }
}
