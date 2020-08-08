package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;
import edu.fiuba.algo3.modelo.multiplicadores.Duplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Triplicador;
import edu.fiuba.algo3.modelo.multiplicadores.Uniplicador;

public class Jugador {

    private final String nombre;
    private int puntos;
    private Multiplicador multiplicador;
    boolean duplicadorDisponible = true;
    boolean triplicadorDisponible = true;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        multiplicador = new Uniplicador();
    }

    public int pedirPuntos() {
        return puntos;
    }

    public void estadoDuplicador() {
        if (duplicadorDisponible) multiplicador = new Duplicador();
        else throw new ExcepcionYaUsasteTuDuplicadorSalame();
        duplicadorDisponible = false;
    }

    public void estadoTriplicador() {
        if (triplicadorDisponible) multiplicador = new Triplicador();
        else throw new ExcepcionYaUsasteTuTriplicadorSalame();
        triplicadorDisponible = false;
    }

    public void asignarPuntos(int puntos) {
        this.puntos += multiplicador.multiplicar(puntos);
        multiplicador = new Uniplicador();
    }
}


