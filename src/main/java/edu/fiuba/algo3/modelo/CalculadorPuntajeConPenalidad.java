package edu.fiuba.algo3.modelo;


import java.util.HashMap;
import java.util.Map;

public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje{

    private final static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad(){
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(Map<Integer,Boolean> respuestaPregunta, Map<Integer,Boolean> respuesDelJugador) {

        int contador = 0;
        for (Map.Entry<Integer, Boolean> respuesta : respuestaPregunta.entrySet()) {
            if (!respuesta.getValue() && respuesDelJugador.get(respuesta.getKey()))
                contador --;
            if (respuesta.getValue() && respuesDelJugador.get(respuesta.getKey()))
                contador++;
        }
        return contador;
    }

}
