package edu.fiuba.algo3.modelo;


import java.util.HashMap;

public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje{

    private static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad(){
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(HashMap unaRespuestaCorroborada, HashMap respuesDelJugador) {

        if (unaRespuestaCorroborada.equals(respuesDelJugador))
            return 1;

        return -1;
    }

}
