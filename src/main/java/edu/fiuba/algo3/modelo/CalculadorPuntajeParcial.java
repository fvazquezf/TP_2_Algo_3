package edu.fiuba.algo3.modelo;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CalculadorPuntajeParcial implements CalculadorPuntaje{

    private final static CalculadorPuntajeParcial calculadorPuntajeParcial = new CalculadorPuntajeParcial();

    public static CalculadorPuntajeParcial obtenerCalculadorParcial(){
        return calculadorPuntajeParcial;
    }

    public Integer calcular(Map<Integer,Boolean> respuestaPregunta, Map<Integer,Boolean> respuesDelJugador) {

        int contador = 0;
        for (Map.Entry<Integer, Boolean> respuesta : respuestaPregunta.entrySet()) {
            if (!respuesta.getValue() && respuesDelJugador.get(respuesta.getKey()))
                return 0;
            if (respuesta.getValue() && respuesDelJugador.get(respuesta.getKey()))
                contador++;
        }
        return contador;
    }

}
