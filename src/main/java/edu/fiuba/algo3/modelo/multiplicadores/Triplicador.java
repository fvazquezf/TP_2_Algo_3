package edu.fiuba.algo3.modelo.multiplicadores;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuTriplicadorSalame;

public class Triplicador implements Multiplicador {

    public Triplicador(Integer triplicadoresDisponibles) {
        if (triplicadoresDisponibles <= 0)
            throw new ExcepcionYaUsasteTuTriplicadorSalame();
    }

    public Integer multiplicar(int puntos) {
        return puntos * 3;
    }
}
