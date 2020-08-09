package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;

public class Duplicador implements Multiplicador {
    private int cantidadDuplicador = 1;

    public Integer multiplicar(int puntos) {
        return puntos * 2;
    }

    public void cambiarEstado() {
        if (cantidadDuplicador < 1)
            throw new ExcepcionYaUsasteTuDuplicadorSalame();
        cantidadDuplicador--;
    }
}
