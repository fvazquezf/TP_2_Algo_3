package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.cajas.CajaJugadores;
import javafx.scene.Scene;


public class FabricaVistaPregunta {

    public Scene crearVista(Panel panel, String tipoPregunta, CajaJugadores cajaJugadores) {
        switch (tipoPregunta) {
            case "preguntaMCConPenalidad":
            case "preguntaVoFConPenalidad":
                VistaPregunta vistaPregunta = new VistaPreguntaConPenalidad(panel, cajaJugadores);
                return vistaPregunta.devolverVistaPregunta();
            case "preguntaGC":
                vistaPregunta = new VistaPreguntaGC(panel, cajaJugadores);
                return  vistaPregunta.devolverVistaPregunta();
            case "preguntaOC":
                vistaPregunta = new VistaPreguntaOC(panel, cajaJugadores);
                return  vistaPregunta.devolverVistaPregunta();
            case "preguntaVoFClasica":
            case "preguntaMCClasica":
            case "preguntaMCConPuntajeParcial":
                vistaPregunta = new VistaPreguntaClasica(panel, cajaJugadores);
                return  vistaPregunta.devolverVistaPregunta();
            default:
                VistaGameOver vistaGameOver = new VistaGameOver();
                return vistaGameOver.devolverVistaGameOver();
        }
    }
}
