package co.unal.edu.Ejercicio6_8;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controladorEjercicio6_8 {

    @FXML
    private TextField txtRutaArchivo;

    @FXML
    private TextArea txtContenido;

    @FXML
    void cargarArchivo(ActionEvent event) {
        String ruta = txtRutaArchivo.getText();

        if (ruta.isEmpty()) {

            mostrarAlerta(AlertType.WARNING, "Ruta vacía", "Por favor, ingresa el nombre o la ruta del archivo.");
            return;

        }

        try {
            
            String textoLeido = LeerArchivo.leerContenido(ruta);
            txtContenido.setText(textoLeido);
            
        } catch (IOException e) {

            mostrarAlerta(AlertType.ERROR, "Error de lectura", "No se pudo leer el archivo. Verifica que '" + ruta + "' exista en la carpeta del proyecto.\nDetalle: " + e.getMessage());
            txtContenido.clear();

        }
    }

    @FXML
    void limpiar(ActionEvent event) {

        txtRutaArchivo.clear();
        txtContenido.clear();

    }

    private void mostrarAlerta(AlertType tipo, String titulo, String mensaje) {

        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
        
    }
}
