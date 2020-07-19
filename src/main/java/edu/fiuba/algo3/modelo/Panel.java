package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Panel {

    private final ArrayList <Jugador> jugadores;
    private Pregunta preguntas;
    private ArrayList <Boolean> respuestas;

    public Panel(){
        respuestas = new ArrayList();
        jugadores = new ArrayList();
    }

    public void crearPreguntaVoFClasica(String s, boolean b) {
        Pregunta pregunta = new Pregunta(s,b);
        preguntas = pregunta;
    }

    public boolean pasarRespuesta() {
        return preguntas.pasarRespuesta();
    }


    public void pedirRespuestas() {
        for (int i = 0; i < jugadores.size(); i++) {
            respuestas.add(jugadores.get(i).responder(i == 0));
        }
    }

    public void chequearRespuestas() {
        for (int i = 0; i < respuestas.size(); i++){
            jugadores.get(i).asignarPuntos(preguntas.chequearRespuesta((Boolean) respuestas.get(i)));
        }
    }

    public void crearJugador(String unNombre) {
        jugadores.add(new Jugador(unNombre));
    }

    public ArrayList<Integer> pedirPuntos() {
        ArrayList<Integer> puntos = new ArrayList<Integer>();
        for (int i = 0; i < jugadores.size(); i++){
            puntos.add(jugadores.get(i).pedirPuntos());
        }
        return puntos;
    }
}
