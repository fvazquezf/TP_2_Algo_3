package edu.fiuba.algo3.modelo;


import java.util.Collections;
import java.util.HashMap;

public class CalculadorPuntajeParcial implements CalculadorPuntaje{

    private final static CalculadorPuntajeParcial calculadorPuntajeParcial = new CalculadorPuntajeParcial();

    public static CalculadorPuntajeParcial obtenerCalculadorParcial(){
        return calculadorPuntajeParcial;
    }

    public Integer calcular(HashMap<Integer,Boolean> respuestaPregunta, HashMap<Integer,Boolean> respuesDelJugador) {

        int contador = 0;
        for(int i = 0; i < respuestaPregunta.size(); i++) {
            if(respuestaPregunta.get(i) && respuesDelJugador.get(i))
                contador++;
            else if((! respuestaPregunta.get(i)) && respuesDelJugador.get(i))
                return 0;
        }
        return contador;
    }

}
