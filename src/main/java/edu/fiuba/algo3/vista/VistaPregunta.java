package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class VistaPregunta implements Observador {

    private final Panel panel;

    public VistaPregunta(Panel panel){
        this.panel = panel;
    }


    public Scene devolverVistaPregunta(){

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        CajaJugadores cajaJugadores = new CajaJugadores(panel);

        CajaPregunta cajaPregunta = new CajaPregunta(panel);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);


        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }

    @Override
    public void actualizar() {

    }
}
