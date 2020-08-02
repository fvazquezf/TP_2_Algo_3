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
//public class PreguntaVoFConPenalidadTest {
//
//    @Test
//    public void Test01PreguntaVerdaderoFalsoConPenalidadAsignaPuntosCorrectamente() {
//
//        HashMap<Integer, Boolean> respuestasJ1 = new HashMap<>();
//        HashMap<Integer, Boolean> respuestasJ2 = new HashMap<>();
//
//        respuestasJ1.put(0, true);
//        respuestasJ1.put(1, false);
//
//        respuestasJ2.put(0, false);
//        respuestasJ2.put(1, true);
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
//
//        Panel panel = new Panel();
//        panel.crearPregunta("preguntaVoFConPenalidad", "El Caballo blanco de San Martin era Blanco?", respuestas);
//
//        panel.crearJugador("Rulo");
//        panel.crearJugador("Stef");
//
//        panel.hacerPregunta(respuestasJugadores);
//
//        assertEquals(puntosEsperados, panel.pedirPuntos());
//
//    }
//}
