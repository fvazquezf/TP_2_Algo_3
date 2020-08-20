package edu.fiuba.algo3.modelo.multiplicadores;

public class EstadoMultiplicador {

    private final Uniplicador uniplicador = new Uniplicador();
    private final Duplicador duplicador = new Duplicador();
    private final Triplicador triplicador = new Triplicador();
    private Multiplicador multiplicadorActual = uniplicador;

    public Integer multiplicar(int puntos) {
        puntos = multiplicadorActual.multiplicar(puntos);
        multiplicadorActual = uniplicador;
        return puntos;
    }

    public void activarDuplicador() {
        duplicador.cambiarEstado();
        multiplicadorActual = duplicador;
    }

    public void activarTriplicador() {
        triplicador.cambiarEstado();
        multiplicadorActual = triplicador;
    }
}
