package edu.fiuba.algo3.modelo.multiplicadores;

public class EstadoMultiplicador {

    private Uniplicador uniplicador = new Uniplicador();
    private Duplicador duplicador = new Duplicador(1);
    private Triplicador triplicador = new Triplicador();
    private Duplicador exclusividad = new Duplicador(2);
    private Multiplicador multiplicadorActual = uniplicador;

    public EstadoMultiplicador() {
    }

    public Integer multiplicar(int puntos) {
        puntos = multiplicadorActual.multiplicar(puntos);
        multiplicadorActual = uniplicador;
        return puntos;
    }

    public void estadoDuplicador() {
        duplicador.cambiarEstado();
        multiplicadorActual = duplicador;
    }

    public void estadoTriplicador() {
        triplicador.cambiarEstado();
        multiplicadorActual = triplicador;
    }

    public void estadoExclusividad() {
        exclusividad.cambiarEstado();
        multiplicadorActual = exclusividad;
    }
}
