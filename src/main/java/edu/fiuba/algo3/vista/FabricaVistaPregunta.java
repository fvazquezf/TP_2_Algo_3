package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.modelo.Panel;
import javafx.scene.Scene;

public class FabricaVistaPregunta {

    public Scene crearVista(Panel panel, String tipoPregunta) {
        switch (tipoPregunta) {
            case "preguntaGC":
                VistaPregunta vistaPregunta = new VistaPreguntaGC(panel);
                return  vistaPregunta.devolverVistaPregunta();
            case "preguntaOC":
                vistaPregunta = new VistaPreguntaOC(panel);
                return  vistaPregunta.devolverVistaPregunta();
            default:
                vistaPregunta = new VistaPreguntaClasica(panel);
                return  vistaPregunta.devolverVistaPregunta();
        }
    }
}