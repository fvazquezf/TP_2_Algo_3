package edu.fiuba.algo3.modelo;


public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje{

    private static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad(){
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(boolean unaRespuestaCorroborada){
        if(unaRespuestaCorroborada)
            return 1;
        return -1;
    }
}
