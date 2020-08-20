package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Panel;
import edu.fiuba.algo3.modelo.excepciones.ExcepcionYaUsasteTuDuplicadorSalame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class ControladorActivarDuplicador implements EventHandler<ActionEvent> {
    private final Panel panel;

    public ControladorActivarDuplicador(Panel panel) {
        this.panel = panel;
    }

    public void handle(ActionEvent actionEvent) {
        try {
            panel.activarDuplicador();
        } catch (ExcepcionYaUsasteTuDuplicadorSalame e){
            Popup popup = new Popup();
            Label texto = new Label();
            texto.setText("Ya usaste tu duplicador salame");
            popup.getContent().add(texto);

            Node source = (Node)  actionEvent.getSource();
            Stage stage  = (Stage) source.getScene().getWindow();

            popup.show(stage);
        }
    }
}
