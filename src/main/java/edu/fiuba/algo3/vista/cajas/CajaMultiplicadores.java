package edu.fiuba.algo3.vista.cajas;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.vista.botones.BotonDuplicador;
import edu.fiuba.algo3.vista.botones.BotonTriplicador;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class CajaMultiplicadores extends VBox {
    public CajaMultiplicadores(Panel panel){
        Button botonDuplicador = new BotonDuplicador(panel);
        Button botonTriplicador = new BotonTriplicador(panel);

        this.getChildren().addAll(botonDuplicador, botonTriplicador);
    }
}
