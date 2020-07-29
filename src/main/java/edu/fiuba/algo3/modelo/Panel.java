package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Panel {
    private final FabricaPreguntas fabricaPreguntas = new FabricaPreguntas();
    private Pregunta preguntas;
    private final ArrayList <Jugador> jugadores;

    public Panel(){
        jugadores = new ArrayList<>();
    }
// NOTA: QUEDA COMENTADO HASTA REFACTORIZACIÓN DE JSON.
//    public void crearPreguntaVoFClasica(String archivo) {
//        LectorDeArchivo lector = new LectorDeArchivo();
//        preguntas = lector.leerArchivo(archivo);
//    }

    public void crearPregunta(String unTipoPregunta, String unaPregunta, ArrayList<Boolean> unaRespuesta) {
        try{
            preguntas = fabricaPreguntas.crearPregunta(unTipoPregunta, unaPregunta, unaRespuesta);
        }
        catch (ExcepcionTipoPreguntaInvalida e){
            // En un futuro hay que refactorizar para pasar a la siguiente pregunta.
            System.out.println("ERROR PREGUNTA INVALIDA");
        }
    }

    public void crearJugador(String unNombre) {
        jugadores.add(new Jugador(unNombre));
    }

    public String pasarPregunta(){ return preguntas.pasarPregunta();}


    public void hacerPregunta(ArrayList respuestasJugadores) {
        preguntas.hacerPregunta(jugadores, respuestasJugadores);
    }

    public ArrayList<Integer> pedirPuntos() {
        ArrayList<Integer> puntos = new ArrayList<>();
        for (int i = 0; i < jugadores.size(); i++){
            puntos.add(jugadores.get(i).pedirPuntos());
        }
        return puntos;
    }


}
