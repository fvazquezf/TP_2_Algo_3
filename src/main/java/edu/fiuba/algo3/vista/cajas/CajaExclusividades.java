package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.botones.BotonExclusividad;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CajaExclusividades extends VBox implements Observador {


    public CajaExclusividades(Panel panel){
        Button botonExclusividad = new BotonExclusividad(panel);

        this.getChildren().addAll(botonExclusividad);
    }



    @Override
    public void actualizar() {

    }
}
