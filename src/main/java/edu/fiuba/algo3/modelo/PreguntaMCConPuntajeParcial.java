package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaMCConPuntajeParcial extends Pregunta{

    public PreguntaMCConPuntajeParcial(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaConPuntajeParcial(unaRespuesta);
    }
}
