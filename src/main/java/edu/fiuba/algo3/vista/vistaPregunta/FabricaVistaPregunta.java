package edu.fiuba.algo3.vista.vistaPregunta;


import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.VistaGameOver;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import edu.fiuba.algo3.vista.cajas.CajaTimer;
import javafx.scene.Scene;


public class FabricaVistaPregunta {

    public Scene crearVista(Panel panel, String tipoPregunta, CajaJugadores cajaJugadores, CajaTimer cajaTimer) {
        switch (tipoPregunta) {
            case "preguntaMCConPenalidad":
            case "preguntaVoFConPenalidad":
                VistaPregunta vistaPregunta = new VistaPreguntaConPenalidad(panel, cajaJugadores, cajaTimer);
                return vistaPregunta.devolverVistaPregunta();
            case "preguntaGC":
                vistaPregunta = new VistaPreguntaGC(panel, cajaJugadores, cajaTimer);
                return vistaPregunta.devolverVistaPregunta();
            case "preguntaOC":
                vistaPregunta = new VistaPreguntaOC(panel, cajaJugadores, cajaTimer);
                return vistaPregunta.devolverVistaPregunta();
            case "preguntaVoFClasica":
            case "preguntaMCClasica":
            case "preguntaMCConPuntajeParcial":
                vistaPregunta = new VistaPreguntaClasica(panel, cajaJugadores, cajaTimer);
                return vistaPregunta.devolverVistaPregunta();
            default:
                VistaGameOver vistaGameOver = new VistaGameOver(panel);
                return vistaGameOver.devolverVistaGameOver();
        }
    }
}
