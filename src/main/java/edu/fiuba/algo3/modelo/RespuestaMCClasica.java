//package edu.fiuba.algo3.modelo;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class RespuestaMCClasica implements Respuesta{
//
//    private final HashMap<Integer,Boolean> respuestas = new HashMap<Integer, Boolean>();
//
//    public RespuestaMCClasica(ArrayList<Boolean> unasRespuestas){
//
//        for(int i =0; i < unasRespuestas.size(); i++)
//            respuestas.put(i,unasRespuestas.get(i));
//    }
//
//    public Integer responder(String unaRespuesta){
//        return (CalculadorPuntajeClasico.obtenerCalculadorClasico().calcular(respuestas.get(unaRespuesta)));
//    }
//}