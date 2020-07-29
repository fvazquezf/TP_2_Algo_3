package edu.fiuba.algo3.modelo;


import java.util.Collections;
import java.util.HashMap;

public class CalculadorPuntajeParcial implements CalculadorPuntaje{

    private final static CalculadorPuntajeParcial calculadorPuntajeParcial = new CalculadorPuntajeParcial();

    public static CalculadorPuntajeParcial obtenerCalculadorParcial(){
        return calculadorPuntajeParcial;
    }

    public Integer calcular(HashMap<Integer,Boolean> respuestaPregunta, HashMap<Integer,Boolean> respuesDelJugador) {

        if(respuestaPregunta.equals(respuesDelJugador))
            return Collections.frequency(respuestaPregunta.values(),true);
        else
            return 0;
    }

}
