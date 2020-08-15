package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;

public class Triplicador implements Multiplicador {
    private int cantidadTriplicador = 1;

    public Integer multiplicar(int puntos) {
        return puntos * 3;
    }

    public void cambiarEstado() {
        if (cantidadTriplicador < 1)
            throw new ExcepcionYaUsasteTuTriplicadorSalame();
        cantidadTriplicador--;
    }
}
