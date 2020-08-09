package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JugadorTest {
    @Test
    public void Test01AsignoTresPuntosAJugadorNoUsaMultiplicadorDevuelveTresPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.asignarPuntos(3);
        assertEquals(3, jugador1.pedirPuntos());
    }

    @Test
    public void Test02AsignoTresPuntosAJugadorUsaDuplicadorDevuelveSeisPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(3);
        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void Test03AsignoUnPuntoAJugadorUsaDuplicadorDevuelveDosPuntosYNoPuedeVolverAUsarDuplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(3);

        boolean seLanzoError = false;

        try {
            jugador1.estadoDuplicador();
        } catch (ExcepcionYaUsasteTuDuplicadorSalame e) {
            seLanzoError = true;
        }

        assert (seLanzoError);
    }

    @Test
    public void Test04AsignoUnPuntoAJugadorUsaDuplicadorYVuelveAUniplicadorYAsignoCincoPuntosDevuelveSietePuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoDuplicador();
        jugador1.asignarPuntos(1);
        jugador1.asignarPuntos(5);
        assertEquals(7, jugador1.pedirPuntos());
    }

    @Test
    public void Test05AsignoDosPuntosAJugadorUsaTriplicadorDevuelveSeisPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(2);
        assertEquals(6, jugador1.pedirPuntos());
    }

    @Test
    public void Test06AsignoUnPuntoAJugadorUsaTriplicadorDevuelveTresPuntosYNoPuedeVolverAUsarTriplicador() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(1);

        boolean seLanzoError = false;

        try {
            jugador1.estadoTriplicador();
        } catch (ExcepcionYaUsasteTuTriplicadorSalame e) {
            seLanzoError = true;
        }

        assert (seLanzoError);
    }

    @Test
    public void Test07AsignoUnPuntoAJugadorUsaTriplicadorYVuelveAUniplicadorAsignoDosPuntosYDevuelveCincoPuntos() {
        Jugador jugador1 = new Jugador("Rulo");
        jugador1.estadoTriplicador();
        jugador1.asignarPuntos(1);
        jugador1.asignarPuntos(2);
        assertEquals(5, jugador1.pedirPuntos());
    }
}
