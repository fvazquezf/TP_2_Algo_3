package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class CajaExclusividades extends VBox implements Observador {

    private Button botonExclusividad;

    public CajaExclusividades(Panel panel){
        botonExclusividad = new BotonExclusividad(panel);

        this.getChildren().addAll(botonExclusividad);
    }



    @Override
    public void actualizar() {
        botonExclusividad.setDisable(true);
    }
}
