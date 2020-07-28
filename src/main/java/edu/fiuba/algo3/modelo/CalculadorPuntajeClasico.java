package edu.fiuba.algo3.modelo;

public class CalculadorPuntajeClasico implements CalculadorPuntaje{
    private static CalculadorPuntajeClasico calculadorPuntajeClasico = new CalculadorPuntajeClasico();

    public static CalculadorPuntajeClasico obtenerCalculadorClasico(){
        return calculadorPuntajeClasico;
    }

    public Integer calcular(boolean unaRespuestaCorroborada){
        if(unaRespuestaCorroborada)
            return 1;
        return 0;
    }
}
