package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Observable;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador;

import java.util.*;

public abstract class Pregunta implements Observable {
    protected String tipoPregunta;
    protected Collection<String> opcionesCorrectas;
    protected Collection<String> todasLasOpciones;
    protected String textoPregunta;
    protected ArrayList<Observador> observadores = new ArrayList<>();

    public Pregunta(String tipoPregunta, String textoPregunta, String[] opcionesCorrectas) {
        this.tipoPregunta = tipoPregunta;
        this.opcionesCorrectas = new HashSet<>();
        Collections.addAll(this.opcionesCorrectas, opcionesCorrectas);
        this.textoPregunta = textoPregunta;
    }

    public Pregunta(String tipoPregunta, String textoPregunta, String[] opcionesCorrectas, Collection<String> todasLasOpciones) {
        this.tipoPregunta = tipoPregunta;
        this.opcionesCorrectas = new HashSet<>();
        Collections.addAll(this.opcionesCorrectas, opcionesCorrectas);
        this.textoPregunta = textoPregunta;
        this.todasLasOpciones = todasLasOpciones;
    }
    public Pregunta(String tipoPregunta, String textoPregunta, List opcionesCorrectas, Collection<String> todasLasOpciones) {
        this.tipoPregunta = tipoPregunta;
        this.opcionesCorrectas = new LinkedList<>(opcionesCorrectas);
        this.textoPregunta = textoPregunta;
        this.todasLasOpciones = todasLasOpciones;
    }


    public String obtenerPregunta() {
        return textoPregunta;
    }

    public Collection<String> obtenerTodasLasOpciones() {
        return todasLasOpciones;
    }

    public abstract Integer compararRespuestas(Collection<String> respuestasJugador);

    public void activarMultiplicador() {
        throw new ExcepcionSoloPreguntaConPenalidadPuedeUsarMultiplicador();
    }

    public void activarExclusividad() { }

    public String obtenerGrupoCorrecto(){
        return null;
    }

    public String obtenerTipoPregunta(){
        return tipoPregunta;
    }
    @Override
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }
    @Override
    public void notificarObservador() {
        observadores.stream().forEach(observer -> observer.actualizar());
    }
}
