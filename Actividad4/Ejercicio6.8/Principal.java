package co.unal.edu.Ejercicio6_8;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("ejercicio6_8")); 
        stage.setScene(scene);
        stage.setTitle("Lector de Archivos - Ejercicio 6.8");
        stage.getIcons().add(new javafx.scene.image.Image(Principal.class.getResourceAsStream("/co/unal/edu/escudo unal.png")));
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Principal.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
}
