package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;

public class Triplicador implements Multiplicador {
    private int triplicadoresDisponibles;

    public Triplicador(Integer triplicadoresDisponibles) {
        this.triplicadoresDisponibles = triplicadoresDisponibles;
        if (triplicadoresDisponibles <= 0)
            throw new ExcepcionYaUsasteTuTriplicadorSalame();
    }

    public Integer multiplicar(int puntos) {
        return puntos * 3;
    }
}
