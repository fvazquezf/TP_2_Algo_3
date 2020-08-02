//package edu.fiuba.algo3.modelo;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//
//public class PreguntaMCPuntajeConPenalidadlTest {
//    @Test
//    public void Test01CrearMCCon3PosiblesRespuestas() {
//
//        List<Boolean> respuestas = new ArrayList<>();
//        respuestas.add(true);
//        respuestas.add(false);
//        respuestas.add(false);
//
//        Panel panel = new Panel();
//        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);
//
//        assertEquals("De que color era el caballo blanco de San Martin?", panel.pasarPregunta());
//    }
//
//    @Test
//    public void Test02PreguntaMCCon3PosiblesRespuestasYAsignaPuntosCorrectamenteALosJugadores() {
//
//        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
//        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();
//
//        respuestasJ1.put(0, true);
//        respuestasJ1.put(1, false);
//        respuestasJ1.put(2, false);
//
//        respuestasJ2.put(0, false);
//        respuestasJ2.put(1, true);
//        respuestasJ2.put(2, false);
//
//        List<HashMap<Integer, Boolean>> respuestasJugadores = new ArrayList<>();
//        respuestasJugadores.add(respuestasJ1);
//        respuestasJugadores.add(respuestasJ2);
//
//        List<Integer> puntosEsperados = new ArrayList<>();
//        puntosEsperados.add(1);
//        puntosEsperados.add(-1);
//
//        List<Boolean> respuestas = new ArrayList<>();
//        respuestas.add(true);
//        respuestas.add(false);
//        respuestas.add(false);
//
//        Panel panel = new Panel();
//
//        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);
//
//        panel.crearJugador("Rulo");
//        panel.crearJugador("Stef");
//
//        panel.hacerPregunta(respuestasJugadores);
//
//        assertEquals(puntosEsperados, panel.pedirPuntos());
//    }
//
//
//    @Test
//    public void Test03PreguntaMCCon5posiblesRespuestasY3CorrectasYAsignaPuntosCorrectamenteALosJugadores() {
//
//        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
//        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();
//
//        respuestasJ1.put(0, true);
//        respuestasJ1.put(1, true);
//        respuestasJ1.put(2, false);
//        respuestasJ1.put(3, false);
//        respuestasJ1.put(4, false);
//
//        respuestasJ2.put(0, true);
//        respuestasJ2.put(1, true);
//        respuestasJ2.put(2, true);
//        respuestasJ2.put(3, false);
//        respuestasJ2.put(4, true);
//
//        List<HashMap<Integer, Boolean>> respuestasJugadores = new ArrayList<>();
//        respuestasJugadores.add(respuestasJ1);
//        respuestasJugadores.add(respuestasJ2);
//
//        List<Integer> puntosEsperados = new ArrayList<>();
//        puntosEsperados.add(2); //recibe 2 puntos por responder correctamente 2 veces. sin errores
//        puntosEsperados.add(2); //recibe 2 puntos por haber contestado 3 bien, un error
//
//        List<Boolean> respuestas = new ArrayList<>();
//        respuestas.add(true);
//        respuestas.add(true);
//        respuestas.add(false);
//        respuestas.add(false);
//        respuestas.add(true);
//
//        Panel panel = new Panel();
//
//        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);
//
//        panel.crearJugador("Rulo");
//        panel.crearJugador("Stef");
//
//        panel.hacerPregunta(respuestasJugadores);
//
//        assertEquals(puntosEsperados, panel.pedirPuntos());
//    }
//
//    @Test
//    public void Test04PreguntaMCCon5posiblesRespuestasY1CorrectaYAsignaPuntosCorrectamenteALosJugadores() {
//
//        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
//        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();
//
//        respuestasJ1.put(0, true);
//        respuestasJ1.put(1, true);
//        respuestasJ1.put(2, true);
//        respuestasJ1.put(3, false);
//        respuestasJ1.put(4, true);
//
//        respuestasJ2.put(0, true);
//        respuestasJ2.put(1, true);
//        respuestasJ2.put(2, false);
//        respuestasJ2.put(3, true);
//        respuestasJ2.put(4, true);
//
//        List<HashMap<Integer, Boolean>> respuestasJugadores = new ArrayList<>();
//        respuestasJugadores.add(respuestasJ1);
//        respuestasJugadores.add(respuestasJ2);
//
//        List<Integer> puntosEsperados = new ArrayList<>();
//        puntosEsperados.add(-2); //recibe 1 punto por responder correctamente 1 vez. 3 errores
//        puntosEsperados.add(-4); //recibe -4 puntos por tener 4 errores.
//
//        List<Boolean> respuestas = new ArrayList<>();
//        respuestas.add(false);
//        respuestas.add(false);
//        respuestas.add(true);
//        respuestas.add(false);
//        respuestas.add(false);
//
//        Panel panel = new Panel();
//
//        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);
//
//        panel.crearJugador("Rulo");
//        panel.crearJugador("Stef");
//
//        panel.hacerPregunta(respuestasJugadores);
//
//        assertEquals(puntosEsperados, panel.pedirPuntos());
//    }
//
//    @Test
//    public void Test05PreguntaMCCon5posiblesRespuestasY5CorrectasYAsignaPuntosCorrectamenteALosJugadores() {
//
//        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
//        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();
//
//        respuestasJ1.put(0, true);
//        respuestasJ1.put(1, true);
//        respuestasJ1.put(2, true);
//        respuestasJ1.put(3, true);
//        respuestasJ1.put(4, true);
//
//        respuestasJ2.put(0, false);
//        respuestasJ2.put(1, false);
//        respuestasJ2.put(2, false);
//        respuestasJ2.put(3, false);
//        respuestasJ2.put(4, false);
//
//        List<HashMap<Integer, Boolean>> respuestasJugadores = new ArrayList<>();
//        respuestasJugadores.add(respuestasJ1);
//        respuestasJugadores.add(respuestasJ2);
//
//        List<Integer> puntosEsperados = new ArrayList<>();
//        puntosEsperados.add(5); //recibe 5 puntos por responder correctamente 5 veces. 0 errores
//        puntosEsperados.add(0); //recibe 0 puntos por no contestar
//
//        List<Boolean> respuestas = new ArrayList<>();
//        respuestas.add(true);
//        respuestas.add(true);
//        respuestas.add(true);
//        respuestas.add(true);
//        respuestas.add(true);
//
//        Panel panel = new Panel();
//
//        panel.crearPregunta("preguntaMCConPenalidad", "De que color era el caballo blanco de San Martin?", respuestas);
//
//        panel.crearJugador("Rulo");
//        panel.crearJugador("Stef");
//
//        panel.hacerPregunta(respuestasJugadores);
//
//        assertEquals(puntosEsperados, panel.pedirPuntos());
//    }
//
//}
