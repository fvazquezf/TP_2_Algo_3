package edu.fiuba.algo3.modelo.comportamientos;

import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;

import java.util.Collection;


public interface Comportamiento {

    public abstract Integer compararRespuestas(Collection<String> opcionesJugador, Collection<String> opcionesCorrectas);

//    public void activarMultiplicador() {
//        throw new ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador();
//    }
//
//    public void activarExclusividad() {
//    }
}
