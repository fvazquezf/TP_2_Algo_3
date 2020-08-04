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
    boolean duplicador = true;
    boolean triplicador = true;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = 0;
        multiplicador = new Uniplicador();
    }

    public int pedirPuntos() {
        return puntos;
    }

    public void estadoDuplicador() {
        if (duplicador) multiplicador = new Duplicador();
        else throw new ExcepcionYaUsasteTuDuplicadorSalame();
        duplicador = false;
    }

    public void estadoTriplicador() {
        if (triplicador) multiplicador = new Triplicador();
        else throw new ExcepcionYaUsasteTuTriplicadorSalame();
        triplicador = false;
    }

    public Integer multiplicarPuntos(int puntos) {
        return multiplicador.multiplicar(puntos);
    }

    public void asignarPuntos(int puntos) {
        this.puntos += this.multiplicarPuntos(puntos);
        multiplicador = new Uniplicador();
    }
}


