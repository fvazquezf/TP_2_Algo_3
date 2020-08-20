package edu.fiuba.algo3.modelo.exclusividad;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaActivasteTuExclusividadSalame;

public class ExclusividadDoble implements Exclusividad {

    public Integer multiplicar(int puntos) {
        return (puntos * 3);
    }

    public Exclusividad proximo() {
        throw new ExcepcionYaActivasteTuExclusividadSalame();
    }
}
