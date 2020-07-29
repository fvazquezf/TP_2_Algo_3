package edu.fiuba.algo3.modelo;


import java.util.HashMap;

public class CalculadorPuntajeConPenalidad implements CalculadorPuntaje{

    private final static CalculadorPuntajeConPenalidad calculadorPuntajeConPenalidad = new CalculadorPuntajeConPenalidad();

    public static CalculadorPuntajeConPenalidad obtenerCalculadorConPenalidad(){
        return calculadorPuntajeConPenalidad;
    }

    public Integer calcular(HashMap<Integer,Boolean> respuestaPregunta, HashMap<Integer,Boolean> respuesDelJugador) {

        int contador = 0;
        for(int i = 0; i < respuestaPregunta.size(); i++) {
            if(respuestaPregunta.get(i) && respuesDelJugador.get(i))
                contador++;
            else if((! respuestaPregunta.get(i)) && respuesDelJugador.get(i))
                contador --;
        }
        return contador;
    }

}
