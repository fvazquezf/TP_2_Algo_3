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
        String JsonTexto = null;
        List respuestasLeidas = new ArrayList();
        String textoPregunta = "\0";
        boolean respuestaCorrecta = true;

        try{
            JsonTexto = new String(Files.readAllBytes(Paths.get(archivo)));
        }
        catch (Exception e){
            e.printStackTrace();
        }

        JSONObject preguntasObj = new JSONObject(JsonTexto);

        JSONArray todasLasPreguntas = preguntasObj.getJSONArray("Preguntas");

        for(int i = 0; i < todasLasPreguntas.length(); i++){
            JSONObject unaPregunta =  todasLasPreguntas.getJSONObject(i);

            textoPregunta = unaPregunta.getString("Pregunta");
            JSONArray respuestasPosibles = unaPregunta.getJSONArray("PosiblesRespuestas");
            for(int j = 0; j < respuestasPosibles.length(); j++){
                respuestasLeidas.add(respuestasPosibles.getBoolean(j));
            }
            respuestaCorrecta = unaPregunta.getBoolean("RespuestaCorrecta");

        }

        Pregunta pregunta = new Pregunta(textoPregunta,respuestaCorrecta);
        preguntas = pregunta;
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
