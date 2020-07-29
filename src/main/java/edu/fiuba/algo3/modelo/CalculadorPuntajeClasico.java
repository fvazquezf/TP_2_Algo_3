package edu.fiuba.algo3.modelo;

import java.util.HashMap;

public class CalculadorPuntajeClasico implements CalculadorPuntaje{

    private static CalculadorPuntajeClasico calculadorPuntajeClasico = new CalculadorPuntajeClasico();

    public static CalculadorPuntajeClasico obtenerCalculadorClasico(){
        return calculadorPuntajeClasico;
    }

    public Integer calcular(HashMap unaRespuestaCorroborada, HashMap respuesDelJugador){

        for(int i = 0; i < unaRespuestaCorroborada.size(); i++){
            if(unaRespuestaCorroborada.get(i) != respuesDelJugador.get(i))
                return 0;
        }
        return 1;

        //        if(unaRespuestaCorroborada == RespuesDelJugador)
//            return 1;
//        return 0;
    }
}
