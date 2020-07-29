package edu.fiuba.algo3.modelo;


import java.util.HashMap;

public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje{

    private static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad(){
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(HashMap unaRespuestaCorroborada, HashMap respuesDelJugador) {

        System.out.println(unaRespuestaCorroborada);
        System.out.println(respuesDelJugador);
        for (int i = 0; i < unaRespuestaCorroborada.size(); i++) {
            if (unaRespuestaCorroborada.get(i) != respuesDelJugador.get(i))
                return -1;
        }
        return 1;
    }

//    public Integer calcular(HashMap unaRespuestaCorroborada,  HashMap respuestaDelJugador){
//        if(unaRespuestaCorroborada)
//            return 1;
//        return -1;
//    }
}
