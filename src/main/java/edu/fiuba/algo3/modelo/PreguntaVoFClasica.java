package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVoFClasica implements Pregunta{

    private final Respuesta respuesta;
    private final String textoPregunta;

    public PreguntaVoFClasica(String unaPregunta, ArrayList<Boolean> unaRespuesta){
        textoPregunta = unaPregunta;
        respuesta = new RespuestaClasica(unaRespuesta);
    }

    public String pasarPregunta() {
        return textoPregunta;
    }

    public void hacerPregunta(ArrayList<Jugador> jugadores, ArrayList<String> respuestasJugadores) {
        for (int i = 0; i < jugadores.size(); i++){
            jugadores.get(i).responder(respuesta,respuestasJugadores.get(i));
        }
    }
}
