package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Panel {

    private final ArrayList <Jugador> jugadores;
    private Pregunta preguntas;
    private ArrayList <Boolean> respuestas;
    private ArrayList <Boolean> puntosAAsignar;

    public Panel(){
        respuestas = new ArrayList();
        jugadores = new ArrayList();
        puntosAAsignar = new ArrayList<Boolean>();
    }

    public void crearPreguntaVoFClasica(String unaPregunta, boolean unaRespuesta) {
        Pregunta pregunta = new Pregunta(unaPregunta,unaRespuesta);
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
            puntosAAsignar.add(preguntas.chequearRespuesta(respuestas.get(i)));
        }
    }

    public void asignarPuntos() {
        for (int i = 0; i < puntosAAsignar.size(); i++){
            jugadores.get(i).asignarPuntos(puntosAAsignar.get(i));
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
