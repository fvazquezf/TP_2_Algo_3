package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteLasExclusividadesSalame;
import edu.fiuba.algo3.modelo.exclusividad.EstadoExclusividad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EstadoExclusividadTest {

    @Test
    public void test01CreoDosJugadoresElPrimeroActivaExlusividadRespondeBienYSeLeAsignaElDobleDePuntos() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");

        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();

        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(1);
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta(jugador1, 1);
        estadoExclusividad.guardarRespuesta(jugador2, 0);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(2, jugador1.pedirPuntos());

    }

    @Test
    public void test02CreoDosJugadoresLosDosActivanExlusividadElPrimeroRespondeBienYSeLeAsignaElCuadrupleDePuntos() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(2);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta(jugador1, 2);
        estadoExclusividad.guardarRespuesta(jugador2, 0);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(8, jugador1.pedirPuntos());

    }

    @Test
    public void test03CreoDosJugadoresElPrimeroActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElDobleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(0);

        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta(jugador1, 0);
        estadoExclusividad.guardarRespuesta(jugador2, 3);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(6, jugador2.pedirPuntos());

    }

    @Test
    public void test04CreoDosJugadoresAmbosActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElCuadrupleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta(jugador1, 0);
        estadoExclusividad.guardarRespuesta(jugador2, 3);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(12, jugador2.pedirPuntos());
    }

    @Test
    public void test05CreoDosJugadoresElSegundoActivaExlusividadElPrimeroRespondeMalYSeLeAsignaElDobleDePuntosAlSegundo() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(2);

        estadoExclusividad.guardarRespuesta(jugador1, 0);
        estadoExclusividad.guardarRespuesta(jugador2, 2);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(4, jugador2.pedirPuntos());
    }

    @Test
    public void test06CreoDosJugadoresElSegundoActivaExlusividadElPrimeroRespondeBienYSeLeAsignaElDobleDePuntosAlPrimero() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.asignarPuntos(3);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta(jugador1, 3);
        estadoExclusividad.guardarRespuesta(jugador2, 0);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void test07CreoDosJugadoresElSegundoActivaExlusividadElAmbosRespondeBienYLosPuntosQuedanIguales() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.asignarPuntos(2);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(2);

        estadoExclusividad.guardarRespuesta(jugador1, 2);
        estadoExclusividad.guardarRespuesta(jugador2, 2);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(2, jugador1.pedirPuntos());
        assertEquals(2, jugador2.pedirPuntos());
    }

    @Test
    public void test08CreoDosJugadoresElSegundoActivaExlusividadElAmbosRespondeMalYLosPuntosQuedanEnCero() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.asignarPuntos(0);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(0);

        estadoExclusividad.guardarRespuesta(jugador1, 0);
        estadoExclusividad.guardarRespuesta(jugador2, 0);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(0, jugador1.pedirPuntos());
        assertEquals(0, jugador2.pedirPuntos());
    }

    @Test
    public void test09CreoDosJugadoresAmbosActivaExlusividadElAmbosRespondeBienYLosPuntosNoSeMultiplican() {
        Jugador jugador1 = new Jugador("Fran");
        Jugador jugador2 = new Jugador("Lu");


        EstadoExclusividad estadoExclusividad = new EstadoExclusividad();


        jugador1.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador1.asignarPuntos(3);

        jugador2.activarExclusividad();
        estadoExclusividad.activarExclusividad();
        jugador2.asignarPuntos(3);

        estadoExclusividad.guardarRespuesta(jugador1, 3);
        estadoExclusividad.guardarRespuesta(jugador2, 3);

        estadoExclusividad.calcularExclusividad(jugador1, jugador2);

        assertEquals(3, jugador1.pedirPuntos());
        assertEquals(3, jugador2.pedirPuntos());
    }

    @Test
    public void test10CreoUnJugadorYTrataDeUsarTresVecesLaExclusividadYSaltaExcepcion() {
        Jugador jugador1 = new Jugador("Fran");

        jugador1.activarExclusividad();
        jugador1.activarExclusividad();

        assertThrows(ExcepcionYaUsasteLasExclusividadesSalame.class, jugador1::activarExclusividad);
    }
}
