package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VistaPregunta implements Observador {

    private final Panel panel;
    private final Stage stage;

    public VistaPregunta(Panel panel, Stage stage){
        this.panel = panel;
        this.stage = stage;
    }


    public Scene devolverVistaPregunta(){

        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,100,10,100));

        CajaJugadores cajaJugadores = new CajaJugadores(panel);

        CajaPregunta cajaPregunta = new CajaPregunta(panel, stage);

        componentLayout.setCenter(cajaPregunta);
        componentLayout.setBottom(cajaJugadores);


        Scene scene = new Scene(componentLayout, 640, 480);
        return scene;
    }

    @Override
    public void actualizar() {

    }
}
