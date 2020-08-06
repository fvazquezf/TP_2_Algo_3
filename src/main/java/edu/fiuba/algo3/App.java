package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//        Parent root = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//
//        root = (Parent) FXMLLoader.load("prototipo2.fxml");
//
//        stage.setScene(new Scene(root, 600, 400));
//        stage.show();

        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("prototipo2.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        stage.setScene(new Scene(root));
        stage.show();


//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}