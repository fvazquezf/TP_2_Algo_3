package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.Timer;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vista.botones.BotonCajaOpcionesGC;
import edu.fiuba.algo3.vista.botones.BotonOpcionGC;
import edu.fiuba.algo3.vista.botones.BotonResponderGC;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Collection;
import java.util.HashSet;

public class CajaPreguntaGC extends HBox implements Observador {
    private Collection<String> respuestasJugador;
    private Collection<String> respuestasDelOtroGrupo;
    private Pregunta pregunta;
    private Label labelPregunta;
    private VBox cajaOpciones;
    private Button botonResponder;
    private HBox hb;


    public CajaPreguntaGC(Panel panel, Collection<String> respuestasJugador, Timer timer) {
        super();

        this.respuestasJugador = respuestasJugador;

        this.respuestasDelOtroGrupo = new HashSet<>();

        this.pregunta = panel.obtenerPreguntaActual();

        labelPregunta = new Label(pregunta.obtenerPregunta());


        VBox cajaGrupoCorrecto = new VBox();
        BotonCajaOpcionesGC grupoCorrecto = new BotonCajaOpcionesGC(pregunta.obtenerGrupoCorrecto(), respuestasJugador, cajaGrupoCorrecto);
        cajaGrupoCorrecto.getChildren().add(grupoCorrecto);

        VBox cajaGrupoincorrecto = new VBox();
        BotonCajaOpcionesGC grupoIncorrecto = new BotonCajaOpcionesGC(pregunta.obtenerGrupoIncorrecto(), respuestasDelOtroGrupo, cajaGrupoincorrecto);
        cajaGrupoincorrecto.getChildren().add(grupoIncorrecto);

        cajaOpciones = new VBox();

        pregunta.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcionGC(o));});

        botonResponder = new BotonResponderGC(panel, respuestasJugador, respuestasDelOtroGrupo, timer);

        hb = new HBox();
        hb.setSpacing(10);
        hb.getChildren().addAll(cajaGrupoCorrecto, cajaOpciones, cajaGrupoincorrecto);

        VBox vb = new VBox();
        vb.setSpacing(25);
        vb.getChildren().addAll(labelPregunta, hb, botonResponder);

        this.getChildren().addAll(vb);
    }

    @Override
    public void actualizar() {
        respuestasJugador.removeAll(pregunta.obtenerTodasLasOpciones());
        respuestasDelOtroGrupo.clear();

        VBox cajaGrupoCorrecto = new VBox();
        BotonCajaOpcionesGC grupoCorrecto = new BotonCajaOpcionesGC(pregunta.obtenerGrupoCorrecto(), respuestasJugador, cajaGrupoCorrecto);
        cajaGrupoCorrecto.getChildren().add(grupoCorrecto);

        VBox cajaGrupoincorrecto = new VBox();
        BotonCajaOpcionesGC grupoIncorrecto = new BotonCajaOpcionesGC(pregunta.obtenerGrupoIncorrecto(), respuestasDelOtroGrupo, cajaGrupoincorrecto);
        cajaGrupoincorrecto.getChildren().add(grupoIncorrecto);

        cajaOpciones = new VBox();

        pregunta.obtenerTodasLasOpciones().stream().forEach((o)-> { cajaOpciones.getChildren().add(new BotonOpcionGC(o));});

        hb.getChildren().clear();
        hb.getChildren().addAll(cajaGrupoCorrecto, cajaOpciones, cajaGrupoincorrecto);
    }
}
