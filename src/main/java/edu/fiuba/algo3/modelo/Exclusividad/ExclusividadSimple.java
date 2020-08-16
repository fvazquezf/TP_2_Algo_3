package edu.fiuba.algo3.modelo.Exclusividad;

public class ExclusividadSimple implements Exclusividad {
    public Integer multiplicar(int puntos) {
        return (puntos);
    }

    public Exclusividad proximo() {
        return new ExclusividadDoble();
    }
}
