package edu.fiuba.algo3.modelo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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

    public void crearPreguntaVoFClasica(String archivo) {
        LectorDeArchivo lector = new LectorDeArchivo();
        preguntas = lector.leerArchivo(archivo);
    }

    public boolean pasarRespuesta() {
        return preguntas.pasarRespuesta();
    }

    public String pasarPregunta(){ return preguntas.pasarPregunta();}


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
