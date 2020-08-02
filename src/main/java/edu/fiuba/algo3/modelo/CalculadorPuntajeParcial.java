package edu.fiuba.algo3.modelo;


import java.util.Map;

public class CalculadorPuntajeParcial implements CalculadorPuntaje {

    private final static CalculadorPuntajeParcial calculadorPuntajeParcial = new CalculadorPuntajeParcial();

    public static CalculadorPuntajeParcial obtenerCalculadorParcial() {
        return calculadorPuntajeParcial;
    }

    public Integer calcular(Map<Integer, Boolean> respuestasPregunta, Map<Integer, Boolean> respuestasJugador) {

        int puntos = 0;
        for (Map.Entry<Integer, Boolean> respuesta : respuestasPregunta.entrySet()) {
            if (!respuesta.getValue() && respuestasJugador.get(respuesta.getKey()))
                return 0;
            if (respuesta.getValue() && respuestasJugador.get(respuesta.getKey()))
                puntos++;
        }
        return puntos;
    }

}
