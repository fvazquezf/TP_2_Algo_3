package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Panel {

    private Pregunta preguntas;
    private final ArrayList <Jugador> jugadores;
    private ArrayList <Boolean> respuestas;
    private ArrayList <Boolean> puntosAAsignar;

    public Panel(){
        respuestas = new ArrayList();
        jugadores = new ArrayList();
        puntosAAsignar = new ArrayList<Boolean>();
    }
// NOTA: QUEDA COMENTADO HASTA REFACTORIZACIÓN DE JSON.
//    public void crearPreguntaVoFClasica(String archivo) {
//        LectorDeArchivo lector = new LectorDeArchivo();
//        preguntas = lector.leerArchivo(archivo);
//    }

    public void crearPreguntaVoFClasica(String unaPregunta, ArrayList<Boolean> unaRespuesta) {
        preguntas = new Pregunta(unaPregunta, unaRespuesta);
    }



    public void crearJugador(String unNombre) {
        jugadores.add(new Jugador(unNombre));
    }

    public String pasarPregunta(){ return preguntas.pasarPregunta();}


    public void hacerPregunta(ArrayList respuestasJugadores) {
        preguntas.hacerPregunta(jugadores, respuestasJugadores);

    }

    public ArrayList<Integer> pedirPuntos() {
        ArrayList<Integer> puntos = new ArrayList<Integer>();
        for (int i = 0; i < jugadores.size(); i++){
            puntos.add(jugadores.get(i).pedirPuntos());
        }
        return puntos;
    }
}
