package edu.fiuba.algo3.modelo;

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


