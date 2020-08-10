package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteLasExclusividadesSalame;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstadoExclusividadTest {

    @Test
    public void test01CreoDosJugadoresElPrimeroActivaExlusividadRespondeBienYSeLeAsignaElDobleDePuntos() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(1);
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta("Fran", 1);
        estadoExclusividad.guardarRespuesta("Lu", 0);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(2,jugador1.pedirPuntos());

    }

    @Test
    public void test02CreoDosJugadoresLosDosActivanExlusividadElPrimeroRespondeBienYSeLeAsignaElCuadrupleDePuntos() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(2);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta("Fran", 2);
        estadoExclusividad.guardarRespuesta("Lu", 0);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(8,jugador1.pedirPuntos());

    }

    @Test
    public void test03CreoDosJugadoresElPrimeroActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElDobleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(0);

        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta("Fran", 0);
        estadoExclusividad.guardarRespuesta("Lu", 3);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(6,jugador2.pedirPuntos());

    }

    @Test
    public void test04CreoDosJugadoresAmbosActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElCuadrupleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta("Fran", 0);
        estadoExclusividad.guardarRespuesta("Lu", 3);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(12,jugador2.pedirPuntos());
    }

    @Test
    public void test05CreoDosJugadoresElSegundoActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElDobleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(2);

        estadoExclusividad.guardarRespuesta("Fran", 0);
        estadoExclusividad.guardarRespuesta("Lu", 2);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(4,jugador2.pedirPuntos());
    }

    @Test
    public void test06CreoDosJugadoresElSegundoActivaExlusividadElPrimeroRespondeBienYSeLeAsignaElDobleDePuntosAlPrimero() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.asignarPuntos(3);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta("Fran", 3);
        estadoExclusividad.guardarRespuesta("Lu", 0);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(6,jugador1.pedirPuntos());
    }

    @Test
    public void test07CreoDosJugadoresElSegundoActivaExlusividadElAmbosRespondeBienYLosPuntosQuedanIguales() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.asignarPuntos(2);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(2);

        estadoExclusividad.guardarRespuesta("Fran", 2);
        estadoExclusividad.guardarRespuesta("Lu", 2);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(2,jugador1.pedirPuntos());
        assertEquals(2,jugador2.pedirPuntos());
    }

    @Test
    public void test08CreoDosJugadoresElSegundoActivaExlusividadElAmbosRespondeMalYLosPuntosQuedanEnCero() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta("Fran", 0);
        estadoExclusividad.guardarRespuesta("Lu", 0);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(0,jugador1.pedirPuntos());
        assertEquals(0,jugador2.pedirPuntos());
    }

    @Test
    public void test09CreoDosJugadoresAmbosActivaExlusividadElAmbosRespondeBienYLosPuntosNoSeMultiplican() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");
        HashMap<String, Jugador> jugadores = new HashMap<String, Jugador>();

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugadores.put("Fran", jugador1);
        jugadores.put("Lu", jugador2);

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(3);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta("Fran", 3);
        estadoExclusividad.guardarRespuesta("Lu", 3);

        estadoExclusividad.calcularExclusividad(jugadores);

        assertEquals(3,jugador1.pedirPuntos());
        assertEquals(3,jugador2.pedirPuntos());
    }

    @Test
    public void test10CreoUnJugadorYTrataDeUsarTresVecesLaExclusividadYSaltaExcepcion() {
        Jugador jugador1 = new Jugador("Fran");
        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

        jugador1.activarExclusividad();
        jugador1.activarExclusividad();

        assertThrows(ExcepcionYaUsasteLasExclusividadesSalame.class, jugador1::activarExclusividad);
    }
}
