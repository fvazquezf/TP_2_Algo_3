package edu.fiuba.algo3.modelo;

public class CalculadorPuntajeConPenaldiad {

    public Integer calcular(boolean unaRespuestaCorroborada){
        if(unaRespuestaCorroborada)
            return 1;
        return -1;
    }
}
